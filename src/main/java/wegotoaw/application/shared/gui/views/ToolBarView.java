package wegotoaw.application.shared.gui.views;

import wegotoaw.application.shared.boundaries.viewers.ToolBarViewer;
import wegotoaw.application.shared.gui.ComponentFactory;

import javax.swing.*;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class ToolBarView extends AbstractView<JToolBar> implements ToolBarViewer {

    @Override
    protected JToolBar layout() {
        return ComponentFactory.toolBar("Tools");
    }

    @Override
    public void addActionButton(JButton actionButton) {
        contentPane.add(actionButton);
    }

    @Override
    public void addActionButtons(JButton[] actionButton) {
        for (JButton jButton : actionButton) {
            contentPane.add(jButton);
        }
    }
}
