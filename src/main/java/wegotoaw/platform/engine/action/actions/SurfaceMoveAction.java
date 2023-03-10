package wegotoaw.platform.engine.action.actions;

import wegotoaw.platform.engine.action.ActionType;
import wegotoaw.platform.engine.algorithms.pathfinding.Path;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 *
 * Movement action for surface units
 *
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class SurfaceMoveAction extends MoveAction {

    public SurfaceMoveAction(ActionType actionType, Unit unit, Path path) {
        this(actionType, unit, AS_SOON_AS_POSSIBLE, path);
    }

    public SurfaceMoveAction(ActionType actionType, Unit unit, int start, Path path) {
        this(actionType, unit, start, TIME_UNKNOWN, path);
    }

    public SurfaceMoveAction(ActionType actionType, Unit unit, int start, int duration, Path path) {
        super(actionType, unit, start, duration, path);
    }

    @Override
    public boolean isFeasible() {
        Tile nextDestination = currentNode.getTile();
        return !nextDestination.hasEnemies(unit.getForce());
    }
}
