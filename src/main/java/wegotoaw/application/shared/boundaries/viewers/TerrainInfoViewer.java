package wegotoaw.application.shared.boundaries.viewers;

import wegotoaw.application.shared.gui.views.View;
import wegotoaw.application.shared.models.board.TileModel;

import javax.swing.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface TerrainInfoViewer extends View<JPanel> {

    void flush();

    void updateTile(TileModel tileModel);

    void clear();
}
