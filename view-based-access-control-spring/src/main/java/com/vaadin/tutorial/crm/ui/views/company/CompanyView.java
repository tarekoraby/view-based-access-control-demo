package com.vaadin.tutorial.crm.ui.views.company;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class CompanyView extends VerticalLayout {

    public CompanyView() {
        H3 header = new H3("Company information page");
        RouterLink companiesInfo = new RouterLink("Companies common information",
                CompanyDescriptionView.class);
        RouterLink companyFeedbacks = new RouterLink("Company feedbacks", CompanyFeedbackView.class);
        RouterLink companyEdit = new RouterLink("Edit company information", CompanyEditView.class);
        add(header, companiesInfo, companyFeedbacks, companyEdit);
    }
}
