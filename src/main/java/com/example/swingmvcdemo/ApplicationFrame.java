package com.example.swingmvcdemo;

import java.util.HashMap;

public abstract class ApplicationFrame<V extends ApplicationView<? extends ApplicationModel>, C extends ApplicationController<? extends ApplicationModel>> {
    private HashMap<Class<?>, ApplicationFrame<? extends ApplicationView<? extends ApplicationModel>, ? extends ApplicationController<? extends ApplicationModel>>> frames;

    public V view;
    public final C controller;

    protected ApplicationFrame(V view, C controller) {
        this.view = view;
        this.controller = controller;
    }
    public ApplicationView<? extends  ApplicationModel> getFrameView(Class<?> c) {
        return this.frames.get(c).view;
    }
    public ApplicationController<? extends  ApplicationModel> getFrameController(Class<?> c) {
        return this.frames.get(c).controller;
    }
    public void load() {
        this.view.create();
        this.initialized();
        this.addListeners();
    }
    public void setFrames(HashMap<Class<?>, ApplicationFrame<? extends ApplicationView<? extends ApplicationModel>, ? extends ApplicationController<? extends ApplicationModel>>> frames) {
        this.frames = frames;
    }
    protected abstract void addListeners();
    protected abstract void initialized();
}
