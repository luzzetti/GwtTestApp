package it.luzzetti.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App implements EntryPoint {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(GWT.create(LandingPage.class));
    }

}
