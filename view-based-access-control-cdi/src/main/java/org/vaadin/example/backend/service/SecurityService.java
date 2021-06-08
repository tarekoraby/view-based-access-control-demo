package org.vaadin.example.backend.service;

import javax.servlet.ServletException;

import org.vaadin.example.ui.home.HomeView;

import com.vaadin.cdi.annotation.VaadinServiceScoped;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinSession;

@VaadinServiceScoped
public class SecurityService {

    public boolean isAuthenticated() {
        return VaadinServletRequest.getCurrent() != null &&
               VaadinServletRequest.getCurrent().getUserPrincipal() != null;
    }

    public boolean authenticate(String username, String password) {
        if (VaadinServletRequest.getCurrent() != null) {
            VaadinServletRequest current = VaadinServletRequest.getCurrent();
            try {
                current.login(username, password);
                return true;
            } catch (ServletException e) {
                return false;
            }
        }
        return false;
    }

    public void logout() {
        VaadinSession.getCurrent().close();
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().navigate(HomeView.class);
    }

}
