/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
class SecurityOperationalPlan extends OperationalPlan {

    public SecurityOperationalPlan(Formation formation, List<Objective> objectives, Emphasis emphasis, SupportScope supportScope)  {
        super(OperationalStance.SECURITY, formation, objectives, emphasis, supportScope);
    }

    @Override
    public void plan(Pathfinder pathFinder) {
        if (!goals.isEmpty()) {
            Objective objective = goals.first();
            for (Unit unit : formation.getAvailableUnits()) {
                TacticalMission mission = TacticalMissionType.OCCUPY.buildTacticalMission(unit, objective.getLocation(), pathFinder);
                unit.setMission(mission);
            }
        } else {
            for (Unit unit : formation.getAvailableUnits()) {
                TacticalMission mission = TacticalMissionType.OCCUPY.buildTacticalMission(unit, unit.getLocation(), pathFinder);
                unit.setMission(mission);
            }
        }
    }
}
