package wegotoaw.application.player.boundaries.interactors;

import wegotoaw.application.player.boundaries.viewers.PlayerViewer;
import wegotoaw.application.shared.boundaries.interactors.BoardInfoInteractor;
import wegotoaw.application.shared.boundaries.interactors.BoardInteractor;
import wegotoaw.application.shared.boundaries.interactors.OOBInteractor;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface PlayerBoardInteractor extends BoardInteractor, BoardInfoInteractor, OOBInteractor, MiniMapInteractor {

    PlayerViewer getPlayerView();

}
