package com.vaadin.tutorial.crm.backend.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.User;

@Service
public class UserService {

    private static final Collection<User> users = new ArrayList<>(2);

    static {
        User user = new User("user", "{noop}user", Collections.singleton(
                "USER"));
        users.add(user);

        User admin = new User("admin", "{noop}admin", Collections.singleton(
                "ADMIN"));
        users.add(admin);
    }

    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(users);
    }
}
