package wegotoaw.platform.engine.command;

import wegotoaw.platform.scenario.board.Board;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.forces.Formation;
import wegotoaw.platform.scenario.forces.Unit;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public class Objective implements Comparable {

    private final Tile location;
    private final int priority;
    private boolean achieved = false;

    public Objective(wegotoaw.data.wrappers.scenario.Objective obj, Board board) {
        location = board.getTile(obj.getX(), obj.getY());
        priority = obj.getId();
    }

//    public Objective(Tile location, int priority) {
//        this.location = location;
//        this.priority = priority;
//    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public Tile getLocation() {
        return location;
    }

    public int getPriority() {
        return priority;
    }

    public int getVictoryPoints() {
        return location.getVictoryPoints();
    }

    public boolean isAchieved(Formation formation) {
        if (!location.isAlliedTerritory(formation.getForce())) return false;
        for (Unit unit : location.getSurfaceUnits()) {
            if (unit.getFormation().equals(formation)) return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Objective objective = (Objective) o;
        return priority - objective.priority;
    }

    @Override
    public String toString() {
        return location.toString();
    }
}
