package wegotoaw.application.player.controllers;

import wegotoaw.application.shared.commands.ActionGroup;
import wegotoaw.application.shared.commands.CommandAction;
import wegotoaw.application.shared.commands.CommandGroup;
import wegotoaw.application.shared.boundaries.interactors.EngineInteractor;
import wegotoaw.application.shared.commands.AresCommandGroup;
import wegotoaw.application.shared.commands.EngineCommands;
import wegotoaw.application.shared.controllers.ActionController;
import wegotoaw.application.shared.gui.views.MessagesHandler;
import wegotoaw.platform.engine.RealTimeEngine;
import wegotoaw.platform.engine.time.ClockEvent;
import wegotoaw.platform.engine.time.ClockEventType;
import wegotoaw.platform.scenario.Scenario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 * @author Heine <heisncfr@inf.upv.es>
 */
public final class RealTimeEngineController implements ActionController, PropertyChangeListener {

    public static final String RUNNING = "Scenario";
    private static final Logger LOG = Logger.getLogger(RealTimeEngineController.class.getName());
    // Entities (bussines logic), they interact with the model providers and provide models to the views
    private final RealTimeEngine engine;
    private final EngineInteractor interactor;
    private final Action pause = new CommandAction(EngineCommands.ENGINE_PAUSE, new PauseActionListener(), false);
    private final Action turn = new CommandAction(EngineCommands.ENGINE_NEXT_TURN, new NextTurnActionListener());
    private final Action step = new CommandAction(EngineCommands.ENGINE_NEXT_STEP, new NextStepActionListener());
    private final ActionGroup actions;

    public RealTimeEngineController(EngineInteractor interactor) {
        this.interactor = interactor;
        // create action groups
        Action[] engineActions = {pause, turn, step};
        CommandGroup group = AresCommandGroup.ENGINE;
        actions = new ActionGroup(group.getName(), group.getText(), group.getMnemonic(), engineActions);
        //Add change listeners to entities
        engine = new RealTimeEngine();
        engine.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (RealTimeEngine.CLOCK_EVENT_PROPERTY.equals(evt.getPropertyName())) {
            ClockEvent clockEvent = (ClockEvent) evt.getNewValue();
            if (clockEvent.getEventTypes().contains(ClockEventType.TURN)) {
                pause.setEnabled(false);
                turn.setEnabled(true);
                step.setEnabled(true);
            }
        }
    }

    @Override
    public ActionGroup getActionGroup() {
        return actions;
    }

    private class PauseActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.ENGINE, e.toString());
            pause.setEnabled(false);
            turn.setEnabled(true);
            step.setEnabled(true);
            interactor.setRunning(false);
            engine.pause();
        }
    }

    private class NextTurnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.ENGINE, e.toString());
            pause.setEnabled(true);
            turn.setEnabled(false);
            step.setEnabled(false);
            interactor.setRunning(true);
            engine.resume();
        }
    }

    private class NextStepActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.log(MessagesHandler.MessageLevel.ENGINE, e.toString());
            interactor.setRunning(true);
            engine.step();
            interactor.setRunning(false);
        }
    }

    public RealTimeEngine getEngine() {
        return engine;
    }

    public void setScenario(Scenario scenario) {
        engine.setScenario(scenario);
        engine.activate();
    }
}
