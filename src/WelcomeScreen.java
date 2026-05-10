import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    private JFrame frame;
    private GameData gameData;

    public WelcomeScreen() {
        this.frame = new JFrame("FlashCards");
        this.gameData = new GameData();
    }

    public void showApp() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1, 5, 5));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("play");
        JButton settingsButton = new JButton("settings");
        JButton loadButton = new JButton("upload questions");

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
                gameData = GameData.loadGameDataFromFile(fc.getSelectedFile().getAbsolutePath());
                GameScreen gameScreen = new GameScreen(gameData.card);
                gameScreen.showApp();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}