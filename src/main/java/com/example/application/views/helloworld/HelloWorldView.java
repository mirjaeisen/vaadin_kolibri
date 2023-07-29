package com.example.application.views.helloworld;

import com.example.adapters.KolButton;
import com.example.adapters.KolInputText;
import com.example.adapters.KolSelect;
import com.example.adapters.KolTabs;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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

    /**
     * This elements are needed to sync the form field value from
     * to web component shadow root, to a vaadin accessible context.
     */
    Element inputText = ElementFactory.createInput("text");
    Element select = ElementFactory.createSelect();

    private void handleInputTextChange(DomEvent event) {
        /**
         * Im DOM sind die Werte - aber ich komme hier nicht ran?!
         * Im Event sind die Werte auch immer leer oder 0.
         * Wie kommt man mit der Element-API an die Werte?
         */
        getElement().appendChild(ElementFactory.createDiv(inputText.getAttribute("value")));
    }

    private void handleSelectChange(DomEvent event) {
        getElement().appendChild(ElementFactory.createDiv(select.getAttribute("value")));
    }

    private void handleClick(DomEvent event) {
        getElement().appendChild(ElementFactory.createDiv("Clicked!"));
    }

    public HelloWorldView() {
        setMargin(true);

        KolTabs kolTabs = new KolTabs();
        kolTabs.setSelected("0");
        kolTabs.setTabsAlign("bottom");
        kolTabs.setTabs(
                "[{\"_label\":\"Koordinatenpaar/Koordinatenliste\",\"_href\":\"startseite\",\"_active\":true, \"_icon\":\"\"},{\"_label\":\"ESRI SHAPE-DATEIEN\",\"_href\":\"2-menuepunkt\", \"_icon\":\"\"},{\"_label\":\"CSV-Dateien\",\"_href\":\"startseite\", \"_icon\":\"\"}]");
        add(kolTabs);

        Element inputText = ElementFactory.createInput("text");
        inputText.setAttribute("hidden", "");
        inputText.setAttribute("id", "kol-input-text");
        inputText.setAttribute("multiple", "");
        getElement().appendChild(inputText);

        KolInputText kolInputText = new KolInputText();
        kolInputText.setLabel("Vorname");
        kolInputText.getElement().addEventListener("kol-change", this::handleInputTextChange);
        kolInputText.getElement().setAttribute("_sync-value-by-selector", "#kol-input-text");
        add(kolInputText);

        TextField textField = new TextField();
        // Wie komme ich mit Vaadin an den Value eines nativen input elements?
        textField.getElement().executeJs( // ???
                "this.addEventListener('input', function(event) {" +
                        "  console.log('input event', event.target.value);" +
                        "  console.log(this.$server);" +
                        "  this.$server.setValue(event.target.value);" +
                        "})");
        add(textField);

        Element select = ElementFactory.createSelect();
        select.setAttribute("hidden", "");
        select.setAttribute("id", "kol-select");
        select.setAttribute("multiple", "");
        getElement().appendChild(select);

        KolSelect koordSystemIn = new KolSelect();
        koordSystemIn.setList(
                "[{'label':'Gauß-Krüger Koordinaten','value':'GKK'},{'label':'Geographische Koordinaten','value':'GK'}]");
        koordSystemIn.setHint("Koordinatensystem");
        koordSystemIn.getElement().addEventListener("kol-change", this::handleSelectChange);
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
