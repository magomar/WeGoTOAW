package wegotoaw.application.player;

import wegotoaw.application.player.boundaries.viewers.PlayerViewer;
import wegotoaw.application.player.controllers.WeGoPlayerController;
import wegotoaw.application.player.views.PlayerBoardView;
import wegotoaw.application.shared.boundaries.viewers.*;
import wegotoaw.application.shared.gui.ComponentFactory;
import wegotoaw.application.shared.gui.WindowUtil;
import wegotoaw.application.shared.gui.profiles.GraphicsModel;
import wegotoaw.application.shared.gui.providers.AresMiscTerrainGraphics;
import wegotoaw.application.shared.gui.providers.TerrainInfoGraphics;
import wegotoaw.application.shared.gui.views.*;
import wegotoaw.platform.scenario.board.Terrain;
import wegotoaw.platform.scenario.forces.UnitsColor;
import net.sf.tinylaf.Theme;
import net.sf.tinylaf.ThemeDescription;
import net.sf.tinylaf.TinyLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public final class AresPlayerGUI extends AbstractView<JFrame> implements PlayerViewer {

    private static final int INFO_VIEW_WIDTH = 250;
    private static final int OOB_VIEW_WIDTH = 200;
    private static final int MINIMAP_VIEW_HEIGHT = 150;
    private static final int MESSAGES_WIEW_HEIGHT = 150;
    private JPanel cards;
    private MainMenuView mainMenuView;
    private MenuBarView menuView;
    private InfoView infoView;
    private OOBView oobView;
    private PlayerBoardView boardView;
    private MessagesView messagesView;
    private ToolBarView toolBarView;
    private MiniMapView miniMapView;

    @Override
    protected JFrame layout() {
        GraphicsModel.INSTANCE.addProfiledImageProviders(Terrain.values());
        GraphicsModel.INSTANCE.addProfiledImageProviders(AresMiscTerrainGraphics.values());
        GraphicsModel.INSTANCE.addProfiledImageProviders(UnitsColor.values());
        GraphicsModel.INSTANCE.addNonProfiledImageProviders(TerrainInfoGraphics.values());

        mainMenuView = new MainMenuView();
        menuView = new MenuBarView();
        infoView = new InfoView();
        oobView = new OOBView();
        boardView = new PlayerBoardView();
        messagesView = new MessagesView();
        toolBarView = new ToolBarView();
        miniMapView = new MiniMapView();
        JFrame mainFrame = ComponentFactory.frame("Ares Player", menuView.getContentPane(), toolBarView.getContentPane());
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
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setUndecorated(true);

        boardView.setPreferredSize(getBoardPaneDimension(preferredSize));
        infoView.setPreferredSize(getInfoPaneDimension(preferredSize));
        oobView.setPreferredSize(getOOBPaneDimension(preferredSize));
        miniMapView.setPreferredSize(getMiniMapPaneDimension());
        messagesView.setPreferredSize(getMessagesPaneDimension(preferredSize));

        JSplitPane splitVert = ComponentFactory.verticalSplitPane(true, boardView.getContentPane(), messagesView.getContentPane(), 1);
        JSplitPane splitVert2 = ComponentFactory.verticalSplitPane(true, miniMapView.getContentPane(), oobView.getContentPane(), 0);
        JSplitPane splitHoriz = ComponentFactory.horizontalSplitPane(true, infoView.getContentPane(), splitVert, 0);
        splitHoriz.setEnabled(false);
        JSplitPane splitHoriz2 = ComponentFactory.horizontalSplitPane(true, splitHoriz, splitVert2, 1);


        cards = new JPanel(new CardLayout());
        cards.add(mainMenuView.getContentPane(), PlayerViewer.MAIN_MENU_PERSPECTIVE);
        cards.add(splitHoriz2, PlayerViewer.PLAYER_PERSPECTIVE);
        mainFrame.add(cards);
//        switchPerspective(PlayerViewer.MAIN_MENU_PERSPECTIVE);  // Perspective set from the controller
        return mainFrame;
    }

    @Override
    public void switchPerspective(String perspective) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, perspective);
        switch (perspective) {
            case PlayerViewer.MAIN_MENU_PERSPECTIVE:
                contentPane.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
                menuView.setVisible(false);
                toolBarView.setVisible(false);
                break;
            case PlayerViewer.PLAYER_PERSPECTIVE:
                contentPane.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
                menuView.setVisible(true);
                toolBarView.setVisible(true);
                break;
        }
    }

    private Dimension getMiniMapPaneDimension() {
        return new Dimension(OOB_VIEW_WIDTH, MINIMAP_VIEW_HEIGHT);
    }

    private Dimension getOOBPaneDimension(Dimension containerSize) {
        return new Dimension(OOB_VIEW_WIDTH, containerSize.height - MINIMAP_VIEW_HEIGHT - ComponentFactory.SPLIT_DIVIDER_SIZE);
    }

    private Dimension getInfoPaneDimension(Dimension containerSize) {
        return new Dimension(INFO_VIEW_WIDTH, containerSize.height);
    }

    private Dimension getBoardPaneDimension(Dimension containerSize) {
        return new Dimension(containerSize.width - INFO_VIEW_WIDTH - OOB_VIEW_WIDTH - ComponentFactory.SPLIT_DIVIDER_SIZE,
                containerSize.height - MESSAGES_WIEW_HEIGHT - ComponentFactory.SPLIT_DIVIDER_SIZE);
    }

    private Dimension getMessagesPaneDimension(Dimension containerSize) {
        return new Dimension(containerSize.width - INFO_VIEW_WIDTH - ComponentFactory.SPLIT_DIVIDER_SIZE, MESSAGES_WIEW_HEIGHT);
    }

    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(false);
//        JDialog.setDefaultLookAndFeelDecorated(true);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
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
                AresPlayerGUI mainView = new AresPlayerGUI();
                new WeGoPlayerController(mainView);
                WindowUtil.centerAndShow(mainView.contentPane);

            }
        });
    }

    @Override
    public BoardViewer getBoardView() {
        return boardView;
    }

    @Override
    public InfoViewer getInfoView() {
        return infoView;
    }

    @Override
    public ToolBarViewer getToolBarView() {
        return toolBarView;
    }

    @Override
    public MenuBarViewer getMenuView() {
        return menuView;
    }

    @Override
    public MessagesViewer getMessagesView() {
        return messagesView;
    }

    @Override
    public OOBViewer getOobView() {
        return oobView;
    }

    @Override
    public BoardViewer getMiniMapView() {
        return miniMapView;
    }

    @Override
    public PanelMenuViewer getMainMenuView() {
        return mainMenuView;
    }
}
