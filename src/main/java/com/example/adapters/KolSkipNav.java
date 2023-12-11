package com.example.adapters;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.util.Optional;

/**
 * Mit Hilfe der **SkipNav**-Komponente kann eine versteckte Navigation erzeugt werden. Sie dient dazu, Sehbehinderten das Überspringen von Seitenbereichen zu ermöglichen. Sie wird nur nach Anspringen durch die **Tab-Taste** sichtbar.
 */

@Tag("kol-skip-nav")
@NpmPackage(value = "@public-ui/components", version = "1.7.6")
@JsModule("@public-ui/components/dist/components/kol-skip-nav")
public class KolSkipNav extends Component {
	/**
	 * Deprecated: Setzt die semantische Beschriftung der Komponente.
	 *
	 * @param value String
	 */
	public void setAriaLabel(final String value) {
		getElement().setProperty("_aria-label", value.toString());
	}

	/**
	 * Deprecated: Setzt die semantische Beschriftung der Komponente.
	 *
	 * @return Optional<String>
	 */
	public Optional<String> getAriaLabel() {
		var value = getElement().getProperty("_aria-label", null);
		return value.isEmpty() ? Optional.empty() : Optional.of(value);
	}

	/**
	 * Defines the visible or semantic label of the component (e.g. aria-label, label, headline, caption, summary, etc.).
	 *
	 * @param value String
	 */
	public void setLabel(final String value) {
		getElement().setProperty("_label", value.toString());
	}

	/**
	 * Defines the visible or semantic label of the component (e.g. aria-label, label, headline, caption, summary, etc.).
	 *
	 * @return Optional<String>
	 */
	public Optional<String> getLabel() {
		var value = getElement().getProperty("_label", null);
		return value.isEmpty() ? Optional.empty() : Optional.of(value);
	}

	/**
	 * Defines the list of links combined with their labels to render.
	 *
	 * @param value String
	 */
	public void setLinks(final String value) {
		getElement().setProperty("_links", value.toString());
	}

	/**
	 * Defines the list of links combined with their labels to render.
	 *
	 * @return Optional<String>
	 */
	public Optional<String> getLinks() {
		var value = getElement().getProperty("_links", null);
		return value.isEmpty() ? Optional.empty() : Optional.of(value);
	}
}
