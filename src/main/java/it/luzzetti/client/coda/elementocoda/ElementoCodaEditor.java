package it.luzzetti.client.coda.elementocoda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.HasEditorDelegate;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import it.luzzetti.client.coda.IsElementoCoda;

import java.util.logging.Logger;

/**
 * Implementando l'interfaccia HasEditorDelegate, la classe si comporterà COMUNQUE da Editor.
 * Potrò effettuare il Flush e l'Edit proprio come se avessi implementato una normale
 * interfaccia Editor<T>
 *
 * In questo caso però, mi viene data anche la possibilità di accedere direttamente all'EditorDelegate.
 */

public class ElementoCodaEditor extends Composite implements HasEditorDelegate<IsElementoCoda> {

    private static ElementoCodaEditorBinder uiBinder = GWT.create(ElementoCodaEditorBinder.class);
    @UiField
    protected MaterialLabel idValue;
    @UiField
    protected MaterialLabel istanteCreazioneValue;
    @UiField
    protected MaterialTextBox note;

    /**
     * Mi preparo una variabile in cui terrò il riferimento all'EditorDelegate
     */
    private EditorDelegate elementoCodaEditorDelegate;

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
     * Effettuo l'override di questo metodo, che verrà chiamato dal framework (prima di
     * inizializzare gli altri campi associati all'editor), e che mi fornirà
     * l'accesso all'editor delegate, che inserirò nella variabile d'istanza che mi sono creato in
     * precedenza.
     */
    @Override
    public void setDelegate(EditorDelegate<IsElementoCoda> editorDelegate) {
        this.elementoCodaEditorDelegate = editorDelegate;
    }

    /**
     * Una cosa utile che posso fare avendo accesso all'ED (Editor Delegate), è gestire manualmente
     * il flag isDirty() del driver.
     *
     * Fare però attenzione, in quanto l'uso è abbastanza controintuitivo.
     * https://stackoverflow.com/questions/41119246/gwt-editor-driver-remains-dirty
     */
    public void impostaManualmenteIlDirtyState(boolean dirty) {
        elementoCodaEditorDelegate.setDirty(dirty);
        logger.warning("dirtyFlag impostato a: " + dirty);
    }

    public void stampaPathDellEditorDelegate() {
        logger.warning("Editor Delegate Path: " + elementoCodaEditorDelegate.getPath());
    }

    interface ElementoCodaEditorBinder extends UiBinder<Widget, ElementoCodaEditor> {
    }


}
