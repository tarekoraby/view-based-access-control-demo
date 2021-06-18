package org.vaadin.example.security;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.auth.ViewAccessChecker;
import com.vaadin.tutorial.crm.login.LoginView;

public class ViewAccessCheckerInitializer implements VaadinServiceInitListener {

    private ViewAccessChecker viewAccessChecker;

    public ViewAccessCheckerInitializer() {
        viewAccessChecker = new ViewAccessChecker(); 
        viewAccessChecker.enable(); 
        viewAccessChecker.setLoginView(LoginView.class); 
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(viewAccessChecker); 
        });
    }
}