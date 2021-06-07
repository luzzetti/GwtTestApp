package it.luzzetti.client.coda.elementocoda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import it.luzzetti.client.coda.IsElementoCoda;

import java.util.logging.Logger;

/**
 * Anche questa interfaccia, si comporta come la normale interfaccia Editor, ANCHE SE NON IMPLEMENTO IL SETVALUE!
 * Ad ogni modo, mi fornisce dei comodi metodi per intercettare dei momenti specifici del LifeCycle. Vedi sotto...
 */
public class ElementoCodaEditor extends Composite implements ValueAwareEditor<IsElementoCoda> {

    private static ElementoCodaEditorBinder uiBinder = GWT.create(ElementoCodaEditorBinder.class);
    @UiField
    protected MaterialLabel idValue;
    @UiField
    protected MaterialLabel istanteCreazioneValue;
    @UiField
    protected MaterialTextBox note;

    EditorDelegate<IsElementoCoda> delegate;
    IsElementoCoda elementoCoda;

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
     * Innanzitutto, mi mette a disposizione l'editor delegate. Vedi la relativa interfaccia HasEditorDelegate
     * per avere maggiori informazioni su questo oggetto.
     */
    @Override
    public void setDelegate(EditorDelegate<IsElementoCoda> delegate) {
        this.delegate = delegate;
    }

    /**
     * QUì, posso inserire un'eventuale logica EXTRA, da lanciare immediatamente dopo il lancio del flush
     * da parte del driver.
     * Nel nostro caso, vogliamo trasformare le note in Uppercase
     */
    @Override
    public void flush() {
        logger.warning("Flush has been called!");
        this.elementoCoda.setNote(this.elementoCoda.getNote().toUpperCase());
        this.note.setValue(this.note.getValue().toUpperCase());
    }

    @Override
    public void onPropertyChange(String... paths) {
        // No-Op
    }

    /**
     * Quì, GWT ci mette a disposizione la possibilità di accedere al BackedBean, ossia all'oggetto
     * legato all'editor, e di intercettare i valori passati al driver.edit()
     * Ovviamente ci conviene mantenerci un riferimento con una variabile di istanza.
     */
    @Override
    public void setValue(IsElementoCoda value) {
        if (value.getNote() == null || value.getNote().isEmpty()) {
            value.setNote("-");
        }
        this.elementoCoda = value;
    }

    interface ElementoCodaEditorBinder extends UiBinder<Widget, ElementoCodaEditor> {
    }


}
