package com.caer.recapspring.Model;

import java.util.UUID;

public class User {
    private String username;
    private String id;

    public User() {
        if (id == null) {
            id = UUID.randomUUID().toString(); //unique worldwide
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
