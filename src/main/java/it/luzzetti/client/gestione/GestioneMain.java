package it.luzzetti.client.gestione;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.logging.Logger;

public class GestioneMain extends Composite {

    private static GestioneMainBinder uiBinder = GWT.create(GestioneMainBinder.class);
    private Logger logger = Logger.getLogger(getClass().getName());

    public GestioneMain() {
        logger.warning("Costruttore GestioneMain");
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface GestioneMainBinder extends UiBinder<Widget, GestioneMain> {
    }

}
