package com.vaadin.tutorial.crm.ui.views.task2.company;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.tutorial.crm.security.SecurityService;
import com.vaadin.tutorial.crm.ui.views.task1.dashboard.DashboardView;
import com.vaadin.tutorial.crm.ui.views.task1.home.HomeView;
import com.vaadin.tutorial.crm.ui.views.task1.list.ListView;

@CssImport("./styles/shared-styles.css")
public class CompanyView extends AppLayout {
	
	private SecurityService securityService;

    public CompanyView(@Autowired SecurityService securityService) {
    	this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H3 logo = new H3("Company information page");
        logo.addClassName("logo");

        HorizontalLayout header;

        if (securityService.getAuthenticatedUser() != null) {
            Button logout = new Button("Logout", click ->
                    securityService.logout());
            header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        } else {
            header = new HorizontalLayout(new DrawerToggle(), logo);
        }

        // Other page components omitted.
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
    	RouterLink companiesInfo = new RouterLink("Companies common information",
                CompanyDescriptionView.class);
        RouterLink companyFeedbacks = new RouterLink("Company feedbacks", CompanyFeedbackView.class);
        RouterLink companyEdit = new RouterLink("Edit company information", CompanyEditView.class);

        addToDrawer(new VerticalLayout(companiesInfo, companyFeedbacks, companyEdit));
    }
}


