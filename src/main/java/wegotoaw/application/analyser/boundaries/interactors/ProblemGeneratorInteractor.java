package wegotoaw.application.analyser.boundaries.interactors;

import wegotoaw.application.analyser.benchmark.PathfindingProblem;
import wegotoaw.application.analyser.boundaries.viewers.ProblemGeneratorViewer;

import java.util.List;
import java.util.Map;

/**
 * Author: Mario Gómez Martínez <magomar@gmail.com>
 */
public interface ProblemGeneratorInteractor {
    ProblemGeneratorViewer getProblemGeneratorView();

    void setProblems(Map<String, List<PathfindingProblem>> problems);
}
