package org.example;

import org.example.service.ImageContentScaleListener;
import org.example.ui.ImageContent;
import org.example.ui.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {

    private static final JFrame frame = new JFrame("To ASCII Converter");
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel cardLayoutHolder = new JPanel();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.add(cardLayoutHolder, BorderLayout.CENTER);
        cardLayoutHolder.setLayout(cardLayout);

        ImageContent imageContent = new ImageContent();
        ImageContentScaleListener scaleListener = new ImageContentScaleListener(imageContent);
        imageContent.addMouseWheelListener(scaleListener);

        Toolbar toolbar = new Toolbar(imageContent);
        cardLayoutHolder.add("toolbar", toolbar);
        cardLayoutHolder.add("image", imageContent);

        frame.pack();
        frame.revalidate();
        frame.repaint();
    }

    public static JFrame getFrame() {
        return Main.frame;
    }

    public static void switchFrameView(String name) {
        cardLayout.show(cardLayoutHolder, name);
        frame.pack();
    }

}