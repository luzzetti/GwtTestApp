package it.luzzetti.client.utenti.listautentiview;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.HasEditorDelegate;
import com.google.gwt.editor.client.adapters.HasDataEditor;
import com.google.gwt.editor.client.adapters.SimpleEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLabel;
import it.luzzetti.client.model.AnagraficaUtenti;
import it.luzzetti.client.model.Utente;

import java.util.Date;
import java.util.logging.Logger;

public class UtentiListEditor extends Composite implements HasEditorDelegate<AnagraficaUtenti>,Editor<AnagraficaUtenti> {

    private static UtentiListEditorBinder uiBinder = GWT.create(UtentiListEditorBinder.class);
    @UiField
    MaterialContainer container;
    SimpleEditor<Date> istanteUltimaModifica = SimpleEditor.of();
    HasDataEditor<Utente> utenti;
    private Logger logger = Logger.getLogger(getClass().getName());
    private EditorDelegate<AnagraficaUtenti> delegate;

    public UtentiListEditor() {
        logger.warning("Costruttore UtentiListEditor");
        initWidget(uiBinder.createAndBindUi(this));

        DataGrid<Utente> datagrid = new DataGrid<>();
        container.add(datagrid);

        TextColumn<Utente> colonnaNome = new TextColumn<>() {
            @Override
            public String getValue(Utente object) {
                return object.getNome();
            }
        };

        datagrid.addColumn(colonnaNome, "Nome");

        TextColumn<Utente> colonnaCognome = new TextColumn<>() {
            @Override
            public String getValue(Utente object) {
                return object.getCognome();
            }
        };
        datagrid.addColumn(colonnaCognome, "Cognome");


        // Crazione di una ButtonColumn
        ButtonCell buttonCell = new ButtonCell();
        Column<Utente, String> buttonColumn = new Column<Utente, String>(buttonCell) {
            @Override
            public String getValue(Utente object) {
                return object.getAttivo().toString();
            }
        };
        datagrid.addColumn(buttonColumn, "Action");

        buttonColumn.setFieldUpdater((index, object, value) -> {
            logger.warning("Index: " + index + "Utente object: " + object + "Value: " + value);
            utenti.getEditors().get(index).setValue(new Utente(object.getNome(), object.getCognome(), !object.getAttivo()));
        });

        // Crazione di una ButtonColumn


//        TextColumn<Utente> colonnaAttivo = new TextColumn<>() {
//            @Override
//            public String getValue(Utente object) {
//                return object.getAttivo().toString();
//            }
//
//        };
//        datagrid.addColumn(colonnaAttivo, "Attivo");


        datagrid.setColumnWidth(0, "20px");
        datagrid.setColumnWidth(1, "20px");
        datagrid.setColumnWidth(2, "20px");
        datagrid.setHeight("300px");
        datagrid.setEmptyTableWidget(new MaterialLabel("Nessun record presente"));

        utenti = HasDataEditor.of(datagrid);

    }

    public void pulisci() {
        utenti.getList().clear();
    }

    @Override
    public void setDelegate(EditorDelegate<AnagraficaUtenti> delegate) {
        this.delegate = delegate;
    }

    interface UtentiListEditorBinder extends UiBinder<Widget, UtentiListEditor> {
    }


}
