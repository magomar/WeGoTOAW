package wegotoaw.application.shared.controllers;

import wegotoaw.application.shared.boundaries.interactors.ScenarioInteractor;
import wegotoaw.application.shared.commands.*;
import wegotoaw.application.shared.gui.components.StartScenarioPane;
import wegotoaw.application.shared.gui.views.MessagesHandler;
import wegotoaw.platform.io.AresFileType;
import wegotoaw.platform.io.FileIO;
import wegotoaw.platform.io.ResourcePath;
import wegotoaw.platform.model.UserRole;
import wegotoaw.platform.scenario.Scenario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 * @author Heine <heisncfr@inf.upv.es>
 */
public final class ScenarioController implements ActionController {

    private static final Logger LOG = Logger.getLogger(ScenarioController.class.getName());
    /**
     * Action to start a new scenario
     */
    private final Action open = new CommandAction(FileCommands.GAME_NEW, new OpenScenarioActionListener());
    /**
     * Action to load a saved scenario
     */
    private final Action load = new CommandAction(FileCommands.GAME_LOAD, new LoadScenarioActionListener());
    /**
     * Action to close the current scenario
     */
    private final Action close = new CommandAction(FileCommands.GAME_CLOSE, new CloseScenarioActionListener(), false);
    /**
     * Action to exit the system
     */
    private final Action exit = new CommandAction(FileCommands.EXIT, new ExitActionListener());
    /**
     * Action to configure settings and preferences
     */
    private final Action settings = new CommandAction(FileCommands.SETTINGS, new SettingsActionListener());
    /**
     * Provides
     */
    private final ScenarioInteractor interactor;
    private final ActionGroup actions;
    /**
     * if true, then the scenario models will depend on selected user role
     */
    private final boolean roleBasedModels;


    public ScenarioController(ScenarioInteractor interactor, boolean roleBasedModels) {
        this.interactor = interactor;
        this.roleBasedModels = roleBasedModels;
        // create action groups
        close.setEnabled(false);
        Action[] fileActions = new Action[]{open, load, close, settings, exit};
        CommandGroup group = AresCommandGroup.FILE;
        actions = new ActionGroup(group.getName(), group.getText(), group.getMnemonic(), fileActions);
    }

    @Override
    public ActionGroup getActionGroup() {
        return actions;
    }

    private class OpenScenarioActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.GAME_SYSTEM, e.toString());
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(ResourcePath.SCENARIOS.getFolderPath().toFile());
            fc.setFileFilter(AresFileType.SCENARIO.getFileTypeFilter());
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                Container container = interactor.getGUIContainer();
                container.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                File file = fc.getSelectedFile();
                // Load scenario and equipment files
                Scenario scenario = FileIO.loadScenario(file);
                container.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                UserRole userRole;
                if (roleBasedModels) {
                    StartScenarioPane startScenarioPane = new StartScenarioPane(scenario, file);
                    userRole = startScenarioPane.showOptionDialog(container);
                    if (userRole == null) {
                        return;
                    }
                } else {
                    userRole = UserRole.GOD;
                }
                close.setEnabled(true);
//                Container container = boardView.getContentPane();
                container.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                // tell listeners new scenario has been loaded
                interactor.newScenario(scenario, userRole);
            }
        }
    }

    private class CloseScenarioActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.GAME_SYSTEM, e.toString());
            interactor.forgetScenario();
            close.setEnabled(false);
        }
    }

    private class ExitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.GAME_SYSTEM, e.toString());
            System.exit(0);
        }
    }

    // TODO load saved games
    private class LoadScenarioActionListener implements ActionListener {

        public LoadScenarioActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    // TODO create settings window
    private class SettingsActionListener implements ActionListener {

        public SettingsActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
