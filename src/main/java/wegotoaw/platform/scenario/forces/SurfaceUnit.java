package wegotoaw.platform.scenario.forces;

import wegotoaw.platform.scenario.Scenario;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public abstract class SurfaceUnit extends Unit {

    protected SurfaceUnit() {
        super();
    }

    public SurfaceUnit(wegotoaw.data.wrappers.scenario.Unit unit, Formation formation, Force force, Scenario scenario) {
        super(unit, formation, force, scenario);
    }
}
