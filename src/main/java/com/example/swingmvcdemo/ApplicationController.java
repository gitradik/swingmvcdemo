package com.example.swingmvcdemo;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ApplicationController<M extends ApplicationModel> {
    private final M model;

    public ApplicationController(M model) {
        this.model = model;
    }
    public ActionListener getActionListener(Consumer<M> meth) {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                meth.accept(model);
            }
        };
    }
    public DocumentListener getDocumentListener(BiConsumer<M, DocumentEvent> meth) {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                meth.accept(model, e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                meth.accept(model, e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                meth.accept(model, e);
            }
        };
    }
}
