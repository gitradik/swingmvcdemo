package com.example.swingmvcdemo.utils;

import com.example.swingmvcdemo.ApplicationProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageIconCreator {
    public static ImageIcon createImageIcon(String imageName) throws IOException {
        Image image = ImageIO.read(new File(ApplicationProperties.getProperty("imageDirectory") + imageName));

        if (image != null) {
            return new ImageIcon(image);
        } else {
            System.err.println("Couldn't find file: " + imageName);
            return null;
        }
    }
    public static ImageIcon createImageIcon(File file) throws IOException {
        Image image = ImageIO.read(file);

        if (image != null) {
            return new ImageIcon(image);
        } else {
            return null;
        }
    }

    public static ImageIcon scaleImage(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
}
