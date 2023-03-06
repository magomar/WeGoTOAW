package wegotoaw.application.shared.boundaries.viewers.layerviewers;

import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.application.shared.models.board.TileModel;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface UnitsLayerViewer extends ImageLayerViewer {

    public static final String NAME = "UNITS_LAYER";

    void updateScenario(ScenarioModel scenario);

    void updateUnitStack(TileModel tile);
}
