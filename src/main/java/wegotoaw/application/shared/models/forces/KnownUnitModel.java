package wegotoaw.application.shared.models.forces;

import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public final class KnownUnitModel extends IdentifiedUnitModel {

    public KnownUnitModel(Unit unit) {
        super(unit, KnowledgeCategory.COMPLETE);
    }

    public int getStamina() {
        return unit.getEndurance() * 100 / Unit.MAX_ENDURANCE;
    }

    @Override
    public TacticalMission getTacticalMission() {
        return unit.getMission();
    }
}
