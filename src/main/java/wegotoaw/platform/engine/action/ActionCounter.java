package wegotoaw.platform.engine.action;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class ActionCounter {

    private static int counter;

    private ActionCounter() {
        counter = 0;
    }

    public static int count() {
        return ++counter;
    }
}
