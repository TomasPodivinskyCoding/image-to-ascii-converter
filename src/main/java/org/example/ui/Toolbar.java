package org.example.ui;

import org.example.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Toolbar extends JPanel {

    private final ImageContent imageContent;
    private String selectedFile;

    public Toolbar(ImageContent imageContent) {
        this.imageContent = imageContent;
        this.setBackground(Color.lightGray);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(320, 224));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 0);

        JButton convert = new JButton();
        convert.addActionListener(e-> {
            try {
                imageContent.loadImage(ImageIO.read(new File(selectedFile)));
                Main.switchFrameView("image");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton imageChooser = new JButton("Choose image");
        imageChooser.addActionListener(e-> {
            FileDialog fileDialog = new FileDialog(Main.getFrame(), "Choose image", FileDialog.LOAD);
            fileDialog.setFilenameFilter((dir, name) -> name.endsWith(".jpeg") || name.endsWith(".jpg") || name.endsWith(".png"));
            fileDialog.setVisible(true);
            this.selectedFile = fileDialog.getDirectory() + fileDialog.getFile();

            imageChooser.setText("Choose different image");
            convert.setText("Convert " + fileDialog.getFile());
            this.add(convert, gbc);
        });
        gbc.gridy++;
        this.add(imageChooser, gbc);
        gbc.gridy++;
    }

}
