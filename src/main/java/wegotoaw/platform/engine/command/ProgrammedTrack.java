package wegotoaw.platform.engine.command;

import wegotoaw.platform.scenario.board.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class ProgrammedTrack {

    private final List<Objective> objectives;

    public ProgrammedTrack(wegotoaw.data.wrappers.scenario.Track track, Board board) {
        objectives = new ArrayList<>();
        for (wegotoaw.data.wrappers.scenario.Objective obj : track.getObjective()) {
            objectives.add(new Objective(obj, board));
        }
    }

    public List<Objective> getObjectives() {
        return objectives;
    }
}
