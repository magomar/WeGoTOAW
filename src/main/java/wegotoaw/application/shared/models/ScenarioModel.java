package wegotoaw.application.shared.models;

import wegotoaw.application.shared.models.board.BoardModel;
import wegotoaw.application.shared.models.forces.ForceModel;
import wegotoaw.platform.model.RoleMediatedModel;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.Scenario;
import wegotoaw.platform.scenario.forces.Force;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public final class ScenarioModel extends RoleMediatedModel {

    private final Scenario scenario;
    private final ForceModel[] forceModel;

    public ScenarioModel(Scenario scenario, UserRole userRole) {
        super(userRole);
        this.scenario = scenario;
        Force[] forces = scenario.getForces();
        forceModel = new ForceModel[forces.length];
        for (int i = 0; i < forces.length; i++) {
            forceModel[i] = forces[i].getModel(userRole);
        }
    }

    public BoardModel getBoardModel() {
        return scenario.getBoard().getModel(userRole);
    }

    public ForceModel[] getForceModel() {
        return forceModel;

    }
}
