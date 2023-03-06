package wegotoaw.application.shared.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;
import wegotoaw.application.shared.models.board.TileModel;
import wegotoaw.application.shared.models.forces.UnitModel;

import javax.swing.*;
import java.util.Calendar;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public interface InfoViewer extends View<JPanel> {

    void updateUnitInfo(UnitModel unitModel);

    void updateTileInfo(TileModel tile);

    void updateScenarioInfo(Calendar calendar);

    void clear();
}
