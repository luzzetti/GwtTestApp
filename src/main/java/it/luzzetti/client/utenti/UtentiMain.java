package it.luzzetti.client.utenti;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import it.luzzetti.client.model.AnagraficaUtenti;
import it.luzzetti.client.model.Utente;
import it.luzzetti.client.utenti.listautentiview.UtentiListEditor;

import java.util.logging.Logger;

public class UtentiMain extends Composite {

    private static UtentiMainBinder uiBinder = GWT.create(UtentiMainBinder.class);
    Driver driver = GWT.create(Driver.class);
    @UiField
    UtentiListEditor utentiListEditor;
    AnagraficaUtenti anagraficaUtenti;
    private Logger logger = Logger.getLogger(getClass().getName());

    public UtentiMain() {
        logger.warning("Costruttore Utentimain");
        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(utentiListEditor);

        anagraficaUtenti = new AnagraficaUtenti();
        anagraficaUtenti.aggiungiUtente(new Utente("Christian", "Luzzetti", Boolean.TRUE));
        anagraficaUtenti.aggiungiUtente(new Utente("Stefano", "Ricci", Boolean.TRUE));
        anagraficaUtenti.aggiungiUtente(new Utente("Simone", "Fiani", Boolean.FALSE));
        driver.edit(anagraficaUtenti);

    }

    @UiHandler("flushButton")
    public void onClickFlushButton(ClickEvent e) {
        AnagraficaUtenti anagraficaUtenti = driver.flush();
        logger.warning("FLUSHED: " + anagraficaUtenti);
    }

    @UiHandler("pulisciButton")
    public void onClickPulisci(ClickEvent e) {
        utentiListEditor.pulisci();
    }

    @UiHandler("editButton")
    public void onClickEditButton(ClickEvent e) {
        driver.edit(anagraficaUtenti);
    }

    @UiHandler("isDirtyButton")
    public void onClickIsDirty(ClickEvent e) {
        logger.warning("IsDirty: " + driver.isDirty());
    }

    interface UtentiMainBinder extends UiBinder<Widget, UtentiMain> {
    }

    interface Driver extends SimpleBeanEditorDriver<AnagraficaUtenti, UtentiListEditor> {
    }

}
