package com.example.application.views.helloworld;

import com.example.adapters.KolButton;
import com.example.adapters.KolInputText;
import com.example.adapters.KolSelect;
import com.example.adapters.KolTabs;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.text.DecimalFormat;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    /**
     * This elements are needed to sync the form field value from
     * to web component shadow root, to a vaadin accessible context.
     */
    Element inputText = ElementFactory.createInput("text");
    Element select = ElementFactory.createSelect();

    private void handleInputTextChange(DomEvent event) {
        Notification.show(event.getEventData().getString("event.detail"));
    }

    private void handleSelectChange(DomEvent event) {
        Notification.show(event.getEventData().get("event.detail").asString());
    }

    private void handleClick(DomEvent event) {
        Notification.show("Clicked!");
    }

    public HelloWorldView() {
        setMargin(true);

        KolTabs kolTabs = new KolTabs();
        kolTabs.setSelected("1");
        kolTabs.setTabsAlign("bottom");
        kolTabs.setTabs(
                "[{\"_label\":\"Koordinatenpaar/Koordinatenliste\",\"_href\":\"startseite\",\"_active\":true, \"_icon\":\"\"},{\"_label\":\"ESRI SHAPE-DATEIEN\",\"_href\":\"2-menuepunkt\", \"_icon\":\"\"},{\"_label\":\"CSV-Dateien\",\"_href\":\"startseite\", \"_icon\":\"\"}]");
        add(kolTabs);
        kolTabs.getElement().addEventListener("kol-change",  evt->{
            System.out.println(evt.getEventData());
            double number = evt.getEventData().getNumber("event.detail");
            DecimalFormat df = new DecimalFormat("0");
            Notification.show(df.format(number));
        }).addEventData("event.detail");

        KolInputText kolInputText = new KolInputText();
        kolInputText.setLabel("Vorname");
        kolInputText.getElement().addEventListener("kol-change",this::handleInputTextChange).addEventData("event.detail");
        kolInputText.getElement().setAttribute("_sync-value-by-selector", "#kol-input-text");
        add(kolInputText);


        KolSelect koordSystemIn = new KolSelect();
        koordSystemIn.setList(
                "[{'label':'Gauß-Krüger Koordinaten','value':'GKK'},{'label':'Geographische Koordinaten','value':'GK'}]");
        koordSystemIn.setHint("Koordinatensystem");
        koordSystemIn.getElement().addEventListener("kol-change", this::handleSelectChange).addEventData("event.detail");
        koordSystemIn.getElement().setAttribute("_sync-value-by-selector", "#kol-select");
        add(koordSystemIn);

        KolButton kolButton = new KolButton();
        kolButton.setLabel("Klick mich!");
        kolButton.setValue("Schalter 1");
        /**
         * Bug in rc.23
         * kolButton.getElement().addEventListener("kol-click", this::handleClick);
         */
        kolButton.getElement().addEventListener("kol-change", this::handleClick);
        add(kolButton);
    }

}
