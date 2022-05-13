package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(args[0]));
        final String greyscaleCharacters = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
        int greyscaleCharactersLength = greyscaleCharacters.length();
        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                int rgb = inputImage.getRGB(i, j);
                double brightness = (0.2126 * getRed(rgb)) + (0.7152 * getGreen(rgb)) + (0.0722 * getBlue(rgb));
                System.out.print(greyscaleCharacters.charAt((int) (brightness / greyscaleCharactersLength)));
            }
            System.out.println();
        }
    }

    public static int getRed(int rgb) {
        return (rgb >> 16) & 0xFF;
    }

    public static int getGreen(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    public static int getBlue(int rgb) {
        return (rgb >> 0) & 0xFF;
    }

}