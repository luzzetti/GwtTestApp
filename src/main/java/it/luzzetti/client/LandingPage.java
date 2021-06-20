package it.luzzetti.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import it.luzzetti.client.coda.CodaMain;
import it.luzzetti.client.gestione.GestioneMain;
import it.luzzetti.client.utenti.UtentiMain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LandingPage extends Composite {
    private static LandingPageBinder uiBinder = GWT.create(LandingPageBinder.class);
    @UiField
    MaterialLink codaSideLink;
    @UiField
    MaterialLink gestioneSideLink;
    @UiField
    MaterialLink utentiSideLink;
    @UiField
    MaterialContainer pannelloCentrale;
    private Logger logger = Logger.getLogger(getClass().getName());

    private Map<String, Composite> pagineCreate = new HashMap<>();

    @UiConstructor
    public LandingPage() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("codaSideLink")
    public void onClickCodaSideLink(ClickEvent e) {
        logger.warning("Click On Coda: " + e.getSource());
        pannelloCentrale.clear();
        pannelloCentrale.add(pagineCreate.computeIfAbsent("coda", a -> new CodaMain()));
    }

    @UiHandler("gestioneSideLink")
    public void onClickGestioneSideLink(ClickEvent e) {
        logger.warning("Click On Coda: " + e.getSource());
        pannelloCentrale.clear();
        pannelloCentrale.add(pagineCreate.computeIfAbsent("gestione", a -> new GestioneMain()));
    }

    @UiHandler("utentiSideLink")
    public void onClickUtentiSideLink(ClickEvent e) {
        logger.warning("Click on Utenti: " + e.getSource());
        pannelloCentrale.clear();
        pannelloCentrale.add(pagineCreate.computeIfAbsent("utenti", a -> new UtentiMain()));
    }

    interface LandingPageBinder extends UiBinder<Widget, LandingPage> {
    }

}
