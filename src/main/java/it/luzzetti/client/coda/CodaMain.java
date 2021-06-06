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
import it.luzzetti.client.coda.elementocoda.ElementoCodaEditor;
import it.luzzetti.client.model.RichiestaOrgano;

import java.util.logging.Logger;

public class CodaMain extends Composite {

    private static final CodaMainBinder uiBinder = GWT.create(CodaMainBinder.class);

    @UiField
    protected MaterialCollapsible collapsiblesContainer;
    @UiField
    protected ElementoCodaEditor elementoCodaEditor;
    IsElementoCoda elementoCoda;
    Driver driver = GWT.create(Driver.class);

    private Logger logger = Logger.getLogger(getClass().getName());

    public CodaMain() {
        elementoCoda = new RichiestaOrgano();
        elementoCoda.setIdValue("0");
        elementoCoda.setIdUtenteCreazioneValue("0");
        elementoCoda.setIstanteCreazioneValue("wathever");
        logger.warning("Costruttore CodaMain");
        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(elementoCodaEditor);
        driver.edit(elementoCoda);
    }

    @UiHandler("pulisciButton")
    public void onClickPulisci(ClickEvent e) {
        elementoCodaEditor.pulisci();
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
        driver.edit(elementoCoda);
    }

    interface Driver extends SimpleBeanEditorDriver<IsElementoCoda, ElementoCodaEditor> {
    }

    interface CodaMainBinder extends UiBinder<Widget, CodaMain> {
    }

}
