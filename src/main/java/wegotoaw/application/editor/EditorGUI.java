package wegotoaw.application.editor;

import wegotoaw.application.editor.controllers.EditorController;
import wegotoaw.application.player.AresPlayerGUI;
import wegotoaw.application.shared.gui.WindowUtil;
import wegotoaw.application.shared.gui.views.AbstractView;
import net.sf.tinylaf.Theme;
import net.sf.tinylaf.ThemeDescription;
import net.sf.tinylaf.TinyLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class EditorGUI extends AbstractView<JFrame> {
    @Override
    protected JFrame layout() {
        return new JFrame();
    }

    public static void main(String[] args) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
        try {
            UIManager.setLookAndFeel("net.sf.tinylaf.TinyLookAndFeel");
            ThemeDescription[] themes = Theme.getAvailableThemes();
            for (ThemeDescription theme: themes) {
                if ("DarkOlive".equals(theme.getName())) Theme.loadTheme(theme);
            }
            UIManager.setLookAndFeel(new TinyLookAndFeel());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AresPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EditorGUI mainView = new EditorGUI();
                new EditorController(mainView);
                WindowUtil.centerAndShow(mainView.contentPane);
            }
        });
    }
}
