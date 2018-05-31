package com.mrn.firstproject;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;


// Create a path in our url
// so if i want to reload i need to enter
// localhost:8080/home
@SpringUI(path = "")
public class MyView extends UI {

    @Autowired
    private Service service;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);


        Label labelId = new Label();
        labelId.setValue("Id: " + service.showId());

        Label titleLabel = new Label();
        titleLabel.setValue("Title: " + service.showTitle());

        Label labelBody = new Label();
        labelBody.setValue("Body: " + service.showBody());



        // adding the component\s
        layout.addComponents(labelId, titleLabel, labelBody);

        setContent(layout);

    }
}
