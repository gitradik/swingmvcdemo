package com.example.swingmvcdemo.Dashboard;

import com.example.swingmvcdemo.ApplicationModel;
import com.example.swingmvcdemo.ApplicationView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class DashboardView extends ApplicationView<DashboardModel> {
    private JPanel panel;
    private JButton profileBtn;

    public DashboardView(DashboardModel model) {
        super(new JFrame("Dashboard"), model);
    }

    @Override
    public void addChildComponent(JComponent component) {
        JPanel profilePanel = new JPanel();
        profilePanel.add(new JLabel("Hello,"));
        profilePanel.add(component);
        this.panel.add(profilePanel, BorderLayout.LINE_START);
    }

    @Override
    protected void registerToFrame(JFrame frame) {
        this.panel = new JPanel();
        this.profileBtn = new JButton("Profile");

        this.panel.setBorder(BorderFactory.createEmptyBorder(10, 20,10,20));
        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.profileBtn, BorderLayout.EAST);

        frame.add(this.panel, BorderLayout.PAGE_START);
//        frame.pack();
    }

    @Override
    public void applyChanges(String propertyName) {}

    @Override
    public void defaultFromOutside(ApplicationModel... models) {}
}
