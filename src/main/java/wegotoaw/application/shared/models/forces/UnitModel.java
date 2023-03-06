package wegotoaw.application.shared.models.forces;

import wegotoaw.application.shared.models.board.TileModel;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.engine.movement.MovementType;
import wegotoaw.platform.model.KnowledgeMediatedModel;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.forces.Unit;
import wegotoaw.platform.scenario.forces.UnitsColor;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public abstract class UnitModel extends KnowledgeMediatedModel {

    protected final Unit unit;

    public UnitModel(Unit unit, KnowledgeCategory kLevel) {
        super(kLevel);
        this.unit = unit;
    }

    public abstract String getName();

    public abstract UnitsColor getColor();

    public abstract int getIconId();

    public abstract TileModel getLocation();

    public abstract String getFormation();

    public abstract String getForce();

    public abstract String getDescription();

    public abstract TacticalMission getTacticalMission();

    public MovementType getMovement() {
        return unit.getMovementType();
    }

    public FormationModel getFormationModel(UserRole role) {
        return unit.getFormation().getModel(role);
    }

    @Override
    public String toString() {
        return getName();
    }


}
