package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.SelectionLayerViewer;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.application.shared.models.board.TileModel;
import wegotoaw.application.shared.models.forces.FormationModel;
import wegotoaw.application.shared.models.forces.UnitModel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Draws the movement arrows on a BufferedImage
 *
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class SelectionLayerView extends AbstractImageLayerView implements SelectionLayerViewer {

    private UnitModel selectedUnit;
    private FormationModel formation;

    @Override
    public String name() {
        return SelectionLayerViewer.NAME;
    }

    @Override
    public void updateLayer() {
        initialize();
        if (!isVisible()) return;
        if (selectedUnit == null) {
            return;
        }
        Graphics2D g2 = globalImage.createGraphics();
        for (UnitModel u : formation.getUnitModels()) {
            if (!u.equals(selectedUnit)) {
                paintCursor(g2, u.getLocation(), GraphicsModel.INSTANCE.getProfiledImageProvider(AresMiscTerrainGraphics.STEEL_CURSOR, profile).getImage(0, 0));
            }
        }
        paintCursor(g2, selectedUnit.getLocation(), GraphicsModel.INSTANCE.getProfiledImageProvider(AresMiscTerrainGraphics.BRASS_CURSOR, profile).getImage(0, 0));
        g2.dispose();
    }

    private void paintCursor(Graphics2D g2, TileModel tile, BufferedImage image) {
        Point pos = GraphicsModel.INSTANCE.tileToPixel(tile.getCoordinates(), profile);
        g2.drawImage(image, pos.x, pos.y, contentPane);
        contentPane.repaint(pos.x, pos.y, image.getWidth(), image.getHeight());
    }

    /**
     * Paints a brass cursor around the selected unit, and steel cursors around other units in the same formation
     *
     * @param unit
     * @param formation
     */
    @Override
    public void updateSelectedUnit(UnitModel unit, FormationModel formation) {
        this.selectedUnit = unit;
        this.formation = formation;
        updateLayer();
    }
}
