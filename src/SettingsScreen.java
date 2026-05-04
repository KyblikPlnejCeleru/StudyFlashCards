import javax.swing.*;
import java.awt.*;

public class SettingsScreen {
    private JFrame frame;

    public SettingsScreen() {
        this.frame = new JFrame("Settings");
    }

    public void showApp() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 1, 6, 7));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel themeLabel = new JLabel("theme");
        JRadioButton lightButton = new JRadioButton("light");
        JRadioButton darkButton = new JRadioButton("dark");
        JButton saveButton = new JButton("save");

        ButtonGroup group = new ButtonGroup();
        group.add(lightButton);
        group.add(darkButton);

        frame.add(themeLabel);
        frame.add(lightButton);
        frame.add(darkButton);
        frame.add(saveButton);

        saveButton.addActionListener(e -> {
            // TODO: make the theme appliyable
        });

        frame.setVisible(true);
    }
}