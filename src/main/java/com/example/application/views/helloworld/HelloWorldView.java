package com.example.application.views.helloworld;

import com.example.adapters.KolButton;
import com.example.adapters.KolSelect;
import com.example.adapters.KolTabs;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends VerticalLayout {

    private void handleClick(DomEvent event) {
        Element response = ElementFactory.createDiv("Clicked!");
        getElement().appendChild(response);
    }

    public HelloWorldView() {
        setMargin(true);

        var kolTabs = new KolTabs();
        kolTabs.setSelected("0");
        kolTabs.getElement().getStyle().set("padding-top", "15px");
        kolTabs.setTabsAlign("bottom");
        kolTabs.setTabs(
                "[{\"_label\":\"Koordinatenpaar/Koordinatenliste\",\"_href\":\"startseite\",\"_active\":true, \"_icon\":\"\"},{\"_label\":\"ESRI SHAPE-DATEIEN\",\"_href\":\"2-menuepunkt\", \"_icon\":\"\"},{\"_label\":\"CSV-Dateien\",\"_href\":\"startseite\", \"_icon\":\"\"}]");
        add(kolTabs);

        var koordSystemIn = new KolSelect();
        koordSystemIn.setList(
                "[{'label':'Gauß-Krüger Koordinaten','value':'GKK'},{'label':'Geographische Koordinaten','value':'GK'}]");
        koordSystemIn.setHint("Koordinatensystem");
        koordSystemIn.getElement().getStyle().set("width", "250px");
        add(koordSystemIn);

        var kolButton = new KolButton();
        kolButton.setLabel("Klick mich!");
        kolButton.getElement().addEventListener("kol-click", this::handleClick);
        add(kolButton);
    }

}
