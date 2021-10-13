package me.mduarteg.pixelsuite.data;

public class AuthResponse {
    public String token;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
