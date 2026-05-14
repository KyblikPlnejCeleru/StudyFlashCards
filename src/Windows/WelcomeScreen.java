package Windows;

import Brain.GameData;
import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    private JFrame frame;
    private GameData gameData;
    private static WelcomeScreen instance;

    public WelcomeScreen() {
        this.frame = new JFrame("FlashCards");
        this.gameData = new GameData();

        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1, 5, 5));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(ThemeManager.getBackgroundColor());


        RoundedButton startButton = new RoundedButton("play");
        RoundedButton settingsButton = new RoundedButton("settings");
        RoundedButton loadButton = new RoundedButton("upload questions");

        startButton.setForeground(ThemeManager.getForegroundColor());
        startButton.setBackground(ThemeManager.getBackgroundColor());
        settingsButton.setForeground(ThemeManager.getForegroundColor());
        settingsButton.setBackground(ThemeManager.getBackgroundColor());
        loadButton.setForeground(ThemeManager.getForegroundColor());
        loadButton.setBackground(ThemeManager.getBackgroundColor());
        startButton.setFocusPainted(false);
        settingsButton.setFocusable(false);
        loadButton.setFocusable(false);

        frame.add(startButton);
        frame.add(settingsButton);
        frame.add(loadButton);


        startButton.addActionListener(e -> {
            gameData = GameData.loadFromPath("/GameData.json");
            GameScreen gameScreen = new GameScreen(gameData.card);
            gameScreen.showApp();
            frame.dispose();
        });

        settingsButton.addActionListener(e -> {
            SettingsScreen settingsScreen = new SettingsScreen();
            settingsScreen.showApp();
            frame.dispose();
        });

        loadButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            if (fc.getSelectedFile() != null) {
                gameData = GameData.loadFromPath(fc.getSelectedFile().getAbsolutePath());
                GameScreen gameScreen = new GameScreen(gameData.card);
                gameScreen.showApp();
                frame.dispose();
            }
        });
    }

    public void showApp() {
        frame.setBackground(ThemeManager.getBackgroundColor());
        frame.setForeground(ThemeManager.getForegroundColor());
        frame.setVisible(true);

    }
    public static WelcomeScreen getInstance() {
        if (instance == null) {
            instance = new WelcomeScreen();
        }
        return instance;
    }
}