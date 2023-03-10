package wegotoaw.application.shared.gui.views;

import wegotoaw.application.shared.boundaries.viewers.TerrainInfoViewer;
import wegotoaw.application.shared.gui.ComponentFactory;
import wegotoaw.application.shared.gui.components.TerrainInfo;
import wegotoaw.application.shared.gui.profiles.GraphicProperties;
import wegotoaw.application.shared.gui.profiles.NonProfiledGraphicProperty;
import wegotoaw.application.shared.models.board.TileModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class TerrainInfoView extends AbstractView<JPanel> implements TerrainInfoViewer {

    private TerrainInfo terrainInfo;
    private JTextArea tileInfo;

    @Override
    public void updateTile(TileModel tileModel) {
        terrainInfo.updateTile(tileModel);
        if (tileModel != null)
            tileInfo.setText(tileModel.getDescription());
        else tileInfo.setText("");

    }

    @Override
    protected JPanel layout() {
        terrainInfo = new TerrainInfo();
        tileInfo = new JTextArea();
        tileInfo.setEditable(false);
        JPanel panel = ComponentFactory.panel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(ComponentFactory.DEFAULT_BORDER);
        panel.add(terrainInfo);
        panel.add(Box.createRigidArea(new Dimension(5, 5)));
        panel.add(tileInfo);

        return panel;
    }

    @Override
    public void clear() {
        tileInfo.setText("");
        terrainInfo.updateTile(null);
    }

    @Override
    public final void flush() {
        clear();
        terrainInfo.flush();
    }

    public void setPreferredSize(Dimension size) {
        super.setPreferredSize(size);
        int terrainInfoWidth = GraphicProperties.getProperty(NonProfiledGraphicProperty.TERRAIN_INFO_WIDTH);
        Dimension componentSize;
        componentSize = new Dimension(terrainInfoWidth, size.height);
        terrainInfo.setPreferredSize(componentSize);
        componentSize = new Dimension(size.width - terrainInfoWidth - 5, size.height);
        tileInfo.setPreferredSize(componentSize);
    }
}
