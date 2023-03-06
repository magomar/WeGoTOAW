package wegotoaw.application.shared.boundaries.interactors;

import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.Scenario;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface ScenarioInteractor extends Interactor {

    void newScenario(Scenario scenario, UserRole userRole);

    void forgetScenario();
}
