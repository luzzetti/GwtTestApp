package it.luzzetti.client.coda.elementocoda;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.CompositeEditor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollapsible;
import it.luzzetti.client.coda.IsElementoCoda;

import java.util.ArrayList;
import java.util.List;

/**
 * The type CompositeEditor helps you to deal with lists of an unknown number of
 * domain/proxy objects. The subinterface CompositeEditor indicates that this editor is
 * composed of an unknown number of subeditors all of the same type.
 * This type handles a chain of subeditors with domain/proxy objects. New subeditors could be
 * added, updated, or deleted at runtime. All editors and domain/proxy objects should
 * be of the same type
 * <p>
 * Si ha comunque bisogno di un editor per il singolo elemento di cui è composta la lista!!!
 */
public class ListElementoCodaEditor extends Composite
        implements CompositeEditor<List<IsElementoCoda>, IsElementoCoda, ElementoCodaEditor> {

    // UiBinder
    private static final ListElementoCodaEditorBinder uiBinder = GWT.create(ListElementoCodaEditorBinder.class);

    @UiField
    MaterialCollapsible collapsiblesContainer;
    @UiField
    MaterialButton aggiungiElementoButton;
    @UiField
    MaterialButton rimuoviUltimoElementoButton;
    @UiField
    MaterialButton rimuoviTuttoButton;

    // CompositeEditor
    private CompositeEditor.EditorChain<IsElementoCoda, ElementoCodaEditor> editorChain;
    private EditorDelegate<List<IsElementoCoda>> listElementoCodaDelegate;
    private List<ElementoCodaEditor> editorList;

    public ListElementoCodaEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public ElementoCodaEditor createEditorForTraversal() {
        return new ElementoCodaEditor();
    }

    @Override
    public void setEditorChain(EditorChain<IsElementoCoda, ElementoCodaEditor> chain) {
        editorChain = chain;
    }

    @Override
    public void setValue(List<IsElementoCoda> elementiCoda) {
        if (editorList == null) {
            editorList = new ArrayList<>();
        } else {
            // Resetto la lista di subeditor
            editorList.forEach(editorChain::detach);
            editorList.clear();
        }
        elementiCoda.forEach(e -> editorChain.attach(e, new ElementoCodaEditor()));
    }

    @Override
    public void setDelegate(EditorDelegate<List<IsElementoCoda>> delegate) {
        this.listElementoCodaDelegate = delegate;
    }

    @Override
    public String getPathElement(ElementoCodaEditor subEditor) {
        return "[" + editorList.indexOf(subEditor) + "]";
    }

    @Override
    public void flush() {
        // Codice non necessario
    }

    @Override
    public void onPropertyChange(String... paths) {
        // Codice non necessario
    }

    interface ListElementoCodaEditorBinder extends UiBinder<Widget, ListElementoCodaEditor> {
    }

}
