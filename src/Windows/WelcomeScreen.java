package Windows;

import Brain.GameData;
import Brain.ThemeManager;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.Collections;

public class WelcomeScreen extends JFrame{
    private GameData gameData;
    private static WelcomeScreen instance;
    private RoundedButton startButton, settingsButton, loadButton;

    public WelcomeScreen() {
        setTitle("Welcome");
        this.gameData = new GameData();
        this.startButton = new RoundedButton("Play");
        this.settingsButton = new RoundedButton("Settings");
        this.loadButton = new RoundedButton("Upload questions");

        Font font = new Font("a",Font.PLAIN,15);

        setSize(300, 200);
        setLayout(new GridLayout(3, 1, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        startButton.setFont(font);
        settingsButton.setFont(font);
        loadButton.setFont(font);

        add(startButton);
        add(settingsButton);
        add(loadButton);


        startButton.addActionListener(e -> {
            gameData = GameData.loadGameDataFromResources("/GameData.json");
            Collections.shuffle(gameData.getCards());
            GameScreen gameScreen = new GameScreen(gameData.card);
            gameScreen.showApp();
            dispose();
        });

        settingsButton.addActionListener(e -> {
            SettingsScreen settingsScreen = new SettingsScreen();
            settingsScreen.showApp();
            dispose();
        });

        loadButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("json","json"));
            int file = fc.showOpenDialog(this);
            if (file == JFileChooser.APPROVE_OPTION) {
                gameData = GameData.loadGameDataFromFile(fc.getSelectedFile().getAbsolutePath(),fc);
                if (!(gameData==null)){
                    GameScreen gameScreen = new GameScreen(gameData.getCards());
                    gameScreen.showApp();
                    dispose();
                }
            } else if (file == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(fc,"Cmon select something im hunrgy");
            }
        });
    }

    public void themeChanger(){
        getContentPane().setBackground(ThemeManager.getBackgroundColor());
        getContentPane().setForeground(ThemeManager.getForegroundColor());
        startButton.setForeground(ThemeManager.getForegroundColor());
        startButton.setBackground(ThemeManager.getBackgroundColor());
        settingsButton.setForeground(ThemeManager.getForegroundColor());
        settingsButton.setBackground(ThemeManager.getBackgroundColor());
        loadButton.setForeground(ThemeManager.getForegroundColor());
        loadButton.setBackground(ThemeManager.getBackgroundColor());
    }

    public void showApp() {
        themeChanger();
        setVisible(true);

    }
    public static WelcomeScreen getInstance() {
        if (instance == null) {
            instance = new WelcomeScreen();
        }
        return instance;
    }
}