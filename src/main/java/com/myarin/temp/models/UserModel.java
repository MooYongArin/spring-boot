package com.myarin.temp.models;

public class UserModel {
    // name, email
    private String id;
    private String name;
    private String email;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = java.util.UUID.randomUUID().toString();
    }

    public UserModel(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
