package wegotoaw.application.player.boundaries.interactors;

import wegotoaw.application.shared.boundaries.interactors.BoardInteractor;
import wegotoaw.application.shared.boundaries.viewers.BoardViewer;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public interface MiniMapInteractor extends BoardInteractor {

    BoardViewer getMiniMapView();

}
