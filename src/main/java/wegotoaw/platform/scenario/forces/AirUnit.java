package wegotoaw.platform.scenario.forces;

import wegotoaw.platform.engine.movement.MovementType;
import wegotoaw.platform.scenario.Scenario;
import wegotoaw.platform.scenario.assets.Asset;
import wegotoaw.platform.scenario.assets.AssetType;

/**
 * @author Mario Gomez <margomez antiTank dsic.upv.es>
 */
public class AirUnit extends Unit {

    protected AirUnit() {
    }

    public AirUnit(wegotoaw.data.wrappers.scenario.Unit unit, Formation formation, Force force, Scenario scenario) {
        super(unit, formation, force, scenario);
        movementType = MovementType.AIRCRAFT;
        speed = Integer.MAX_VALUE;
        for (Asset asset : assets.values()) {
            AssetType assetType = asset.getType();
            int amount = asset.getNumber();
            if (amount > 0) {
                speed = Math.min(speed, assetType.getSpeed());
            }
        }
    }
}
