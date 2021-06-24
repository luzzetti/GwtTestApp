package it.luzzetti.client.gestione.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialTextBox;
import it.luzzetti.client.model.UtenteDTO;

import java.util.logging.Logger;

public class UtenteEditor extends Composite implements Editor<UtenteDTO> {

    private static UtenteEditorBinder uiBinder = GWT.create(UtenteEditorBinder.class);
    @UiField
    MaterialTextBox nome;
    @UiField
    MaterialTextBox cognome;
    @UiField
    MaterialTextBox email;
    @UiField
    @Ignore
    MaterialTextBox codiceFiscale;

    private Logger logger = Logger.getLogger(getClass().getName());

    public UtenteEditor() {
        logger.warning("UtenteEditor");
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void pulisci() {
        nome.setValue("");
        cognome.setValue("");
        email.setValue("");
        codiceFiscale.setValue("");
    }

    interface UtenteEditorBinder extends UiBinder<Widget, UtenteEditor> {
    }

}
