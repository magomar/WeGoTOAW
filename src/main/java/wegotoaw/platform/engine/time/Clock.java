package wegotoaw.platform.engine.time;

import wegotoaw.platform.engine.RealTimeEngine;
import wegotoaw.platform.scenario.TurnLength;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class Clock {

    public static final Clock INSTANCE = new Clock();
    public static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static final SimpleDateFormat SINGLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private int MINUTES_PER_TICK;
    private int MINUTES_PER_TURN;
    private int TICKS_PER_TURN;
    private GregorianCalendar begins;
    private GregorianCalendar ends;
    private GregorianCalendar now;
    private int turn;
    private int finalTurn;
    private TurnLength turnLength;
    /**
     * Elapsed minutes since the beginning of the scenario
     */
    private int currentTime;
    private int tick;
    private RealTimeEngine engine;

    private Clock() {
    }

    public void initialize(wegotoaw.data.wrappers.scenario.Calendar calendar) {
        turnLength = TurnLength.valueOf(calendar.getTurnLength().name());
        MINUTES_PER_TICK = turnLength.getMinutesPerTick();
        MINUTES_PER_TURN = turnLength.getMinutesPerTurn();
        GregorianCalendar gcal = calendar.getStartDate().toGregorianCalendar();
        gcal.set(GregorianCalendar.HOUR_OF_DAY, 6);
        gcal.set(GregorianCalendar.MINUTE, 0);
        begins = (GregorianCalendar) gcal.clone();
        turn = calendar.getCurrentTurn();
//        gcal.add(GregorianCalendar.MINUTE, turn * turnLength.getMinutesPerTurn() - turnLength.getMinutesPerTick());
        gcal.add(GregorianCalendar.MINUTE, turn * turnLength.getMinutesPerTurn());
        now = (GregorianCalendar) gcal.clone();
        finalTurn = calendar.getFinalTurn();
        ends = (GregorianCalendar) begins.clone();
        ends.add(GregorianCalendar.MINUTE, finalTurn * turnLength.getMinutesPerTurn());
        TICKS_PER_TURN = MINUTES_PER_TURN / MINUTES_PER_TICK;
        tick = 0;
        currentTime = turn * MINUTES_PER_TURN;
    }

    public void tick() {
        SwingUtilities.invokeLater(new Tick());
    }

    public void setEngine(RealTimeEngine engine) {
        this.engine = engine;
    }

    public int getMINUTES_PER_TICK() {
        return MINUTES_PER_TICK;
    }

    public int getMINUTES_PER_TURN() {
        return MINUTES_PER_TURN;
    }

    public int getTICKS_PER_TURN() {
        return TICKS_PER_TURN;
    }

    public GregorianCalendar getBegins() {
        return begins;
    }

    public GregorianCalendar getEnds() {
        return ends;
    }

    public GregorianCalendar getNow() {
        return now;
    }

    public int getTurn() {
        return turn;
    }

    public int getFinalTurn() {
        return finalTurn;
    }

    public TurnLength getTurnLength() {
        return turnLength;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public int getTick() {
        return tick;
    }

    public RealTimeEngine getEngine() {
        return engine;
    }

    public String toStringNowAndEnds() {
        return FULL_DATE_FORMAT.format(now.getTime()) + " (Turn " + turn + ")\nEnds: "
                + FULL_DATE_FORMAT.format(ends.getTime()) + "(Turn " + finalTurn + ")";
    }

    public String toStringBeginsAndEnds() {
        return "from " +FULL_DATE_FORMAT.format(begins.getTime()) + " to "
                + FULL_DATE_FORMAT.format(ends.getTime())
                + " (Turn " + finalTurn + ")";
    }

    @Override
    public String toString() {
        return FULL_DATE_FORMAT.format(now.getTime());
    }

    private class Tick implements Runnable {

        @Override
        public void run() {
            now.add(GregorianCalendar.MINUTE, MINUTES_PER_TICK);
            currentTime += MINUTES_PER_TICK;
            tick++;
            Set<ClockEventType> eventTypes = EnumSet.of(ClockEventType.TICK);
            // Check new turn condition
            if (tick == TICKS_PER_TURN) {
                tick = 0;
                turn++;
                eventTypes.add(ClockEventType.TURN);
                // Check end of scenario
                if (turn == finalTurn) {
                    eventTypes.add(ClockEventType.FINISHED);
                }
            }
            // Check new day condition
            if (getNow().get(GregorianCalendar.HOUR_OF_DAY) == 6 && getNow().get(GregorianCalendar.MINUTE) == 0) {
                eventTypes.add(ClockEventType.DAY);
            }
            getEngine().update(new ClockEvent(eventTypes));
        }
    }

}
