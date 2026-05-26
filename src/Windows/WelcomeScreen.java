package Windows;

import Brain.GameData;
import Brain.ThemeManager;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.Collections;

/**
 * The WelcomeScreen class represents the initial screen of the application,
 * allowing users to start a new game, access settings, or load questions from a file.
 * It extends JFrame to provide a graphical user interface.
 */
public class WelcomeScreen extends JFrame{
    /**
     * An instance of GameData to load and manage flashcard data.
     */
    private GameData gameData;
    /**
     * Buttons for starting the game, accessing settings, and uploading questions.
     */
    private RoundedButton startButton, settingsButton, loadButton;

    /**
     * Constructs a new WelcomeScreen.
     * Initializes the UI components, sets up layout, applies theme, and adds action listeners to buttons.
     */
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


        startButton.setFont(font);
        settingsButton.setFont(font);
        loadButton.setFont(font);

        ThemeManager.applyTheme();

        add(startButton);
        add(settingsButton);
        add(loadButton);
        startButton.setFocusable(false);
        settingsButton.setFocusable(false);
        loadButton.setFocusable(false);

        startButton.addActionListener(e -> {
            gameData = GameData.loadGameDataFromResources("/GameData.json");
            Collections.shuffle(gameData.card);
            GameScreen gameScreen = new GameScreen(gameData.card,this);
            gameScreen.showApp();
            setVisible(false);
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
                    Collections.shuffle(gameData.card);
                    GameScreen gameScreen = new GameScreen(gameData.getCards(),this);
                    gameScreen.showApp();
                    setVisible(false);
                }
            } else if (file == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(fc,"Cmon select something im hunrgy");
            }
        });
    }

    /**
     * Applies the current theme settings to the components of the WelcomeScreen.
     * This includes setting background and foreground colors for the content pane and buttons.
     */
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

    /**
     * Makes the WelcomeScreen visible to the user.
     * It also applies the theme and updates the component colors before becoming visible.
     */
    public void showApp() {
        ThemeManager.applyTheme();
        themeChanger();
        setVisible(true);
    }

}