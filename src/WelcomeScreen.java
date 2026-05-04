import javax.swing.*;
import java.awt.*;

public class WelcomeScreen {
    private JFrame frame;

    public WelcomeScreen() {
        this.frame = new JFrame("FlashCards");
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
            // TODO: open study window
        });

        settingsButton.addActionListener(e -> {
            SettingsScreen settingsScreen = new SettingsScreen();
            settingsScreen.showApp();
        });

        loadButton.addActionListener(e -> {
            // TODO: file selection window
        });

        frame.setVisible(true);
    }
}