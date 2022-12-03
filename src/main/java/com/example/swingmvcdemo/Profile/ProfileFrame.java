package com.example.swingmvcdemo.Profile;

import com.example.swingmvcdemo.ApplicationFrame;
import com.example.swingmvcdemo.Dashboard.DashboardFrame;
import com.example.swingmvcdemo.Dashboard.DashboardView;

public class ProfileFrame extends ApplicationFrame<ProfileView, ProfileController> {
    public ProfileFrame(ProfileView profileView, ProfileController profileController) {
        super(profileView, profileController);
    }

    @Override
    protected void addListeners() {
        this.view.getCancelBtn().addActionListener(this.controller.getCloseChangeListener(this.view));
        this.view.getSubmitBtn().addActionListener(this.controller.getSubmitChangeListener(this.view));
        this.view.getSubmitBtn().addActionListener(this.controller.getCloseChangeListener(this.view));
        
        this.view.getSelectAvatarBtn().addActionListener(this.controller.getSelectAvatarListener(this.view));
    }

    @Override
    protected void initialized() {
        DashboardView dashboardView = (DashboardView) this.getFrameView(DashboardFrame.class);
        dashboardView.addChildComponent(this.view.generateDetailsPanel());
    }
}
