package com.vaadin.tutorial.crm.ui.views.task2.company;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.tutorial.crm.backend.service.CompanyService;

public class CompanyEditView extends VerticalLayout {

    public CompanyEditView(@Autowired CompanyService companyService) {
        add(new H4("Company edit page"));
        companyService.findAll().forEach(company -> {
            HorizontalLayout companyLine = new HorizontalLayout(new Span(company.getName()), new Button(
                    "Edit", VaadinIcon.EDIT.create()));
            add(companyLine);
        });

    }
}
