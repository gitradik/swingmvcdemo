package com.example.swingmvcdemo.Profile;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Profile {
    private String name;
    private String surname;
    private ImageIcon avatar;

    public Profile() {}
    public Profile(String name, String surname, ImageIcon avatar) {
        this.name = name;
        this.surname = surname;
        this.avatar = avatar;
    }
    public Profile(Profile profile) {
        this.name = profile.getName();
        this.surname = profile.getSurname();
        this.avatar = profile.getAvatar();
    }
}
