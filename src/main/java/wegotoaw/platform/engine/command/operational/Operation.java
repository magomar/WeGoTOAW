package wegotoaw.platform.engine.command.operational;

import wegotoaw.platform.engine.command.Objective;
import wegotoaw.platform.engine.command.operational.operations.OperationForm;
import wegotoaw.platform.engine.command.operational.operations.OperationType;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.scenario.forces.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public abstract class Operation {
    protected final Objective goal;
    protected final OperationType type;
    protected final OperationForm form;
    protected final List<Unit> units;
    protected final Map<Unit, TacticalMission> missions;

    public Operation(OperationType type, OperationForm form, List<Unit> units, Objective goal) {
        this.type = type;
        this.form = form;
        this.units = units;
        this.goal = goal;
        missions = new HashMap<>();
    }

    public abstract void plan();

    public OperationType getType() {
        return type;
    }

    public OperationForm getForm() {
        return form;
    }

    public Map<Unit, TacticalMission> getMissions() {
        return missions;
    }
}
