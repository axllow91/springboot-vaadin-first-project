package com.mrn.firstproject;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


// Create a path in our url
// so if i want to reload i need to enter
// localhost:8080/home
@SpringUI(path = "")
public class MyView extends UI {

    @Autowired
    private Service service;

    @Autowired
    private ComplexService complexService;

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

        TextArea myJSONArrayHolder = new TextArea();
        myJSONArrayHolder.setSizeFull();

        Button clearText = new Button("Clear Text Area");
        clearText.addClickListener(event -> {
           myJSONArrayHolder.clear();
        });

        try {
            JSONArray myObject = complexService.getData();
            for(int i = 0; i < myObject.length(); i++) {
                JSONObject postObject = myObject.getJSONObject(i);
                System.out.println("UserId: " + postObject.getInt("id"));
                System.out.println("Title: " + postObject.getString("title"));
                System.out.println("Body: " + postObject.getString("body"));

            }
            myJSONArrayHolder.setValue(myObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // adding the component\s
        layout.addComponents(labelId, titleLabel, labelBody, myJSONArrayHolder, clearText);

        setContent(layout);

    }
}
