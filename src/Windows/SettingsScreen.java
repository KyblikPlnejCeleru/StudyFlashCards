package Windows;

import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends JFrame{

    public SettingsScreen() {
        setTitle("Settings");

        setSize(300, 200);
        setLayout(new GridLayout(4, 1, 6, 7));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel themeLabel = new JLabel("theme");
        JRadioButton lightButton = new JRadioButton("light");
        JRadioButton darkButton = new JRadioButton("dark");
        RoundedButton saveButton = new RoundedButton("save");

        ButtonGroup group = new ButtonGroup();
        group.add(lightButton);
        group.add(darkButton);

        String currentTheme = ThemeManager.getCurrentTheme();
        if (currentTheme.equals("dark")) {
            darkButton.setSelected(true);
        } else {
            lightButton.setSelected(true);
        }

        add(themeLabel);
        add(lightButton);
        add(darkButton);
        add(saveButton);
        lightButton.setFocusable(false);
        darkButton.setFocusable(false);
        saveButton.setFocusable(false);
        ThemeManager.applyTheme();




        saveButton.addActionListener(e -> {
            if (lightButton.isSelected()) {
                ThemeManager.setTheme("light");
            } else {
                ThemeManager.setTheme("dark");
            }
            WelcomeScreen.getInstance().showApp();
            dispose();
        });
    }

    public void showApp() {
        setVisible(true);
    }
}