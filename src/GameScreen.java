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


    }
}
