package wegotoaw.application.shared.gui;

import java.awt.*;

/**
 * @author Mario Gomez <margomez at dsic.upv.es>
 */
public class WindowUtil {
    private WindowUtil() {
    }
//    public static JFrame showFrame(JFrame frame) {
//        frame.pack();
//        centerFrame(frame);
//        frame.setVisible(true);
//        return frame;
//    }
//
//    public static JFrame centerFrame(JFrame frame) {
//        Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
//        Dimension frameSize = frame.getSize();
//        if (frameSize.height > screenSize.height) {
//            frameSize.height = screenSize.height;
//        }
//        if (frameSize.width > screenSize.width) {
//            frameSize.width = screenSize.width;
//        }
//        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
//        return frame;
//    }

    /**
     * Centers the passed window (dialog or frame) on the screen and makes it visible. This is typically used to display
     * the main window for an application.
     */
    public static void centerAndShow(Window window) {
        center(window);
        window.setVisible(true);
    }

    /**
     * Centers the passed window (dialog or frame) within the second window and makes it visible. This is typically used
     * to display a dialog. <p> The second window may be null, in which case the first is centered within the screen.
     * This is a convenience for ownerless dialogs.
     */
    public static void centerAndShow(Window window, Window inWindow) {
        center(window, inWindow);
        window.setVisible(true);
    }

    /**
     * Updates the passed window's position to center it with respect to the screen. May be called before or after the
     * window is made visible (but remember to call
     * <code>pack()</code> first!). <p> Deals with multi-monitor setups via the following hack: if the screen size
     * reported by the default toolkit has a width:height ration > 2:1, then the width is divided by 2. This works well
     * for 1, 2, or 3 screen desktops: the window will appear in the left screen of a 2-screen setup, in the middle of a
     * 3-screen setup. <p> If the window is larger than the screen size, it's positioned at the top-left corner.
     * Hopefully the user will be able to shrink it.
     */
    public static void center(Window window) {
        //        window.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        if (width > height * 2) {
            width /= 2;
        }
        center(window, new Rectangle(0, 0, width, height), false);
    }

    /**
     * Updates the first window's position to center it with respect to the second window. If the first window is larger
     * than the second, it will be offset to the top/left as needed, but not exceeding the bounds of the screen. <p> The
     * second window may be null, in which case the first is centered within the screen. This is a convenience for
     * ownerless dialogs.
     */
    public static void center(Window window, Window inWindow) {
        if (inWindow == null) {
            center(window);
        } else {
            center(window, inWindow.getBounds(), true);
        }
    }

    /**
     * Centers a window within a specified space. If the window is larger than the width/height of the space, it may
     * optionally overflow: its X and Y will be less than those passed. However, it is not allowed to overflow to
     * negative coordinates.
     */
    private static void center(Window window, Rectangle bounds, boolean allowOverflow) {
        Dimension windowSize = window.getSize();
        int offsetX = (bounds.width - windowSize.width) / 2;
        if ((offsetX < 0) && !allowOverflow) {
            offsetX = 0;
        }
        int x = bounds.x + offsetX;
        if (x < 0) {
            x = 0;
        }
        int offsetY = (bounds.height - windowSize.height) / 2;
        if ((offsetY < 0) && !allowOverflow) {
            offsetY = 0;
        }
        int y = bounds.y + offsetY;
        if (y < 0) {
            y = 0;
        }
        window.setLocation(x, y);
    }
}
