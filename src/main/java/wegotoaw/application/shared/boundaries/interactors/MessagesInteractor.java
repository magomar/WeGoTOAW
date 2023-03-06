package wegotoaw.application.shared.boundaries.interactors;

import wegotoaw.application.shared.boundaries.viewers.MessagesViewer;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface MessagesInteractor extends Interactor {

    MessagesViewer getMessagesView();
}
