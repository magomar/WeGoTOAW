package wegotoaw.platform.engine.algorithms.pathfinding.heuristics;

import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Heine <heisncfr@inf.upv.es>
 */
public interface Heuristic {

    double getCost(Tile origin, Tile destination, Unit unit);

}
