package org.example.service;

import org.example.ui.ImageContent;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ImageContentScaleListener implements MouseWheelListener {

    private final ImageContent imageContent;

    public ImageContentScaleListener(ImageContent imageContent) {
        this.imageContent = imageContent;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double wheelRotationFactor = e.getPreciseWheelRotation() / 100;
        imageContent.setScale(imageContent.getScale() - wheelRotationFactor);
        imageContent.repaint();
    }

}
