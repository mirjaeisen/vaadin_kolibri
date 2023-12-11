package com.example.adapters;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * Mit dem **Toast**-Service geben Sie ein optisches Feedback an die Nutzer:innen. Sie wird am Kopf des Browserfenster
angezeigt, bis sie geschlossen wird. Werden mehrere Toasts geöffnet, ohne das die bisherigen geschlossen wurden, so werden diese untereinander angezeigt.
 */

@Tag("kol-toast-container")
@NpmPackage(value = "@public-ui/components", version = "1.7.6")
@JsModule("@public-ui/components/dist/components/kol-toast-container")
public class KolToastContainer extends Component {
}
