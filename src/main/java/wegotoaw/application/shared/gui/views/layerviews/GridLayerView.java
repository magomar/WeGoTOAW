package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.GridLayerViewer;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.application.shared.models.board.TileModel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Grid image layer
 *
 * @author Heine <heisncfr@inf.upv.es>
 */
public class GridLayerView extends AbstractImageLayerView implements GridLayerViewer {

    private ScenarioModel scenario;

    @Override
    public String name() {
        return GridLayerViewer.NAME;
    }

    @Override
    public void updateLayer() {
        initialize();
        if (!isVisible()) return;
        if (scenario == null) {
            return;
        }
        int width = GraphicsModel.INSTANCE.getBoardColumns();
        int height = GraphicsModel.INSTANCE.getBoardRows();
        Graphics2D g2 = globalImage.createGraphics();
        BufferedImage gridImage = GraphicsModel.INSTANCE.getProfiledImageProvider(AresMiscTerrainGraphics.GRID, profile).getImage(0, 0);
        TileModel[][] tiles = scenario.getBoardModel().getMapModel();
        for (int i = 0; i < width; i++) {
            TileModel[] tileColumn = tiles[i];
            for (int j = 0; j < height; j++) {
                TileModel tile = tileColumn[j];
                if (tile.isPlayable()) {
                    Point pos = GraphicsModel.INSTANCE.tileToPixel(i, j, profile);
                    g2.drawImage(gridImage, pos.x, pos.y, contentPane);
                    contentPane.repaint(pos.x, pos.y, gridImage.getWidth(), gridImage.getHeight());
                }
            }
        }
        g2.dispose();
    }

    @Override
    public void updateScenario(ScenarioModel scenario) {
        this.scenario = scenario;
        updateLayer();
    }
}
