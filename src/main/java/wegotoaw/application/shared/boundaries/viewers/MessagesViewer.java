package wegotoaw.application.shared.boundaries.viewers;

import wegotoaw.application.shared.gui.views.MessagesHandler;
import wegotoaw.application.shared.gui.views.View;
import wegotoaw.platform.engine.messages.EngineMessage;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Mario Gómez Martínez <margomez at dsic.upv.es>
 */
public interface MessagesViewer extends View<JPanel> {

    public void addMessage(EngineMessage message);

    public void append(String str);

    public void clear();

    public void setLogCheckBoxes(ActionListener logCheckBoxListener);

    public MessagesHandler getHandler();
}
