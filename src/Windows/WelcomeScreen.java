package Windows;

import Brain.GameData;
import Brain.ThemeManager;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    private JFrame frame;
    private GameData gameData;
    private static WelcomeScreen instance;
    private RoundedButton startButton, settingsButton, loadButton;

    public WelcomeScreen() {
        this.frame = new JFrame("FlashCards");
        this.gameData = new GameData();
        this.startButton = new RoundedButton("Play");
        this.settingsButton = new RoundedButton("Settings");
        this.loadButton = new RoundedButton("Upload questions");

        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1, 5, 5));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        themeChanger();

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
            gameData = GameData.loadGameDataFromResources("/GameData.json");
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
                gameData = GameData.loadGameDataFromFile(fc.getSelectedFile().getAbsolutePath(),fc);
                if (!(gameData==null)){
                    GameScreen gameScreen = new GameScreen(gameData.getCards());
                    gameScreen.showApp();
                    frame.dispose();
                }
            }
        });
    }

    public void themeChanger(){
        frame.getContentPane().setBackground(ThemeManager.getBackgroundColor());
        frame.getContentPane().setForeground(ThemeManager.getForegroundColor());
        startButton.setForeground(ThemeManager.getForegroundColor());
        startButton.setBackground(ThemeManager.getBackgroundColor());
        settingsButton.setForeground(ThemeManager.getForegroundColor());
        settingsButton.setBackground(ThemeManager.getBackgroundColor());
        loadButton.setForeground(ThemeManager.getForegroundColor());
        loadButton.setBackground(ThemeManager.getBackgroundColor());
    }

    public void showApp() {
        themeChanger();
        frame.setVisible(true);

    }
    public static WelcomeScreen getInstance() {
        if (instance == null) {
            instance = new WelcomeScreen();
        }
        return instance;
    }
}