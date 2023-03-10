package wegotoaw.application.analyser;

import wegotoaw.application.analyser.boundaries.viewers.PathfinderToolsViewer;
import wegotoaw.application.analyser.controllers.PathfinderToolsController;
import wegotoaw.application.analyser.views.BenchmarkView;
import wegotoaw.application.analyser.views.ComparatorView;
import wegotoaw.application.player.AresPlayerGUI;
import wegotoaw.application.shared.boundaries.viewers.MenuBarViewer;
import wegotoaw.application.shared.boundaries.viewers.PanelMenuViewer;
import wegotoaw.application.shared.boundaries.viewers.ToolBarViewer;
import wegotoaw.application.shared.gui.ComponentFactory;
import wegotoaw.application.shared.gui.WindowUtil;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.application.shared.gui.views.AbstractView;
import wegotoaw.application.shared.gui.views.MainMenuView;
import wegotoaw.application.shared.gui.views.MenuBarView;
import wegotoaw.application.shared.gui.views.ToolBarView;
import wegotoaw.platform.scenario.board.Terrain;
import net.sf.tinylaf.Theme;
import net.sf.tinylaf.ThemeDescription;
import net.sf.tinylaf.TinyLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mario Gómez Martínez <magomar@gmail.com>
 */
public class PathfinderToolsGUI extends AbstractView<JFrame> implements PathfinderToolsViewer {

    private JPanel cards;
    private MainMenuView mainMenuV;
    private MenuBarView menuV;
    private ToolBarView toolBarV;
    private ComparatorView comparatorV;
    private BenchmarkView benchmarkV;

    @Override
    protected JFrame layout() {
        GraphicsModel.INSTANCE.addProfiledImageProviders(Terrain.values());
        GraphicsModel.INSTANCE.addProfiledImageProviders(AresMiscTerrainGraphics.values());

        mainMenuV = new MainMenuView();
        menuV = new MenuBarView();
        toolBarV = new ToolBarView();
        comparatorV = new ComparatorView();
        benchmarkV = new BenchmarkView();

        JFrame mainFrame = ComponentFactory.frame("Ares Pathfinder Analyser", menuV.getContentPane(), toolBarV.getContentPane());
        // These dimensions are necessary when the frame is not fullscreen
        Dimension maxSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
        Dimension defaultSize = new Dimension(1440, 900);
        Dimension minSize = new Dimension(800, 600);
        Dimension minimunSize = new Dimension(
                (maxSize.width < minSize.width ? maxSize.width : minSize.width),
                (maxSize.height < minSize.height ? maxSize.height : minSize.height));
        Dimension preferredSize = new Dimension(
                (maxSize.width < defaultSize.width ? maxSize.width : defaultSize.width),
                (maxSize.height < defaultSize.height ? maxSize.height : defaultSize.height));
        mainFrame.setMinimumSize(minimunSize);
        mainFrame.setPreferredSize(preferredSize);
        mainFrame.setMaximumSize(maxSize);
        mainFrame.setSize(preferredSize);
//        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        mainFrame.setUndecorated(true);

        comparatorV.setPreferredSize(preferredSize);

        cards = new JPanel(new CardLayout());
        cards.add(mainMenuV.getContentPane(), PathfinderToolsViewer.MAIN_MENU_PERSPECTIVE);
        cards.add(comparatorV.getContentPane(), PathfinderToolsViewer.COMPARATOR_PERSPECTIVE);
        cards.add(benchmarkV.getContentPane(), PathfinderToolsViewer.BENCHMARK_PERSPECTIVE);
        mainFrame.add(cards);
//        switchPerspective(PathfinderToolsViewer.MAIN_MENU_PERSPECTIVE);
        switchPerspective(PathfinderToolsViewer.COMPARATOR_PERSPECTIVE);
        return mainFrame;
    }

    @Override
    public void switchPerspective(String perspective) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, perspective);
        switch (perspective) {
            case PathfinderToolsViewer.MAIN_MENU_PERSPECTIVE:
                menuV.setVisible(false);
                toolBarV.setVisible(false);
                break;
            case PathfinderToolsViewer.COMPARATOR_PERSPECTIVE:
                menuV.setVisible(true);
                toolBarV.setVisible(true);
                break;
            case PathfinderToolsViewer.BENCHMARK_PERSPECTIVE:
                menuV.setVisible(true);
                toolBarV.setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {

        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    LookAndFeelThemes.loadDarkTheme();
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    LookAndFeelThemes.finalizeDarkTheme();
//                    break;
//                }
//            }
            UIManager.setLookAndFeel("net.sf.tinylaf.TinyLookAndFeel");
            ThemeDescription[] themes = Theme.getAvailableThemes();
            for (ThemeDescription theme: themes) {
                if ("DarkOlive".equals(theme.getName())) Theme.loadTheme(theme);
            }
            UIManager.setLookAndFeel(new TinyLookAndFeel());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AresPlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PathfinderToolsGUI mainView = new PathfinderToolsGUI();
                SwingUtilities.updateComponentTreeUI(mainView.contentPane);
                new PathfinderToolsController(mainView);
                WindowUtil.centerAndShow(mainView.contentPane);
            }
        });
    }

    @Override
    public ToolBarViewer getToolBarView() {
        return toolBarV;
    }

    @Override
    public MenuBarViewer getMenuView() {
        return menuV;
    }

    @Override
    public PanelMenuViewer getMainMenuView() {
        return mainMenuV;
    }

    @Override
    public ComparatorView getComparatorView() {
        return comparatorV;
    }
    
    @Override
    public BenchmarkView getBenchmarkView() {
        return benchmarkV;
    }
}
