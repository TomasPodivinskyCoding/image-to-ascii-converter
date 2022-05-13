package org.example.ui;

import org.example.service.ToAsciiConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageContent extends JPanel {

    private String asciiContent;

    private double scale = 0.07;

    public ImageContent() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D) g;
        gd.setColor(Color.BLACK);
        gd.scale(scale, scale);
        gd.setFont(new Font("Courier", Font.PLAIN, 40));
        drawString(gd, asciiContent, 10, 10);
    }

    private void drawString(Graphics2D g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void loadImage(BufferedImage bufferedImage) {
        asciiContent = ToAsciiConverter.convert(bufferedImage);
        this.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        this.repaint();
        this.revalidate();
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
