import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen {


    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();


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
        frame.setSize(ss.width/16*10,ss.height / 10*10);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JLabel question = new JLabel("cau dobry den");
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setSize(ss.width,ss.height/2);
        JButton answer1 = new JButton("a");
        JButton answer2 = new JButton("b");
        JButton answer3 = new JButton("c");
        JButton answer4 = new JButton("d");

        ImageIcon img = new ImageIcon("test.jpg");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width/4,ss.height/3, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        ;//""
        frame.add(imageLabel,BorderLayout.CENTER);
        frame.add(question,BorderLayout.NORTH);




    }
}
