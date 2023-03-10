package wegotoaw.platform.engine.command.operational.plans;

import wegotoaw.data.wrappers.scenario.Emphasis;
import wegotoaw.data.wrappers.scenario.SupportScope;
import wegotoaw.platform.engine.algorithms.pathfinding.Pathfinder;
import wegotoaw.platform.engine.command.Objective;
import wegotoaw.platform.engine.command.operational.Operation;
import wegotoaw.platform.scenario.forces.Formation;

import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public abstract class OperationalPlan {

    protected final OperationalStance stance;
    //    protected OperationType operationType;
//    protected OperationForm form;
    protected final Formation formation;
    protected final List<Objective> objectives;
    protected final SortedSet<Objective> goals;
    //    protected final Map<Unit, TacticalMission> missions;
    protected final Collection<Operation> operations;
    private Emphasis emphasis;
    private SupportScope supportScope;
    private final boolean achieved;

    public OperationalPlan(OperationalStance stance, Formation formation, List<Objective> objectives, Emphasis emphasis, SupportScope supportScope) {
        this.stance = stance;
        this.formation = formation;
        this.objectives = objectives;
        this.emphasis = emphasis;
        this.supportScope = supportScope;
        goals = new TreeSet<>();
        goals.addAll(objectives);
        operations = new TreeSet<>();
        achieved = false;
    }

    public abstract void plan(Pathfinder pathFinder);

    public void updateObjectives() {
        for (Objective objective : objectives) {
            if (objective.isAchieved(formation)) {
                if (!objective.isAchieved()) {
                    objective.setAchieved(true);
                    goals.remove(objective);
                }
            } else {
                if (objective.isAchieved()) {
                    objective.setAchieved(false);
                    goals.add(objective);
                }
            }
        }
    }

    public void setEmphasis(Emphasis emphasis) {
        this.emphasis = emphasis;
    }

    public void setSupportscope(SupportScope supportscope) {
        this.supportScope = supportscope;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public Formation getFormation() {
        return formation;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public SortedSet<Objective> getGoals() {
        return goals;
    }

    public Emphasis getEmphasis() {
        return emphasis;
    }

    public OperationalStance getStance() {
        return stance;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public SupportScope getSupportScope() {
        return supportScope;
    }

    public boolean hasGoals() {
        return !goals.isEmpty();
    }
}