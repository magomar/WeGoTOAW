package wegotoaw.application.shared.boundaries.interactors;

import wegotoaw.application.shared.boundaries.viewers.BoardViewer;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface BoardInteractor extends Interactor {

    BoardViewer getBoardView();

}
