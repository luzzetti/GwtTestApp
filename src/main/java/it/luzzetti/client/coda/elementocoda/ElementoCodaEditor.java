package it.luzzetti.client.coda.elementocoda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import it.luzzetti.client.coda.IsElementoCoda;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.logging.Logger;

/**
 * Anche in questo caso, così come nel branch HasEditorDelegate, questa interfaccia si comporta
 * esattamente come una normale interfaccia Editor<T>, con la differenza che ci fornisce il metodo
 * showErrors(List<EditorError> errors) per la gestione degli errori.
 *
 */
public class ElementoCodaEditor extends Composite implements HasEditorErrors<IsElementoCoda> {

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

    /**
     * Questo metodo ci fornisce una lista di errori, e viene chiamato ogniqualvolta in uno dei
     * subeditors di questa classe (o forse questa stessa classe?) si verifica
     * una ConstraintViolation.
     *
     * A questo punto, possiamo iterare sulla lista di errori, e dopo averli eventualmente gestiti,
     * dobbiamo impostarli come "consumed" per evitare che risalgano il grafo degli editor.
     * (Praticamente, se li gestisco quì, non voglio che vengano gestiti anche dall'editor che sta
     * un livello sopra a me.
     */
    @Override
    public void showErrors(List<EditorError> errors) {
        for (EditorError e : errors) {
            logger.warning("ERRORE: " + e.getMessage());
            e.setConsumed(true);
        }
    }

    interface ElementoCodaEditorBinder extends UiBinder<Widget, ElementoCodaEditor> {
    }


}
