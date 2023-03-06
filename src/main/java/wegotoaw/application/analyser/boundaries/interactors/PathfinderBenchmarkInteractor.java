package wegotoaw.application.analyser.boundaries.interactors;

import wegotoaw.application.analyser.boundaries.viewers.BenchmarkViewer;
import wegotoaw.application.shared.boundaries.interactors.Interactor;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface PathfinderBenchmarkInteractor extends Interactor {
    
    BenchmarkViewer getPathfinderBenchmarkView();
}
