package com.example.swingmvcdemo.Profile;

import com.example.swingmvcdemo.ApplicationModel;
import com.example.swingmvcdemo.ApplicationView;
import com.example.swingmvcdemo.utils.ImageIconCreator;
import com.example.swingmvcdemo.utils.PickFile;
import lombok.Getter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

@Getter
public class ProfileView extends ApplicationView<ProfileModel> {
    private final JButton submitBtn = new JButton("Submit");
    private final JButton cancelBtn = new JButton("Cancel");
    private final JButton selectAvatarBtn = new JButton("Select");
    private final JLabel avatarLabel = new JLabel();

    private JTextField nameField;
    private JTextField surnameField;
    private JLabel fullNameLabel;

    public ProfileView(ProfileModel model) {
        super(new JFrame("Profile"), model);
    }

    public Profile getChangedProfile() {
        return new Profile(
                this.nameField.getText().isEmpty() ? null : this.nameField.getText(),
                this.surnameField.getText().isEmpty() ? null : this.surnameField.getText(),
                (ImageIcon) this.avatarLabel.getIcon()
        );
    }

//    public String pickAvatar() {
//        PickFile pickFile = new PickFile(new FileNameExtensionFilter("Avatar", "jpg", "png", "gif"));
//
//        if (pickFile.run()) {
//            try {
//                Profile p = this.model.getProfile();
//                return ImageLoader.saveImage(pickFile.getFile(), ImageLoader.createFileName(p.getName(), p.getSurname(), "avatar"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }

    public ImageIcon pickAvatar() throws IOException {
        PickFile pickFile = new PickFile(new FileNameExtensionFilter("Avatar", "jpg", "png", "gif"));

        if (pickFile.run()) {
            return ImageIconCreator.createImageIcon(pickFile.getFile());
        }

        return null;
    }

//    public boolean updateAvatarLabel() throws IOException {
//        try {
//            String avatarName = this.model.getProfile().getAvatar();
//            ImageIcon icon = ImageIconCreator.createImageIcon(avatarName == null ? "default-avatar.png" : avatarName);
//            assert icon != null;
//            this.avatarLabel.setIcon(ImageIconCreator.scaleImage(icon, 100, 100));
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    public void updateAvatarLabel() {
        if (this.model.getProfile().getAvatar() != null) {
            this.avatarLabel.setIcon(ImageIconCreator.scaleImage(this.model.getProfile().getAvatar(), 100, 100));
        }
    }

    public JPanel generateDetailsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        this.fullNameLabel = new JLabel(this.model.profileIsEmpty() ? "Guest" : this.model.getProfileFullName());
        p.add(this.fullNameLabel, BorderLayout.PAGE_START);
        return p;
    }

    private JPanel generateFormPanel() throws IOException {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

        JPanel namePanel = new JPanel(new BorderLayout());
        JPanel surnamePanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridLayout(2, 0));
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        surnamePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));

        JLabel nameLabel = new JLabel("Name: ", JLabel.TRAILING);
        nameLabel.setPreferredSize(new Dimension(70, 0));
        this.nameField = new JTextField(this.model.getProfile().getName());
        this.nameField.setPreferredSize(new Dimension(0, 30));
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(this.nameField, BorderLayout.CENTER);

        JLabel surnameLabel = new JLabel("Surname: ", JLabel.TRAILING);
        surnameLabel.setPreferredSize(new Dimension(70, 0));
        this.surnameField = new JTextField(this.model.getProfile().getSurname());
        this.surnameField.setPreferredSize(new Dimension(0, 30));
        surnamePanel.add(surnameLabel, BorderLayout.WEST);
        surnamePanel.add(this.surnameField, BorderLayout.CENTER);

        JPanel avatarPanel = new JPanel();
        this.updateAvatarLabel();
        avatarPanel.add(this.avatarLabel);
        this.avatarLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));

        avatarPanel.add(this.selectAvatarBtn);
        p.add(avatarPanel);

        fieldPanel.add(namePanel);
        fieldPanel.add(surnamePanel);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.LINE_AXIS));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        btnPanel.add(Box.createHorizontalGlue());
        btnPanel.add(this.cancelBtn);
        btnPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        btnPanel.add(this.submitBtn);

        p.add(fieldPanel);
        p.add(btnPanel);

        return p;
    }

    @Override
    protected void registerToFrame(JFrame frame) {
        JPanel p = (JPanel) frame.getContentPane();
        p.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        try {
            JPanel formPanel = this.generateFormPanel();
            p.add(formPanel, BorderLayout.PAGE_START);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setMinimumSize(new Dimension(400, 0));
        frame.pack();
    }

    @Override
    public void addChildComponent(JComponent component) {
    }

    @Override
    public void applyChanges(String propertyName) {
        if (Objects.equals(propertyName, this.model.getClass().toString()) && !this.model.profileIsEmpty()) {
            this.fullNameLabel.setText(this.model.getProfileFullName());
        }
    }

    @Override
    public void defaultFromOutside(ApplicationModel... models) {
    }
}
