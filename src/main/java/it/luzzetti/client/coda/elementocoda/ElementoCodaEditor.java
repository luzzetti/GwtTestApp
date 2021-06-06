package it.luzzetti.client.coda.elementocoda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import it.luzzetti.client.coda.IsElementoCoda;

import java.util.logging.Logger;

public class ElementoCodaEditor extends Composite implements Editor<IsElementoCoda> {

    private static ElementoCodaEditorBinder uiBinder = GWT.create(ElementoCodaEditorBinder.class);
    @UiField
    protected MaterialLabel idValue;
    @UiField
    protected MaterialLabel istanteCreazioneValue;
    @UiField
    protected MaterialTextBox note;

    private Logger logger = Logger.getLogger(getClass().getName());

    public ElementoCodaEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void pulisci() {
        logger.warning("RESET VALUES");
        idValue.setValue("0");
        istanteCreazioneValue.setValue("");
        note.setValue("");
    }

    interface ElementoCodaEditorBinder extends UiBinder<Widget, ElementoCodaEditor> {
    }


}
