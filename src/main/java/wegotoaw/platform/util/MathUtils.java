package wegotoaw.platform.util;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class MathUtils {

    private MathUtils() {
    }

    public static int setBounds(int value, int lowerBound, int upperBound) {
        return Math.max(Math.min(value, upperBound), lowerBound);
    }

    public static int setUpperBound(int value, int upperBound) {
        return Math.min(value, upperBound);
    }

    public static int setLowerBound(int value, int lowerBound) {
        return Math.max(value, lowerBound);
    }

    public static int addBounded(int value, int addend, int upperBound) {
        long result = ((long) value) + addend;
        if (result > upperBound) {
            return upperBound;
        } else {
            return (int) result;
        }
    }

    public static int subtractBounded(int value, int addend, int lowerBound) {
        long result = ((long) value) - addend;
        if (result < lowerBound) {
            return lowerBound;
        } else {
            return (int) result;
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
