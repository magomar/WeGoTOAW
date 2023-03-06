package wegotoaw.platform.engine.algorithms.pathfinding;

import wegotoaw.platform.engine.algorithms.pathfinding.costfunctions.CostFunction;
import wegotoaw.platform.engine.algorithms.pathfinding.heuristics.Heuristic;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Heine <heisncfr@inf.upv.es>
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public abstract class AbstractPathfinder implements Pathfinder {

    protected Heuristic heuristic;
    protected CostFunction costFunction;

    protected AbstractPathfinder(Heuristic heuristic, CostFunction costFunction) {
        this.heuristic = heuristic;
        this.costFunction = costFunction;
    }

    @Override
    abstract public Path findPath(Tile origin, Tile destination, Unit unit);

    @Override
    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public void setCostFunction(CostFunction costFunction) {
        this.costFunction = costFunction;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public String toStringVerbose() {
        return getClass().getSimpleName() + "{" +
                "heuristic=" + heuristic +
                ", costFunction=" + costFunction +
                '}';
    }

}
