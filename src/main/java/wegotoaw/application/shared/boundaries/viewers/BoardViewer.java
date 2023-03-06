package wegotoaw.application.shared.boundaries.viewers;

import wegotoaw.application.shared.boundaries.viewers.layerviewers.LayeredImageViewer;

import java.awt.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface BoardViewer extends LayeredImageViewer {

    public void centerViewOn(Point location);

    public void setViewPosition(Point position);
}
