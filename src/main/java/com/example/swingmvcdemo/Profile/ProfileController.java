package com.example.swingmvcdemo.Profile;

import com.example.swingmvcdemo.ApplicationController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileController extends ApplicationController<ProfileModel> {
    public ProfileController(ProfileModel model) {
        super(model);
    }

    public ActionListener getOpenChangeListener(ProfileView profileView) {
        return this.getActionListener((m) -> profileView.showWindow());
    }

    public ActionListener getCloseChangeListener(ProfileView profileView) {
        return this.getActionListener((m) -> {
            profileView.closeWindow();
            m.resetProfile();
        });
    }

    public ActionListener getSubmitChangeListener(ProfileView profileView) {
        return this.getActionListener((m) -> m.changeProfile(profileView.getChangedProfile()));
    }
    
    public ActionListener getSelectAvatarListener(ProfileView profileView) {
        return this.getActionListener((m) -> {
            try {
                ImageIcon imageIcon = profileView.pickAvatar();
                m.getProfile().setAvatar(imageIcon);
                profileView.updateAvatarLabel();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
