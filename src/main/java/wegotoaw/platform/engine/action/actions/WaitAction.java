package wegotoaw.platform.engine.action.actions;

import wegotoaw.platform.engine.action.AbstractAction;
import wegotoaw.platform.engine.action.ActionSpace;
import wegotoaw.platform.engine.action.ActionType;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class WaitAction extends AbstractAction {

    public WaitAction(Unit unit) {
        this(unit, AS_SOON_AS_POSSIBLE, TIME_UNKNOWN);
    }

    public WaitAction(Unit unit, int start, int duration) {
        super(ActionType.WAIT, unit, start, duration);
    }

    @Override
    protected void applyOngoingEffects(ActionSpace actionSpace) {
    }

    @Override
    public boolean isFeasible() {
        return true;
    }
}
