package wegotoaw.application.shared.gui.views;

import wegotoaw.application.shared.gui.views.layerviews.AbstractBoardView;
import wegotoaw.application.shared.gui.views.layerviews.MiniMapNavigationLayerView;
import wegotoaw.application.shared.gui.views.layerviews.TerrainLayerView;
import wegotoaw.application.shared.gui.views.layerviews.UnitsLayerView;

import javax.swing.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class MiniMapView extends AbstractBoardView {

    @Override
    protected JScrollPane layout() {
        JScrollPane scrollPane = super.layout();
        JViewport v = scrollPane.getViewport();
        TerrainLayerView terrainLayer = (TerrainLayerView) new TerrainLayerView().setViewport(v);
        UnitsLayerView unitsLayer = (UnitsLayerView) new UnitsLayerView().setViewport(v);
        MiniMapNavigationLayerView navigationLayer = (MiniMapNavigationLayerView) new MiniMapNavigationLayerView().setViewport(v);

        addLayerView(terrainLayer).addLayerView(unitsLayer).addLayerView(navigationLayer);
        return scrollPane;
    }

}
