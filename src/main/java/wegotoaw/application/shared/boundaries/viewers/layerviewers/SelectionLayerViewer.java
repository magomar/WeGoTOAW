package wegotoaw.application.shared.boundaries.viewers.layerviewers;

import wegotoaw.application.shared.models.forces.FormationModel;
import wegotoaw.application.shared.models.forces.UnitModel;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface SelectionLayerViewer extends ImageLayerViewer {

    public static final String NAME = "SELECTION_LAYER";

    void updateSelectedUnit(UnitModel selectedUnit, FormationModel selectedFormation);
}
