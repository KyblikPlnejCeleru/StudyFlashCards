import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen {

    private JFrame frame;
    private ArrayList<Card> cards;
    private int currentIndex;


    public GameScreen(ArrayList<Card> cards) {
        this.frame = new JFrame("FlashCards by romek");
        this.cards = new ArrayList<>();
        this.currentIndex = 0;
        frame.setVisible(true);
    }

    public void showApp() {
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton answer1 = new JButton("a");
        JButton answer2 = new JButton("b");
        JButton answer3 = new JButton("c");
        JButton answer4 = new JButton("d");

        ImageIcon img = new ImageIcon("test.jpg");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        ;//""
        frame.add(imageLabel,BorderLayout.CENTER);



    }
}
