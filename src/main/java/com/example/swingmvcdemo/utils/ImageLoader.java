package com.example.swingmvcdemo.utils;

import com.example.swingmvcdemo.ApplicationProperties;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public static String saveImage(File file, String fileName) throws IOException {
        String createdFileName = createFileName(file, fileName);
        BufferedImage bi = ImageIO.read(new File(file.getPath()));
        File newFile = new File(ApplicationProperties.getProperty("imageDirectory") + createdFileName);
        ImageIO.write(bi, FilenameUtils.getExtension(file.getPath()), newFile);
        return createdFileName;
    }

    public static String createFileName(String... words) {
        StringBuilder name = new StringBuilder();

        short i = 0;
        for(String w : words) {
            if (i++ == words.length - 1) {
                name.append(w);
            } else {
                name.append(w).append("-");
            }
        }

        return name.toString();
    }

    private static String createFileName(File file, String fileName) {
        return fileName + "." + FilenameUtils.getExtension(file.getPath());
    }
}
