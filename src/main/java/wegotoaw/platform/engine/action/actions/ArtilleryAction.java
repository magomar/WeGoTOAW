package wegotoaw.platform.engine.action.actions;

import wegotoaw.platform.engine.action.AbstractAction;
import wegotoaw.platform.engine.action.ActionSpace;
import wegotoaw.platform.engine.action.ActionType;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class ArtilleryAction extends AbstractAction {

    private final Tile target;

    public ArtilleryAction(ActionType actionType, Unit unit, int start, int duration, Tile target) {
        super(actionType, unit, start, duration);
        this.target = target;
    }

    public Tile getTarget() {
        return target;
    }

    @Override
    protected void applyOngoingEffects(ActionSpace actionSpace) {
    }

    @Override
    public boolean isFeasible() {
        return true;
    }
}
