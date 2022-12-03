package com.example.swingmvcdemo;

import com.example.swingmvcdemo.Dashboard.DashboardController;
import com.example.swingmvcdemo.Dashboard.DashboardFrame;
import com.example.swingmvcdemo.Dashboard.DashboardModel;
import com.example.swingmvcdemo.Dashboard.DashboardView;
import com.example.swingmvcdemo.Profile.ProfileController;
import com.example.swingmvcdemo.Profile.ProfileFrame;
import com.example.swingmvcdemo.Profile.ProfileModel;
import com.example.swingmvcdemo.Profile.ProfileView;

import java.util.HashMap;

public class ApplicationFactory {
    private final HashMap<Class<?>, ApplicationFrame<? extends ApplicationView<? extends ApplicationModel>, ? extends ApplicationController<? extends ApplicationModel>>> frames = new HashMap<>();

    public void start() {
        new ApplicationProperties();

        DashboardModel dashboardModel = new DashboardModel();
        ApplicationFrame<DashboardView, DashboardController> dashboardFrame = new DashboardFrame(
                new DashboardView(dashboardModel),
                new DashboardController(dashboardModel)
        );
        this.frames.put(DashboardFrame.class, dashboardFrame);
        dashboardFrame.setFrames(this.frames);

        ProfileModel profileModel = new ProfileModel();
        ApplicationFrame<ProfileView, ProfileController> profileFrame = new ProfileFrame(
                new ProfileView(profileModel),
                new ProfileController(profileModel)
        );
        this.frames.put(ProfileFrame.class, profileFrame);
        profileFrame.setFrames(this.frames);

        dashboardFrame.load();
        profileFrame.load();

        dashboardFrame.view.showWindow();
    }
}
