package it.luzzetti.client.coda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.logging.Logger;

public class CodaMain extends Composite {

    private static CodaMainBinder uiBinder = GWT.create(CodaMainBinder.class);

    private Logger logger = Logger.getLogger(getClass().getName());

    public CodaMain() {
        logger.warning("Costruttore CodaMain");
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface CodaMainBinder extends UiBinder<Widget, CodaMain> {
    }

}
