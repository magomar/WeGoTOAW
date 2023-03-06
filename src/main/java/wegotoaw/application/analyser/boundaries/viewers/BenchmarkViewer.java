package wegotoaw.application.analyser.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;
import wegotoaw.platform.engine.movement.MovementType;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Saúl Esteban <saesmar1@ei.upv.es>
 */
public interface BenchmarkViewer extends View<JPanel> {

    AlgorithmSelectionViewer getAlgorithmSelectionView();

    ProblemGeneratorViewer getProblemGeneratorView();

    void setMovementTypeComboBoxModel(ComboBoxModel<MovementType> movementTypeComboBoxModel);

    void addMovementTypeActionListener(ActionListener actionListener);

    void addExecuteBenchmarkActionListener(ActionListener actionListener);

    void log(String text);

    MovementType getMovementType();
}
