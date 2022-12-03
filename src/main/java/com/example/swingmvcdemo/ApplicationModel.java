package com.example.swingmvcdemo;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class ApplicationModel {
    protected final SwingPropertyChangeSupport support = new SwingPropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener modelListener) {
        this.support.addPropertyChangeListener(modelListener);
    }
}
