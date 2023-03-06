package wegotoaw.application.shared.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;

import javax.swing.*;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public interface ActionBarViewer<C extends JComponent, T extends AbstractButton> extends View<C> {

    void addActionButton(T actionButton);

    void addActionButtons(T[] actionButton);
}
