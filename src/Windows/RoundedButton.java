package Windows;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
    }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
}
