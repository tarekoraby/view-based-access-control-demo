package com.vaadin.tutorial.crm.backend.service;

import org.springframework.stereotype.Component;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;

@Component
public class SecurityService {

// TODO: add necessary dependencies and use this service for login/logout

//    private static final String LOGOUT_SUCCESS_URL = "/";
//
//    public UserDetails getAuthenticatedUser() {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Object principal = context.getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            return (UserDetails) context.getAuthentication().getPrincipal();
//        }
//        // Anonymous or no authentication.
//        return null;
//    }
//
//    public void logout() {
//        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
//        logoutHandler.setInvalidateHttpSession(false);
//        logoutHandler.logout(
//                VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
//                null);
//        UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
//    }
}
