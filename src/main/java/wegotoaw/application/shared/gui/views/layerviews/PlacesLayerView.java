package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.PlacesLayerViewer;
import wegotoaw.application.shared.gui.decorators.ImageDecorators;
import wegotoaw.application.shared.gui.profiles.GraphicProperties;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.profiles.ProfiledGraphicProperty;
import wegotoaw.application.shared.models.ScenarioModel;
import wegotoaw.data.wrappers.scenario.Place;

import java.awt.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class PlacesLayerView extends AbstractImageLayerView implements PlacesLayerViewer {

    private ScenarioModel scenario;

    @Override
    public String name() {
        return PlacesLayerViewer.NAME;
    }

    @Override
    public void updateLayer() {
        initialize();
        if (!isVisible()) return;
        if (scenario == null) {
            return;
        }
        Graphics2D g2 = globalImage.createGraphics();
        int tileWidth = GraphicProperties.getProperty(ProfiledGraphicProperty.TILE_WIDTH, profile);
        ImageDecorators imageDec = GraphicsModel.INSTANCE.getImageDecorators(profile);
        Font placeFont = imageDec.getPlaceFont();
        g2.setFont(placeFont);
        g2.setColor(Color.DARK_GRAY);
        FontMetrics fm = g2.getFontMetrics(placeFont);
        for (Place place : scenario.getBoardModel().getPlaces()) {
            Point pos = GraphicsModel.INSTANCE.tileToPixel(place.getX(), place.getY(), profile);
            String label = place.getName();
            int labelWidth = fm.stringWidth(label);
            int x = pos.x - (labelWidth - tileWidth) / 2;
            if (x + labelWidth > globalImage.getWidth()) {
                x = globalImage.getWidth() - labelWidth;
            }
            int y = pos.y;
            if (y - placeFont.getSize() < 0) {
                y = placeFont.getSize();
            }
            g2.drawString(label, x, y);
        }
        g2.dispose();
    }

    @Override
    public void updateScenario(ScenarioModel scenario) {
        this.scenario = scenario;
        updateLayer();
    }
}
