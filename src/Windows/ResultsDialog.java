package Windows;

import javax.swing.*;
import java.awt.*;

/**
 * Very small helper to show a modal results dialog with a single OK button.
 */
public class ResultsDialog {
    public static void showDialog(JFrame owner, int correct, int wrong, double accuracy) {
        JDialog dialog = new JDialog(owner, "Game Over", true);
        dialog.setLayout(new BorderLayout());

        JLabel title = new JLabel("Game Over", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(46, 139, 87));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JPanel stats = new JPanel(new GridLayout(3, 1, 0, 8));
        stats.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        stats.add(new JLabel(" Correct: " + correct, SwingConstants.CENTER));
        stats.add(new JLabel(" Wrong: " + wrong, SwingConstants.CENTER));
        stats.add(new JLabel(" Accuracy: " + (int)accuracy + "%", SwingConstants.CENTER));

        RoundedButton ok = new RoundedButton("OK");
        ok.setFocusable(false);
        ok.addActionListener(e ->{
                dialog.dispose();
                });
        JPanel bottom = new JPanel();
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        bottom.add(ok);

        dialog.add(title, BorderLayout.NORTH);
        dialog.add(stats, BorderLayout.CENTER);
        dialog.add(bottom, BorderLayout.SOUTH);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setLocationRelativeTo(owner);
        dialog.setVisible(true);

    }
}
