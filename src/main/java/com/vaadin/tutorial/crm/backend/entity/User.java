package com.vaadin.tutorial.crm.backend.entity;

import java.util.Collection;

public class User {

    private final String userName;

    private final String password;

    private final Collection<String> roles;

    public User(String userName, String password, Collection<String> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Collection<String> getRoles() {
        return roles;
    }
}
