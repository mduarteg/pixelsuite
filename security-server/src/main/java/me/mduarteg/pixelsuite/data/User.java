package me.mduarteg.pixelsuite.data;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDateTime;
import java.util.Set;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

    public String username;
    public String password;
    public Set<Role> roles;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public User() {
    }

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static User findByUsername(String username) {
        return find("username", username).firstResult();
    }
}
