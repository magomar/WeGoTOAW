package wegotoaw.platform.engine.algorithms.pathfinding;

import wegotoaw.platform.engine.algorithms.pathfinding.costfunctions.CostFunction;
import wegotoaw.platform.engine.algorithms.pathfinding.heuristics.Heuristic;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Heine <heisncfr@inf.upv.es>
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public interface Pathfinder {

    Path findPath(Tile origin, Tile destination, Unit unit);

    ExtendedPath getExtendedPath(Tile origin, Tile destination, Unit unit);

    void setHeuristic(Heuristic heuristic);

    void setCostFunction(CostFunction costFunction);

    Heuristic getHeuristic();

    CostFunction getCostFunction();

    String toStringVerbose();

    Pathfinder copy();
}
