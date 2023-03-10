package wegotoaw.application.shared.models.board;

import wegotoaw.data.wrappers.scenario.Place;
import wegotoaw.platform.model.RoleMediatedModel;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.board.Board;
import wegotoaw.platform.scenario.board.Tile;

import java.util.List;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class BoardModel extends RoleMediatedModel {

    private final Board board;
    private final TileModel[][] mapModel;

    public BoardModel(Board board, UserRole role) {
        super(role);
        this.board = board;
        Tile[][] tiles = board.getMap();
        mapModel = new TileModel[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                mapModel[i][j] = tiles[i][j].getModel(role);
            }
        }
    }

    public TileModel[][] getMapModel() {
        return mapModel;
    }

    /**
     * Gets the width of the board
     * @return                    the number of columns
     */
    public int getWidth() {
        return board.getWidth();
    }

    /**
     *  Gets the height of the board
     * @return the number of rows
     */
    public int getHeight() {
        return board.getHeight();
    }

    /**
     * Gets all the places of the board
     * @return
     */
    public List<Place> getPlaces() {
        return board.getPlaces();
    }
}
