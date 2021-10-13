package me.mduarteg.pixelsuite.api;

import me.mduarteg.pixelsuite.data.AuthRequest;
import me.mduarteg.pixelsuite.data.AuthResponse;
import me.mduarteg.pixelsuite.data.Role;
import me.mduarteg.pixelsuite.data.User;
import me.mduarteg.pixelsuite.utils.PBKDF2Encoder;
import me.mduarteg.pixelsuite.utils.TokenUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;

@Path("/user")
public class SecurityResource {
    @Inject
    private PBKDF2Encoder passwordEncoder;

    @ConfigProperty(name = "me.mduarteg.pixelsuite.jwt.duration")
    private Long duration;

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    public String issuer;

    @PermitAll
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(AuthRequest authRequest) {
        User user = User.findByUsername(authRequest.user);
        user.roles = Collections.singleton(Role.USER);
        String encodedPass = passwordEncoder.encode(authRequest.password);

        if (user.password.equals(encodedPass)) {
            try {
                return Response
                        .ok(
                                new AuthResponse(
                                        TokenUtils.generateToken(user.username, user.roles, duration, issuer)
                                )
                        ).build();
            } catch (IOException | InvalidKeySpecException | NoSuchAlgorithmException e) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
