package com.example.swingmvcdemo.Profile;

import com.example.swingmvcdemo.ApplicationModel;
import lombok.Getter;

@Getter
public class ProfileModel extends ApplicationModel {
    private Profile profile = new Profile();

    public String getProfileFullName() {
        return (this.profile.getName() == null ? "" : this.profile.getName()) + " "
                + (this.profile.getSurname() == null ? "" : this.profile.getSurname());
    }

    public void changeProfile(Profile newValue) {
        Profile old = new Profile(this.profile);

        this.profile.setName(newValue.getName());
        this.profile.setSurname(newValue.getSurname());
        this.profile.setAvatar(newValue.getAvatar());

        this.support.firePropertyChange(this.getClass().toString(), old, newValue);
    }

    public boolean profileIsEmpty() {
        return this.profile.getName() == null && this.profile.getSurname() == null;
    }

    public void resetProfile() {
        this.profile = new Profile();
    }
}
