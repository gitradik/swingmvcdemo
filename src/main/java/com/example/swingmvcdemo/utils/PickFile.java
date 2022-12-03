package com.example.swingmvcdemo.utils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class PickFile {
    private final JFileChooser chooser;
    private File file;

    public File getFile() {
        return this.file;
    }

    public PickFile(FileNameExtensionFilter filter) {
        this.chooser = new JFileChooser();
        chooser.setFileFilter(filter);
    }

    public boolean run() {
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.file = this.chooser.getSelectedFile();
            return true;
        }
        return false;
    }
}
