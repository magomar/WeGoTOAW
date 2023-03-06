package wegotoaw.application.shared.models.forces;

import wegotoaw.application.shared.models.board.TileModel;
import wegotoaw.platform.engine.command.tactical.TacticalMission;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.scenario.forces.Unit;
import wegotoaw.platform.scenario.forces.UnitType;
import wegotoaw.platform.scenario.forces.UnitsColor;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class DetectedUnitModel extends UnitModel {

    public DetectedUnitModel(Unit unit) {
        super(unit, KnowledgeCategory.POOR);
    }

    protected DetectedUnitModel(Unit unit, KnowledgeCategory kLevel) {
        super(unit, kLevel);
    }

    public UnitType getUnitType() {
        return unit.getUnitType();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public UnitsColor getColor() {
        return unit.getColor();
    }

    @Override
    public int getIconId() {
        return unit.getIconId();
    }

    @Override
    public TileModel getLocation() {
        return unit.getLocation().getModel(kLevel);
    }

    @Override
    public String getFormation() {
        return "";
    }

    @Override
    public String getForce() {
        return unit.getForce().getName();
    }

    @Override
    public String getDescription() {
        return unit.getUnitType().name();
    }

    @Override
    public TacticalMission getTacticalMission() {
        return null;
    }
}
