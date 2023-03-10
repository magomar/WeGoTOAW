package wegotoaw.platform.scenario.forces;

import wegotoaw.platform.engine.movement.MovementType;
import wegotoaw.platform.scenario.Scenario;

import java.util.Set;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class UnitFactory {
    private UnitFactory() {
    }

    public static Unit createUnit(wegotoaw.data.wrappers.scenario.Unit unit, Formation formation, Force force, Scenario scenario) {
        UnitType type = UnitType.valueOf(unit.getType().name());
        Set<Capability> capabilities = type.getCapabilities();
        if (capabilities.contains(Capability.AIRCRAFT)) {
            return new AirUnit(unit, formation, force, scenario);
        }
        if (capabilities.contains(Capability.NAVAL)) {
            return new NavalUnit(unit, formation, force, scenario);
        }
        return new LandUnit(unit, formation, force, scenario);
    }

    public static Unit createTestUnit(MovementType movementType) {
        Unit unit;
        switch (movementType) {
            case AIRCRAFT:
                unit = new AirUnit();
                break;
            case NAVAL:
                unit = new NavalUnit();
                break;
            default:
                unit = new LandUnit();
        }
        unit.setMovementType(movementType);
        return unit;
    }

    //    private ares.data.jaxb.Orders createTestOrders() {
//        ares.data.jaxb.Orders orders = new Orders();
//        orders.setActivates(0);
//        orders.setEmphasis(Emphasis.LIMIT_LOSSES);
//        orders.setFrontage(Frontage.WIDE);
//        orders.setOnlyPO(true);
//        orders.setOperationalStance(OperationalStance.OFFENSIVE);
//        orders.setSupportscope(SupportScope.ARMY_SUPPORT);
//        return orders;
//    }
}
