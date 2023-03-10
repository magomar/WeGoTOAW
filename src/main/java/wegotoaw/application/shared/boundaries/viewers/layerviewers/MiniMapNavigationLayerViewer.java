package wegotoaw.application.shared.boundaries.viewers.layerviewers;

import javax.swing.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface MiniMapNavigationLayerViewer extends ImageLayerViewer {

    static final String NAME = "MINI_MAP_NAVIGATION_LAYER";

    void update(JViewport boardViewport, int boardProfile);
}
