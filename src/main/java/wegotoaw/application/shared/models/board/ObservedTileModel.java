package wegotoaw.application.shared.models.board;

import wegotoaw.application.shared.models.forces.UnitModel;
import wegotoaw.platform.engine.knowledge.KnowledgeCategory;
import wegotoaw.platform.scenario.board.Tile;
import wegotoaw.platform.scenario.board.UnitsStack;
import wegotoaw.platform.scenario.forces.SurfaceUnit;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public final class ObservedTileModel extends NonObservedTileModel {

    private final UnitsStack stack;

    public ObservedTileModel(Tile tile, KnowledgeCategory kLevel) {
        super(tile, kLevel);
        stack = tile.getUnitsStack();
    }

    @Override
    public UnitModel getTopUnit() {
        try {
            return stack.getPointOfInterest().getModel(kLevel);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public int getNumStackedUnits() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String getDescription() {
        return tile.toStringMultiline();
    }

    @Override
    public String getOwner() {
        return tile.getOwner().getName();
    }

    @Override
    public Collection<SurfaceUnit> getSurfaceUnits() {
        return stack.getSurfaceUnits();
    }

    @Override
    public boolean isAlliedTerritory(String force) {
        return getOwner().equals(force);

    }

    @Override
    public boolean hasEnemies(String force) {
        // If there are units, check if the first of the collection is an ally
        if (getSurfaceUnits().isEmpty()) {
            return false;
        } else {
//            return !getSurfaceUnits().iterator().next().getForce().getName().equals(force);
            return getOwner().equals(force);
        }
    }
}
