package wegotoaw.application.analyser.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;
import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Author: Mario Gómez Martínez <magomar@gmail.com>
 */
public interface AlgorithmSelectionViewer extends View<JPanel> {
    AlgorithmConfigurationViewer getAlgorithmConfigurationView();

    ListModel<Pathfinder> getSelectedAlgorithmsListModel();

    ListSelectionModel getSelectedAlgorithmsListSelectionModel();

    void setSelectedAlgorithmsListModel(ListModel<Pathfinder> listModel);

    void setAlgorithmListSelectionMode(ListSelectionModel listSelectionModel);

    void addAddAlgorithmActionListener(ActionListener actionListener);

    void addRemoveAlgorithmActionListener(ActionListener actionListener);
}
