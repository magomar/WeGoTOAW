package wegotoaw.platform.engine.command.tactical;

import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.command.tactical.missions.AttackByFire;
import wegotoaw.platform.engine.command.tactical.missions.Occupy;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public enum TacticalMissionType {

    //    ASSAULT(TacticalMissionAssault.class),
    ATTACK_BY_FIRE {
        @Override
        public TacticalMission buildTacticalMission(Unit unit, Tile target, Pathfinder pathFinder) {
            TacticalMission mission = new AttackByFire(this, unit, target);
            mission.plan(pathFinder);
            return mission;
        }
    },
    //    BREACH(TacticalMissionExample.class),
    //    BYPASS(TacticalMissionBypass.class),
    //    CLEAR(TacticalMissionExample.class),
    //    COMBAT_SEARCH_AND_RESCUE(TacticalMissionExample.class),
    //    REORGANIZATION(TacticalMissionExample.class),
    //    CONTROL(TacticalMissionExample.class),
    //    COUNTERRECONNAISSANCE(TacticalMissionExample.class),
    //    DISENGAGE(TacticalMissionExample.class),
    //    EXFILTRATE(TacticalMissionExample.class),
    //    FOLLOW_AND_ASSUME(TacticalMissionExample.class),
    //    FOLLOW_AND_SUPPORT(TacticalMissionFollowAndSupport.class),
    //    LINKUP(TacticalMissionExample.class),
    OCCUPY {
        @Override
        public TacticalMission buildTacticalMission(Unit unit, Tile target, Pathfinder pathFinder) {
            TacticalMission mission = new Occupy(this, unit, target);
            mission.plan(pathFinder);
            return mission;
        }
    },
    //    RECONSTITUTION(TacticalMissionExample.class),
    //    REDUCE(TacticalMissionExample.class),
    //    RETAIN(TacticalMissionExample.class),
    //    SECURE(TacticalMissionExample.class),
    //    SEIZE(TacticalMissionExample.class),
    //    SUPPORT_BY_FIRE(TacticalMissionSupportByFire.class),
    //    SUPPRESS(TacticalMissionExample.class),
    //    BLOCK(TacticalMissionExample.class),
    //    CANALIZE(TacticalMissionExample.class),
    //    CONTAIN(TacticalMissionExample.class),
    //    DEFEAT(TacticalMissionExample.class),
    //    DESTROY(TacticalMissionExample.class),
    //    DISRUPT(TacticalMissionExample.class),
    //    FIX(TacticalMissionFix.class),
    //    INTERDICT(TacticalMissionExample.class),
    //    ISOLATE(TacticalMissionExample.class),
    //    NEUTRALIZE(TacticalMissionExample.class),
    //    SUPRESS(TacticalMissionExample.class),
    //    TURN(TacticalMissionExample.class)
    ;

    public abstract TacticalMission buildTacticalMission(Unit unit, Tile target, Pathfinder pathFinder);
}
