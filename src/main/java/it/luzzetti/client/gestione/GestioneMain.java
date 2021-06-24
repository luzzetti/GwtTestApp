package it.luzzetti.client.gestione;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import it.luzzetti.client.gestione.test.UtenteEditor;
import it.luzzetti.client.model.UtenteDTO;

import java.util.logging.Logger;

public class GestioneMain extends Composite {

    private static GestioneMainBinder uiBinder = GWT.create(GestioneMainBinder.class);

    @UiField
    protected MaterialPanel contenuto;
    @UiField
    protected MaterialButton isDirtyButton;
    @UiField
    protected MaterialButton editButton;
    @UiField
    protected MaterialButton flushButton;
    @UiField
    protected MaterialButton pulisciButton;


    protected UtenteDTO utenteDTO = new UtenteDTO();
    private UtenteDriver utenteDriver = GWT.create(UtenteDriver.class);
    private UtenteEditor utenteEditor = new UtenteEditor();
    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Il dirty, non controlla che FORM e DTO siano sincronizzati.
     * Controlla solo se il FORM è cambiato o no, dall'ultimo EDIT effettuato.
     */

    public GestioneMain() {
        logger.warning("Costruttore GestioneMain");
        initWidget(uiBinder.createAndBindUi(this));
        contenuto.add(utenteEditor);
        utenteDriver.initialize(utenteEditor);
        utenteDriver.edit(utenteDTO);
    }

    @UiHandler("editButton")
    public void onClickEdit(ClickEvent e) {
        utenteDriver.edit(utenteDTO);
    }

    @UiHandler("flushButton")
    public void onClickFlush(ClickEvent e) {
        utenteDriver.flush();
        logger.warning("VALORE ATTUALE: " + utenteDTO);
    }

    @UiHandler("pulisciButton")
    public void onClickPulisci(ClickEvent e) {
        utenteEditor.pulisci();
    }

    @UiHandler("isDirtyButton")
    public void onClickIsDirty(ClickEvent e) {
        Boolean isMascheraSporca = utenteDriver.isDirty();

        Window.alert(isMascheraSporca.toString());
    }

    interface GestioneMainBinder extends UiBinder<Widget, GestioneMain> {
    }

    interface UtenteDriver extends SimpleBeanEditorDriver<UtenteDTO, UtenteEditor> {
    }

}
