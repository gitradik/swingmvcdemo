package com.example.swingmvcdemo.Dashboard;

import com.example.swingmvcdemo.ApplicationFrame;
import com.example.swingmvcdemo.Profile.ProfileController;
import com.example.swingmvcdemo.Profile.ProfileFrame;
import com.example.swingmvcdemo.Profile.ProfileView;

import javax.swing.*;

public class DashboardFrame extends ApplicationFrame<DashboardView, DashboardController> {
    public DashboardFrame(DashboardView view, DashboardController controller) {
        super(view, controller);
    }

    @Override
    protected void addListeners() {
        ProfileController profileController = (ProfileController) this.getFrameController(ProfileFrame.class);
        this.view.getProfileBtn().addActionListener(profileController.getOpenChangeListener((ProfileView) this.getFrameView(ProfileFrame.class)));
    }

    @Override
    protected void initialized() {
        this.view.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
