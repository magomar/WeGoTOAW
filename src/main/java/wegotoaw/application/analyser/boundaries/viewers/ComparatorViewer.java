package wegotoaw.application.analyser.boundaries.viewers;

import wegotoaw.application.shared.boundaries.viewers.BoardViewer;
import wegotoaw.application.shared.gui.views.View;
import wegotoaw.platform.engine.movement.MovementType;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface ComparatorViewer extends View<JPanel> {
    static final int LEFT = 0;
    static final int RIGHT = 1;

    BoardViewer getBoardView(int side);

    AlgorithmConfigurationViewer getConfigurationView(int side);

    ComboBoxModel<PathfindingLayerViewer.ShowCostType>  getCostTypeComboModel();

    JPanel getStatsPanel();

    void setMovementTypeComboModel(ComboBoxModel<MovementType> comboModel);

    void setShowCostTypeComboModel(ComboBoxModel<PathfindingLayerViewer.ShowCostType> comboModel);

    ComboBoxModel<MovementType> getMovementTypeComboModel();

    void addMovementTypeActionListener(ActionListener actionListener);
}
