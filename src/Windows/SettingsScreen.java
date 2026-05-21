package Windows;

import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends JFrame{

    public SettingsScreen() {
        setTitle("Setting");

        setSize(300, 200);
        setLayout(new GridLayout(4, 1, 6, 7));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel themeLabel = new JLabel("theme");
        JRadioButton lightButton = new JRadioButton("light");
        JRadioButton darkButton = new JRadioButton("dark");
        RoundedButton saveButton = new RoundedButton("save");
        JRadioButton custom = new JRadioButton("custom");

        ButtonGroup group = new ButtonGroup();
        RoundedButton roundedButton = new RoundedButton("custom");
        group.add(lightButton);
        group.add(darkButton);
        group.add(roundedButton);
        group.add(custom);

        String currentTheme = ThemeManager.getCurrentTheme();
        if (currentTheme.equals("dark")) {
            darkButton.setSelected(true);
        } else if (currentTheme.equals("light")){
            lightButton.setSelected(true);
        }

        add(roundedButton);
        add(themeLabel);
        add(lightButton);
        add(darkButton);
        add(saveButton);
        lightButton.setFocusable(false);
        darkButton.setFocusable(false);
        saveButton.setFocusable(false);
        roundedButton.setFocusable(false);
        ThemeManager.applyTheme();

        roundedButton.addActionListener(e -> {
            custom.setSelected(true);
            Color color = JColorChooser.showDialog(this, "Background", ThemeManager.getBackgroundColor());
            if (color != null) {
                ThemeManager.setTheme("");
                ThemeManager.setCustomBackground(color);
                ThemeManager.applyTheme();
            }
        });


        saveButton.addActionListener(e -> {
            if (lightButton.isSelected()) {
                ThemeManager.setTheme("light");
            } else if(darkButton.isSelected()){
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