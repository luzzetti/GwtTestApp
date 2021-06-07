package it.luzzetti.client.coda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialCollapsible;
import it.luzzetti.client.coda.elementocoda.ListElementoCodaEditor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CodaMain extends Composite {

    private static final CodaMainBinder uiBinder = GWT.create(CodaMainBinder.class);

    @UiField
    protected ListElementoCodaEditor listElementoCodaEditor;

    List<IsElementoCoda> elementiCoda = new ArrayList<>();

    Driver driver = GWT.create(Driver.class);

    private Logger logger = Logger.getLogger(getClass().getName());

    public CodaMain() {
        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(listElementoCodaEditor);
        driver.edit(elementiCoda);
    }

    @UiHandler("pulisciButton")
    public void onClickPulisci(ClickEvent e) {
        logger.warning("onClickPulisci");
    }

    @UiHandler("flushButton")
    public void onClickFlush(ClickEvent e) {
        driver.flush();
        if (driver.hasErrors()) {
            Window.alert("There are errors");
        }
    }

    @UiHandler("editButton")
    public void onClickEdit(ClickEvent e) {
        driver.edit(elementiCoda);
    }

    interface Driver extends SimpleBeanEditorDriver<List<IsElementoCoda>, ListElementoCodaEditor> {
    }

    interface CodaMainBinder extends UiBinder<Widget, CodaMain> {
    }

}
