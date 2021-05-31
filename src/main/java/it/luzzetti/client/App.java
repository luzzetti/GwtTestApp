package it.luzzetti.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Hello world!
 */
public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(GWT.create(LandingPage.class));
    }

}
