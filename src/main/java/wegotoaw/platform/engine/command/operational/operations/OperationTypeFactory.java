package wegotoaw.platform.engine.command.operational.operations;

import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.command.Objective;
import wegotoaw.platform.engine.command.operational.Operation;
import wegotoaw.platform.scenario.forces.Formation;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public interface OperationTypeFactory {
    Operation getNewOperation(OperationType opType, Formation formation, Objective goal, Pathfinder pathFinder);
}
