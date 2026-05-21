package Windows;

import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends JFrame{

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

        panel.add(themeLabel);
        panel.add(lightButton);
        panel.add(darkButton);
        panel.add(roundedButton);
        panel.add(saveButton);
        setContentPane(panel);
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