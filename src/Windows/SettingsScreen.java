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
        getContentPane().setBackground(ThemeManager.getBackgroundColor());

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


        lightButton.setBackground(ThemeManager.getBackgroundColor());
        lightButton.setForeground(ThemeManager.getForegroundColor());
        lightButton.setOpaque(true);
        darkButton.setBackground(ThemeManager.getBackgroundColor());
        darkButton.setForeground(ThemeManager.getForegroundColor());
        darkButton.setOpaque(true);
        saveButton.setBackground(ThemeManager.getBackgroundColor());
        saveButton.setForeground(ThemeManager.getForegroundColor());
        saveButton.setOpaque(true);
        themeLabel.setBackground(ThemeManager.getBackgroundColor());
        themeLabel.setForeground(ThemeManager.getForegroundColor());
        themeLabel.setOpaque(true);
        themeLabel.setText(currentTheme);
        saveButton.setFocusable(false);

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