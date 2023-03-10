package wegotoaw.application.analyser.views;

import wegotoaw.application.analyser.boundaries.viewers.AlgorithmConfigurationViewer;
import wegotoaw.application.shared.gui.views.AbstractView;
import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.algorithms.pathfinding.costfunctions.CostFunction;
import wegotoaw.platform.engine.algorithms.pathfinding.heuristics.Heuristic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class AlgorithmConfigurationView extends AbstractView<JPanel> implements AlgorithmConfigurationViewer {

    private JComboBox<Pathfinder> pathfinderComboBox;
    private JComboBox<Heuristic> heuristicComboBox;
    private JComboBox<CostFunction> costFunctionComboBox;

    @Override
    protected JPanel layout() {
        pathfinderComboBox = new JComboBox<>();
        heuristicComboBox = new JComboBox<>();
        costFunctionComboBox = new JComboBox<>();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Select Pathfinder:"), c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(pathfinderComboBox, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Select Heuristic:"), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(heuristicComboBox, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Select Cost Function:"), c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(costFunctionComboBox, c);
        return panel;
    }

    @Override
    public void setPathfinderComboModel(ComboBoxModel<Pathfinder> comboModel, ActionListener listener) {
        pathfinderComboBox.setModel(comboModel);
        pathfinderComboBox.addActionListener(listener);
    }

    @Override
    public void setHeuristicComboModel(ComboBoxModel<Heuristic> comboModel, ActionListener listener) {
        heuristicComboBox.setModel(comboModel);
        heuristicComboBox.addActionListener(listener);
    }

    @Override
    public void setCostFunctionComboModel(ComboBoxModel<CostFunction> comboModel, ActionListener listener) {
        costFunctionComboBox.setModel(comboModel);
        costFunctionComboBox.addActionListener(listener);
    }

    @Override
    public ComboBoxModel<Pathfinder> getPathfinderComboModel() {
        return pathfinderComboBox.getModel();
    }

    @Override
    public ComboBoxModel<Heuristic> getHeuristicComboModel() {
        return heuristicComboBox.getModel();
    }

    @Override
    public ComboBoxModel<CostFunction> getCostFunctionComboModel() {
        return costFunctionComboBox.getModel();
    }
}
