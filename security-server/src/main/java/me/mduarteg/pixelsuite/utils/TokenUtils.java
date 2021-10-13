package me.mduarteg.pixelsuite.utils;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import me.mduarteg.pixelsuite.data.Role;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class TokenUtils {
    public static String generateToken(String username, Set<Role> roles, long duration, String issuer) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        String privateKeyLocation = "/pxs-pvt.pem";
        PrivateKey privateKey = readPrivateKey(privateKeyLocation);

        JwtClaimsBuilder claimsBuilder = Jwt.claims();
        long currentTimeInSecs = currentTimeInSecs();

        Set<String> groups = new HashSet<>();

        for (Role role : roles) {
            groups.add(role.toString());
        }

        claimsBuilder.issuer(issuer);
        claimsBuilder.subject(username);
        claimsBuilder.issuedAt(currentTimeInSecs);
        claimsBuilder.expiresAt(currentTimeInSecs + duration);
        claimsBuilder.groups(groups);

        return claimsBuilder.jws().signatureKeyId(privateKeyLocation).sign(privateKey);
    }

    private static PrivateKey readPrivateKey(final String privateKeyLocation) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        try (InputStream is = TokenUtils.class.getResourceAsStream(privateKeyLocation)) {
            byte[] tmp = new byte[4096];
            int length = is.read(tmp);

            return decodePrivateKey(new String(tmp, 0, length, StandardCharsets.UTF_8));
        }
    }

    private static PrivateKey decodePrivateKey(final String pemEncoded) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] encodedByte = toEncodedBytes(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedByte);
        KeyFactory kf = KeyFactory.getInstance("RSA");

        return kf.generatePrivate(keySpec);
    }

    private static byte[] toEncodedBytes(final String pemEncoded) {
        final String normalizedPem = removeBeginEnd(pemEncoded);

        return Base64.getDecoder().decode(normalizedPem);
    }

    private static String removeBeginEnd(String pem) {
        pem = pem.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        return pem.trim();
    }

    public static int currentTimeInSecs() {
        long currentTimeMS = System.currentTimeMillis();
        return (int) (currentTimeMS / 1000);
    }
}
