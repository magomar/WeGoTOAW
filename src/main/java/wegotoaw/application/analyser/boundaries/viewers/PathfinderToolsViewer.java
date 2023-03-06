package wegotoaw.application.analyser.boundaries.viewers;

import wegotoaw.application.analyser.views.BenchmarkView;
import wegotoaw.application.analyser.views.ComparatorView;
import wegotoaw.application.shared.boundaries.viewers.MenuBarViewer;
import wegotoaw.application.shared.boundaries.viewers.PanelMenuViewer;
import wegotoaw.application.shared.boundaries.viewers.ToolBarViewer;
import wegotoaw.application.shared.gui.views.View;

import javax.swing.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public interface PathfinderToolsViewer extends View<JFrame> {
    // Perspectives
    static final String MAIN_MENU_PERSPECTIVE = "Main";
    static final String COMPARATOR_PERSPECTIVE = "Comparator";
    static final String BENCHMARK_PERSPECTIVE = "Benchmark";


    void switchPerspective(String perspective);

    ComparatorView getComparatorView();
    
    BenchmarkView getBenchmarkView();

    ToolBarViewer getToolBarView();

    MenuBarViewer getMenuView();

    PanelMenuViewer getMainMenuView();
}
