package wegotoaw.platform.engine.action.actions;

import wegotoaw.platform.engine.action.AbstractAction;
import wegotoaw.platform.engine.action.ActionSpace;
import wegotoaw.platform.engine.action.ActionType;
import wegotoaw.platform.engine.time.Clock;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class RestAction extends AbstractAction {

    /**
     * Default sleep time in time ticks
     */
    public static final int SLEEP_TIME = 8 * 60 / Clock.INSTANCE.getMINUTES_PER_TICK();

    public RestAction(Unit unit) {
        super(ActionType.REST, unit, AS_SOON_AS_POSSIBLE, SLEEP_TIME);
    }

    @Override
    protected void applyOngoingEffects(ActionSpace actionSpace) {
    }

    @Override
    public boolean isFeasible() {
        return true;
    }
}
