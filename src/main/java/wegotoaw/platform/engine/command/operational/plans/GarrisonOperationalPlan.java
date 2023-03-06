package wegotoaw.platform.engine.command.operational.plans;

import wegotoaw.data.wrappers.scenario.Emphasis;
import wegotoaw.data.wrappers.scenario.SupportScope;
import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.command.Objective;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.command.tactical.TacticalMissionType;
import wegotoaw.platform.scenario.forces.Formation;
import wegotoaw.platform.scenario.forces.Unit;

import java.util.List;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
class GarrisonOperationalPlan extends OperationalPlan {

    public GarrisonOperationalPlan(Formation formation, List<Objective> objectives, Emphasis emphasis, SupportScope supportScope) {
        super(OperationalStance.GARRISON, formation, objectives, emphasis, supportScope);
    }

    @Override
    public void plan(Pathfinder pathFinder) {
        for (Unit unit : formation.getAvailableUnits()) {
            TacticalMission mission = TacticalMissionType.OCCUPY.buildTacticalMission(unit, unit.getLocation(), pathFinder);
            unit.setMission(mission);
        }
    }
}
