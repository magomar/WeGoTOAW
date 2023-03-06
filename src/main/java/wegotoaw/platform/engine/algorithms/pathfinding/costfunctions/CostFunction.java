package wegotoaw.platform.engine.algorithms.pathfinding.costfunctions;

import wegotoaw.platform.scenario.board.Direction;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public interface CostFunction {
    double getCost(Direction dir, Tile destination, Unit unit);
}
