package com.example.swingmvcdemo;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class ApplicationView<M extends ApplicationModel> {
    protected ApplicationListener<M, ? extends ApplicationView<M>> applicationListener;
    protected M model;
    private JFrame frame;

    protected ApplicationView(M model) {
        this.model = model;
        this.applicationListener = new ApplicationListener<>(this);
        this.model.addPropertyChangeListener(this.applicationListener);
    }

    protected ApplicationView(JFrame frame, M model) {
        this.model = model;
        this.applicationListener = new ApplicationListener<>(this);
        this.model.addPropertyChangeListener(this.applicationListener);

        this.frame = frame;
    }

    public void create() {
        if (this.isFrame()) {
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setSize(500, 500);

            this.registerToFrame(this.frame);
        }
    }

    protected abstract void registerToFrame(JFrame frame);
    public abstract void addChildComponent(JComponent component);
    public abstract void applyChanges(String propertyName);
    public abstract void defaultFromOutside(ApplicationModel... models);

    public void showWindow() {
        if (this.isFrame()) {
            this.frame.setVisible(true);
        }
    }
    public void closeWindow() {
        if (this.isFrame()) {
            this.frame.setVisible(false);
        }
    }

    private boolean isFrame() {
        return this.frame != null;
    }
}
