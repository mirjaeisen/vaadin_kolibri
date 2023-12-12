package com.example.application.views.helloworld;

import com.example.adapters.KolSelect;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.notification.Notification;
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

    /**
     * This elements are needed to sync the form field value from
     * to web component shadow root, to a vaadin accessible context.
     */
    Element select = ElementFactory.createSelect();

    private final KolSelect refSystemIn;
    private final KolSelect koordSystemIn;
    private final String blhLabel = "geographische Koordinaten";
    private final String gkLabel = "Gauß-Krüger Koordinaten";

    private final String koordSystemListGKBLH = "[{'label':'" + gkLabel + "','value':'gaußkruegerkoordinaten'}," +
            "{'label':'" + blhLabel + "','value':'geographischekoordinaten'}]";

    private void handleSelectChange(DomEvent event) {
        Notification.show(event.getEventData().get("event.detail").asString());
    }

    public HelloWorldView() {
        setSpacing(false);

        // Eingabeparameter
        var parameterIn = new VerticalLayout();
        parameterIn.getElement().getStyle().set("padding", "0px");
        parameterIn.getElement().getStyle().set("width", "100%");

        refSystemIn = new KolSelect();
        String refSystemList = "[{'label':'" + "DHDN" + "','value':'dhdn'}," +
                "{'label':'" + "STN" + "','value':'stn'}," +
                "{'label':'" + "ETRS" + "','value':'etrs'}]";
        refSystemIn.setOptions(refSystemList);
        refSystemIn.setHint("Referenzsystem");
        refSystemIn.getElement().getStyle().set("width", "250px");
        refSystemIn.setValue("['stn']");
        refSystemIn.getElement().addEventListener("kol-change", this::handleRefSystemInChanged).addEventData("event.detail");
        refSystemIn.getElement().setAttribute("_sync-value-by-selector", "#kol-select");
        add(refSystemIn);

        koordSystemIn = new KolSelect();
        var koordSystemList = "[{'label':'" + "UTM6" + "','value':'utm6'}, " +
                "{'label':'" + "UTM7" + "','value':'utm7'}," +
                "{'label':'" + "UTM8" + "','value':'utm8'}," +
                "{'label':'" + blhLabel + "','value':'geographischekoordinaten'}," +
                "{'label':'" + "Kartesische Koordinaten" + "','value':'xyz'}," +
                "{'label':'" + gkLabel + "','value':'gaußkruegerkoordinaten'}]";
        koordSystemIn.setOptions(koordSystemList);
        koordSystemIn.setValue("['gaußkruegerkoordinaten']");
        koordSystemIn.setHint("Koordinatensystem");
        koordSystemIn.getElement().addEventListener("kol-change", this::handleSelectChange).addEventData("event.detail");
        koordSystemIn.getElement().setAttribute("_sync-value-by-selector", "#kol-select");
        koordSystemIn.getElement().getStyle().set("width", "250px");
        add(koordSystemIn);

        add(parameterIn);
    }

    public void handleRefSystemInChanged(DomEvent event) {
        var selectedValue = (event.getEventData().get("event.detail").asString());
        if (selectedValue.equals("dhdn")) {
            koordSystemIn.setOptions(koordSystemListGKBLH);
            koordSystemIn.setValue("['gaußkruegerkoordinaten']");
        } else if (selectedValue.equals("stn")) {
            koordSystemIn.setOptions(koordSystemListGKBLH);
            System.out.println(koordSystemIn.getValue());
            koordSystemIn.setValue("['gaußkruegerkoordinaten']"); // This sets the value but does no update the UI
            System.out.println(koordSystemIn.getValue());
        } else if (selectedValue.equals("etrs")) {
            return;
        }
    }
}
