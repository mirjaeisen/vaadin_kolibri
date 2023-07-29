package com.example.application.views.staticform;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Static Form")
@Route(value = "static", layout = MainLayout.class)
public class StaticFormView extends VerticalLayout {

    public StaticFormView() {
        /**
         * Formular - Methode: POST, Action: /api/
         * 
         * <form method="POST" action="/api/">
         * <kol-input-text _label="Vorname" _name="vorname" />
         * <kol-button _label="Absenden" _type="submit" />
         * </form>
         */

        // https://github.com/public-ui/kolibri/discussions/1528
        // https://codesandbox.io/s/kolibri-public-ui-react-static-jsf-form-sample-fl6lpm
    }

}
