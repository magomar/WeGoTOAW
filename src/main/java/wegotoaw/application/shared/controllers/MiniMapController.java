package wegotoaw.application.shared.controllers;

import wegotoaw.application.player.boundaries.interactors.MiniMapInteractor;
import wegotoaw.application.shared.boundaries.viewers.BoardViewer;
import wegotoaw.application.shared.boundaries.viewers.layerviewers.MiniMapNavigationLayerViewer;
import wegotoaw.application.shared.boundaries.viewers.layerviewers.TerrainLayerViewer;
import wegotoaw.application.shared.boundaries.viewers.layerviewers.UnitsLayerViewer;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.views.layerviews.MiniMapNavigationLayerView;
import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.Scenario;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class MiniMapController {

    private final BoardViewer miniMapView;
    private final BoardViewer boardView;
    private final TerrainLayerViewer terrainLayerView;
    private final UnitsLayerViewer unitsLayerView;
    private final MiniMapNavigationLayerViewer navigationLayerView;
    private Scenario scenario;
    protected UserRole userRole;

    public MiniMapController(MiniMapInteractor miniMapInteractor) {
        miniMapView = miniMapInteractor.getMiniMapView();
        boardView = miniMapInteractor.getBoardView();
        terrainLayerView = (TerrainLayerViewer) miniMapView.getLayerView(TerrainLayerViewer.NAME);
        unitsLayerView = (UnitsLayerViewer) miniMapView.getLayerView(UnitsLayerViewer.NAME);
        navigationLayerView = (MiniMapNavigationLayerViewer) miniMapView.getLayerView(MiniMapNavigationLayerView.NAME);
        miniMapView.addMouseListener(new MiniMapMouseListener());
    }

    public void setScenario(Scenario scenario, UserRole userRole, int profile) {
        this.scenario = scenario;
        this.userRole = userRole;
        miniMapView.setProfile(profile);
        // Render board: paint terrain and units
        ScenarioModel scenarioModel = scenario.getModel(userRole);
        terrainLayerView.updateScenario(scenarioModel);
        unitsLayerView.updateScenario(scenarioModel);
        navigationLayerView.update(boardView.getContentPane().getViewport(), boardView.getProfile());
    }

    public void updateScenario() {
        // Render board: paint terrain and units
        ScenarioModel scenarioModel = scenario.getModel(userRole);
        unitsLayerView.updateScenario(scenarioModel);
    }

    public void changeBoardViewport() {
        navigationLayerView.update(boardView.getContentPane().getViewport(), boardView.getProfile());
    }

    private class MiniMapMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent me) {
            switch (me.getButton()) {
                case MouseEvent.BUTTON1:
                    Point tileCoord = GraphicsModel.INSTANCE.pixelToTile(me.getPoint(), miniMapView.getProfile());
                    boardView.centerViewOn(tileCoord);
                    break;
            }

        }
    }
}
