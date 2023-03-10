package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.TerrainLayerViewer;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.application.shared.models.board.TileModel;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.scenario.board.Directions;
import wegotoaw.platform.scenario.board.Feature;
import wegotoaw.platform.scenario.board.Terrain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @author Heine <heisncfr@inf.upv.es>
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class TerrainLayerView extends AbstractImageLayerView implements TerrainLayerViewer {

    private ScenarioModel scenario;

    @Override
    public String name() {
        return TerrainLayerViewer.NAME;
    }

    @Override
    public void updateLayer() {
        initialize();
        if (!isVisible()) return;
        Graphics2D g2 = globalImage.createGraphics();
        // Paint it black!
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, globalImage.getWidth(), globalImage.getHeight());
        for (TileModel[] tiles : scenario.getBoardModel().getMapModel()) {
            for (TileModel tile : tiles) {
                paintTile(g2, tile);
            }
        }
        g2.dispose();
    }

    @Override
    public void updateScenario(ScenarioModel scenario) {
        this.scenario = scenario;
        updateLayer();
    }

    /**
     * Paints the terrain of a single tile
     *
     * @param g2
     * @param tile
     */
    private void paintTile(Graphics2D g2, TileModel tile) {
        if (!tile.isPlayable()) {
            return;
        }
        //If I don't know anything about it
        if (tile.getKnowledgeCategory() == KnowledgeCategory.NONE) {
            return;
        }

        //Calculate tile position
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);

        // First paints the open terrain, any other terrain will be rendered upon it
        BufferedImage terrainImage = GraphicsModel.INSTANCE.getProfiledImageProvider(AresMiscTerrainGraphics.TERRAIN_MISCELANEOUS, profile).getImage(Feature.OPEN.getCoordinates());

        g2.drawImage(terrainImage, pos.x, pos.y, contentPane);

        Map<Terrain, Directions> m = tile.getTerrain();
        for (Map.Entry<Terrain, Directions> entry : m.entrySet()) {
            Terrain terrain = entry.getKey();
            Directions directions = entry.getValue();
            Point imageCoordinates = directions.getCoordinates();
            terrainImage = GraphicsModel.INSTANCE.getProfiledImageProvider(terrain, profile).getImage(imageCoordinates);
            // Paint terrain image
            g2.drawImage(terrainImage, pos.x, pos.y, contentPane);
        }
        // Paint features 
        for (Feature feature : tile.getTerrainFeatures()) {
            terrainImage = GraphicsModel.INSTANCE.getProfiledImageProvider(AresMiscTerrainGraphics.TERRAIN_MISCELANEOUS, profile).getImage(feature.getCoordinates());
            g2.drawImage(terrainImage, pos.x, pos.y, contentPane);
        }
        contentPane.repaint(pos.x, pos.y, terrainImage.getWidth(), terrainImage.getHeight());
    }
}
