package Windows;

import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

/**
 * The SettingsScreen class provides a graphical interface for users to configure application settings,
 * primarily theme selection. It extends JFrame.
 */
public class SettingsScreen extends JFrame{

    /**
     * Constructs a new SettingsScreen.
     * Initializes the UI components for theme selection (light, dark, custom),
     * sets up layout, applies theme, and adds action listeners.
     */
    public SettingsScreen() {
        setTitle("Setting");

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 1, 6, 7));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        setResizable(false);

        JLabel themeLabel = new JLabel("theme");
        JRadioButton lightButton = new JRadioButton("light");
        JRadioButton darkButton = new JRadioButton("dark");
        RoundedButton saveButton = new RoundedButton("save");
        JRadioButton custom = new JRadioButton("custom");

        ButtonGroup group = new ButtonGroup();
        RoundedButton customThemeButton = new RoundedButton("custom");
        group.add(lightButton);
        group.add(darkButton);
        group.add(customThemeButton);

        String currentTheme = ThemeManager.getCurrentTheme();
        if (currentTheme.equals("dark")) {
            darkButton.setSelected(true);
        } else if (currentTheme.equals("light")){
            lightButton.setSelected(true);
        } else {
            customThemeButton.setSelected(true);
        }

        panel.add(themeLabel);
        panel.add(lightButton);
        panel.add(darkButton);
        panel.add(customThemeButton);
        panel.add(saveButton);
        setContentPane(panel);
        lightButton.setFocusable(false);
        darkButton.setFocusable(false);
        saveButton.setFocusable(false);
        customThemeButton.setFocusable(false);
        ThemeManager.applyTheme();

        customThemeButton.addActionListener(e -> {
            custom.setSelected(true);
            Color color = JColorChooser.showDialog(this, "Background", ThemeManager.getBackgroundColor());
            if (color != null) {
                ThemeManager.setTheme("custom");
                ThemeManager.setCustomBackground(color);
                ThemeManager.applyTheme();
            }
        });


        saveButton.addActionListener(e -> {
            if (lightButton.isSelected()) {
                ThemeManager.setTheme("light");
            } else if(darkButton.isSelected()){
                ThemeManager.setTheme("dark");
            } else if (customThemeButton.isSelected()){
                ThemeManager.setTheme("custom");
            }
            ThemeManager.saveSettings();
            dispose();
            new WelcomeScreen().showApp();
        });
    }

    /**
     * Makes the SettingsScreen visible to the user.
     */
    public void showApp() {
        setVisible(true);
    }
}