package wegotoaw.application.shared.gui.views;

import wegotoaw.application.shared.boundaries.viewers.MenuBarViewer;
import wegotoaw.application.shared.gui.ComponentFactory;

import javax.swing.*;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class MenuBarView extends AbstractView<JMenuBar> implements MenuBarViewer {

    @Override
    protected JMenuBar layout() {
        return ComponentFactory.menuBar();
    }

    @Override
    public void addActionButton(JMenu menu) {
        contentPane.add(menu);
    }

    @Override
    public void addActionButtons(JMenu[] actionButton) {
        for (JMenu jMenu : actionButton) {
            contentPane.add(jMenu);
        }
    }
}
