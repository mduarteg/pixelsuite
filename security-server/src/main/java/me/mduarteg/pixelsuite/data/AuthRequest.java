package me.mduarteg.pixelsuite.data;

public class AuthRequest {
    public String user;
    public String password;

    public AuthRequest() {
    }

    public AuthRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
