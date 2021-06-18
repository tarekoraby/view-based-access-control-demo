package com.vaadin.tutorial.crm.ui.views.task2.company;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.service.CompanyService;

@Route(value = "CompanyFeedbackView", layout = CompanyView.class)
@PermitAll
public class CompanyFeedbackView extends VerticalLayout {

    public CompanyFeedbackView(@Autowired CompanyService companyService) {
        H4 header = new H4("Companies feedback");

        Grid<Company> companyGrid = new Grid<>();
        companyGrid.addColumn(Company::getName);
        companyGrid.addColumn(Company::getFeedback);
        companyGrid.setItems(companyService.findAll());

        add(header, companyGrid);
    }
}
