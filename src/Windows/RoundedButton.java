package Windows;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JButton that has rounded corners.
 * This class overrides the paintBorder method to make the button rounded.
 */
public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
    }

    /**
     * Overrides the default paintBorder method to draw a rounded rectangle border.
     * The color of the border is determined by the button's foreground color.
     * @param g The Graphics object used for painting.
     */
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }
}