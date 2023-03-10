package wegotoaw.application.analyser.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;
import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.algorithms.pathfinding.costfunctions.CostFunction;
import wegotoaw.platform.engine.algorithms.pathfinding.heuristics.Heuristic;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface AlgorithmConfigurationViewer extends View<JPanel> {

    void setPathfinderComboModel(ComboBoxModel<Pathfinder> comboModel, ActionListener listener);

    void setHeuristicComboModel(ComboBoxModel<Heuristic> comboModel, ActionListener listener);

    void setCostFunctionComboModel(ComboBoxModel<CostFunction> comboModel, ActionListener listener);

    ComboBoxModel<Pathfinder> getPathfinderComboModel();

    ComboBoxModel<Heuristic> getHeuristicComboModel();

    ComboBoxModel<CostFunction> getCostFunctionComboModel();
}
