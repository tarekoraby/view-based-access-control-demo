package com.vaadin.tutorial.crm.ui.views.task2.company;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.service.CompanyService;

public class CompanyDescriptionView extends VerticalLayout {

    public CompanyDescriptionView(@Autowired CompanyService companyService) {
        H4 header = new H4("Companies description");

        Grid<Company> companyGrid = new Grid<>();
        companyGrid.addColumn(Company::getName);
        companyGrid.addColumn(Company::getDescription);
        companyGrid.setItems(companyService.findAll());

        add(header, companyGrid);
    }
}
