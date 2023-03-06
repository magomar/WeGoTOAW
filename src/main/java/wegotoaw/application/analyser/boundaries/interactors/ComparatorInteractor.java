package wegotoaw.application.analyser.boundaries.interactors;

import wegotoaw.application.analyser.boundaries.viewers.ComparatorViewer;
import wegotoaw.application.shared.boundaries.interactors.Interactor;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface ComparatorInteractor extends Interactor {

    ComparatorViewer getPathfinderComparatorView();
}
