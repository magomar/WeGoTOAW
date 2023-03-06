package wegotoaw.platform.engine.combat;

import wegotoaw.platform.engine.action.AbstractInteraction;
import wegotoaw.platform.engine.action.Action;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.SurfaceUnit;
import wegotoaw.platform.scenario.forces.TargetClass;
import wegotoaw.platform.scenario.forces.Unit;

import java.util.Collection;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class Combat extends AbstractInteraction {

    protected static final double ASSAULT_KILLING_RATIO = 1.0;
    protected static final double ATTACK_KILLING_RATIO = 0.66;
    protected static final double SUPPORT_KILLING_RATIO = 0.66;
    protected static final double DEFENSE_KILLING_RATIO = 1;

    protected Tile location;

    public Combat(Action action) {
        super(action);
    }


    @Override
    public void execute() {
        // TODO combat execution
        Collection<SurfaceUnit> defenders = location.getSurfaceUnits();
        // Defenders
        // Determine the number of defenders classified by target class
        for (SurfaceUnit defender : defenders) {
            TargetClass targetClass = defender.getUnitType().getTargetClass();
        }
        // Attackers
        for (Action action : actions) {
            Unit unit = action.getUnit(); //This is an attacker

        }
    }
}
