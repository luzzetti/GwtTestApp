package it.luzzetti.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LandingPage extends Composite {

    interface LandingPageBinder extends UiBinder<Widget, LandingPage> {}
    private static LandingPageBinder uiBinder = GWT.create(LandingPageBinder.class);

    @UiField
    protected Button pulsante;

    @UiConstructor
    public LandingPage() {
        initWidget(uiBinder.createAndBindUi(this));
        pulsante.setText("Test");
    }

}
