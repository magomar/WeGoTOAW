package wegotoaw.application.shared.gui.components;

import wegotoaw.platform.io.FileIO;
import wegotoaw.platform.io.ResourcePath;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Random;

/**
 * Main menu and welcome screen. Sets a background picture and handles the main menu buttons.
 *
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public final class MainMenuPanel extends JPanel {

    /**
     * Background image to be loaded
     */
    private SoftReference<BufferedImage> backgroundImage = new SoftReference<>(null);

    public MainMenuPanel() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        add(Box.createRigidArea(new Dimension(0, 300)));
        updateBackgroundImage();
    }

    public void updateBackgroundImage() {
        if (backgroundImage.get() == null) {
            BufferedImage bi = FileIO.loadImage(randomImageFile());
            backgroundImage = new SoftReference<>(bi);
        }
    }

    private File randomImageFile() {
        File[] backgrounds = ResourcePath.GRAPHICS_BACKGROUND.getFolderPath().toFile().listFiles();
        if (backgrounds == null || backgrounds.length == 0) {
            return ResourcePath.GRAPHICS.getFile("main_menu_background.jpg");
        }
        Integer index = new Random().nextInt(backgrounds.length);
        return backgrounds[index];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (backgroundImage.get() != null) {
            g2.drawImage(backgroundImage.get(), 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            g2.setBackground(Color.BLACK);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
}
