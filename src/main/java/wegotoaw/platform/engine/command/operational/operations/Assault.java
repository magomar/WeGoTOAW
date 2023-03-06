package wegotoaw.platform.engine.command.operational.operations;

import wegotoaw.platform.engine.command.Objective;
import wegotoaw.platform.engine.command.operational.Operation;
import wegotoaw.platform.scenario.forces.Unit;

import java.util.List;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class Assault extends Operation {

    public Assault(OperationType type, OperationForm form, List<Unit> units, Objective goal) {
        super(type, form, units, goal);
    }

    @Override
    public void plan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
