package wegotoaw.application.shared.boundaries.viewers.layerviewers;

import wegotoaw.application.shared.models.ScenarioModel;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface GridLayerViewer extends ImageLayerViewer {

    public static final String NAME = "GRID_LAYER";

    public void updateScenario(ScenarioModel scenarioModel);
}
