package com.example.swingmvcdemo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ApplicationListener<M extends ApplicationModel, V extends ApplicationView<M>> implements PropertyChangeListener {
    private final V view;
    public ApplicationListener(V view) {
        this.view = view;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.view.applyChanges(e.getPropertyName());
    }
}
