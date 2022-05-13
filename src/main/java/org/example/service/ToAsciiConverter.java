package org.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ToAsciiConverter {

    public static String convert(BufferedImage inputImage) {
        final String greyscaleCharacters = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
        int greyscaleCharactersLength = greyscaleCharacters.length();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < inputImage.getHeight(); i++) {
            for (int j = 0; j < inputImage.getWidth(); j++) {
                int rgb = inputImage.getRGB(j, i);
                double brightness = (0.2126 * getRed(rgb)) + (0.7152 * getGreen(rgb)) + (0.0722 * getBlue(rgb));
                output.append(greyscaleCharacters.charAt((int) (brightness / greyscaleCharactersLength)));
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static int getRed(int rgb) {
        return (rgb >> 16) & 0xFF;
    }

    public static int getGreen(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    public static int getBlue(int rgb) {
        return (rgb) & 0xFF;
    }

}
