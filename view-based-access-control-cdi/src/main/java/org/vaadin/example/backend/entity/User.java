package org.vaadin.example.backend.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public class User extends AbstractEntity {

    private final String userName;

    private final String password;

    @ElementCollection
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
