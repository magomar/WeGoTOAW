package wegotoaw.application.shared.gui.views.layerviews;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.ImageLayerViewer;
import wegotoaw.application.shared.boundaries.viewers.layerviewers.LayeredImageViewer;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.views.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public abstract class AbstractLayeredImageView extends AbstractView<JScrollPane> implements LayeredImageViewer {

    protected int profile;
    protected JLayeredPane layeredPane;
    protected Map<String, ImageLayerViewer> layerViews;
    protected List<ImageLayerViewer> sortedLayerViews;

    @Override
    public LayeredImageViewer addLayerView(ImageLayerViewer imageLayerView) {
        if (!imageLayerView.isSharingGlobalImage()) {
            layeredPane.add(imageLayerView.getContentPane(), Integer.valueOf(layeredPane.getComponentCount()));
        }
        layerViews.put(imageLayerView.name(), imageLayerView);
        sortedLayerViews.add(imageLayerView);
        return this;
    }

    @Override
    protected JScrollPane layout() {
        layerViews = new HashMap<>();
        sortedLayerViews = new ArrayList<>();
        //Create layered pane to hold all the layers
        layeredPane = new JLayeredPane();
        layeredPane.setOpaque(true);
        layeredPane.setBackground(Color.BLACK);
        // Create and set up scroll pane as the content pane
        JScrollPane scrollPane = new JScrollPane(layeredPane);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.setVisible(true);
        scrollPane.setOpaque(true);
        scrollPane.setAutoscrolls(true);
        return scrollPane;
    }

    @Override
    public void setProfile(int profile) {
        this.profile = profile;
        Dimension imageSize = new Dimension(GraphicsModel.INSTANCE.getBoardWidth(profile), GraphicsModel.INSTANCE.getBoardHeight(profile));
        layeredPane.setPreferredSize(imageSize);
        layeredPane.setSize(imageSize);
        // Set the profiles and initialize layers in strict "depth" order (to avoid problems with image sharing layers)
        for (ImageLayerViewer layerView : sortedLayerViews) {
            layerView.setProfile(profile);
            layerView.initialize();
        }
        layeredPane.revalidate(); // in theory this would make viewport aware of the change in its client (the content, that is the layered pane)
        contentPane.getVerticalScrollBar().setUnitIncrement(imageSize.height / GraphicsModel.INSTANCE.getBoardRows());
        contentPane.getHorizontalScrollBar().setUnitIncrement(imageSize.width / GraphicsModel.INSTANCE.getBoardColumns());
        Rectangle viewRectangle = contentPane.getViewport().getViewRect();
        int visibleImageWidth = Math.min(viewRectangle.width, GraphicsModel.INSTANCE.getBoardWidth(profile));
        int visibleImageHeight = Math.min(viewRectangle.height, GraphicsModel.INSTANCE.getBoardHeight(profile));
        System.out.println(" *** Change Profile *** ");
        System.out.println("Image Size = " + GraphicsModel.INSTANCE.getBoardWidth(profile) + ", " + GraphicsModel.INSTANCE.getBoardHeight(profile) + " (Prof. " + profile + ")");
        System.out.println("View Point = " + viewRectangle.x + ", " + viewRectangle.y);
        System.out.println("View Rect = " + viewRectangle.width + ", " + viewRectangle.height);
        System.out.println("Visible image = " + (visibleImageWidth) + ", " + (visibleImageHeight));
        System.out.println(" ***************** ");
    }

    @Override
    public int getProfile() {
        return profile;
    }

    @Override
    public void flush() {
        for (ImageLayerViewer layerView : layerViews.values()) {
            if (!layerView.hasParentLayer())
                layerView.flush();
        }
    }

    @Override
    public ImageLayerViewer getLayerView(String layerViewName) {
        return layerViews.get(layerViewName);
    }

    @Override
    public void setLayerVisible(String layerName, boolean visible) {
        layerViews.get(layerName).setVisible(visible);
    }

    @Override
    public boolean isLayerVisible(String layerName) {
        return layerViews.get(layerName).isVisible();
    }

    @Override
    public void switchLayerVisible(String layerName) {
        ImageLayerViewer layer = layerViews.get(layerName);
        layer.switchVisible();
        layer.updateLayer();
        if (layer.isSharingGlobalImage())
            for (ImageLayerViewer layerView : sortedLayerViews) {
                if (layer.equals(layerView.getParentLayer())) {
                    layerView.updateLayer();
                    break;
                }
            }
    }

    @Override
    public void addMouseListener(MouseListener listener) {
        contentPane.getViewport().getView().addMouseListener(listener);
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener listener) {
        contentPane.getViewport().getView().addMouseMotionListener(listener);
    }
}
