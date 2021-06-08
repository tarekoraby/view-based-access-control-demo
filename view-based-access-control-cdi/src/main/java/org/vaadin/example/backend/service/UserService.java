package org.vaadin.example.backend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.vaadin.example.backend.entity.User;

import com.vaadin.cdi.annotation.VaadinServiceScoped;

@VaadinServiceScoped
public class UserService {

    private static final Collection<User> users = new ArrayList<>(2);

    static {
        User user = new User("user", "user", Collections.singleton("USER"));
        users.add(user);

        User admin = new User("admin", "admin", Collections.singleton("ADMIN"));
        users.add(admin);
    }

    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(users);
    }
}
