package wegotoaw.platform.engine.command.tactical.missions;

import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.command.tactical.TacticalMissionType;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class AttackByFire extends TacticalMission {

    public AttackByFire(TacticalMissionType type, Unit unit, Tile target) {
        super(type, unit, target);
    }


    @Override
    public void plan(Pathfinder pathFinder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
