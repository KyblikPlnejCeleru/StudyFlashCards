import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen {


    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();


    private JFrame frame;
    private ArrayList<Card> cards;
    private int currentIndex;
    private Game game;
    private JLabel question;
    private JButton answer1, answer2, answer3, answer4;
    private JLabel imageLabel;


    public GameScreen(ArrayList<Card> cards) {
        this.frame = new JFrame("FlashCards by romek");
        this.cards = cards;
        this.currentIndex = 0;
        frame.setVisible(true);
        this.game = new Game();
    }

    public void showApp() {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        question = new JLabel(cards.get(currentIndex).getQuestion().getQ());
        question.setPreferredSize(new Dimension(ss.width/7,ss.height/7));
        question.setOpaque(true);
        question.setBackground(ThemeManager.getBackgroundColor());
        question.setForeground(ThemeManager.getForegroundColor());

        question.setFont(new Font("Q", Font.PLAIN,ss.width / 60));

        question.setHorizontalAlignment(JLabel.CENTER);
        question.setSize(ss.width,ss.height/2);

        JPanel answers = new JPanel();
        answers.setLayout(new GridLayout(2,2));
        answers.setPreferredSize(new Dimension(ss.width/7,ss.height/7));
        answers.setBackground(ThemeManager.getBackgroundColor());


        answer1 = new JButton(cards.get(currentIndex).getQuestion().getAnswer()[0]);
        answer2 = new JButton(cards.get(currentIndex).getQuestion().getAnswer()[1]);
        answer3 = new JButton(cards.get(currentIndex).getQuestion().getAnswer()[2]);
        answer4 = new JButton(cards.get(currentIndex).getQuestion().getAnswer()[3]);

        Font answerFont = new Font("A", Font.PLAIN, ss.width / 80);

        answer1.setFont(answerFont);
        answer2.setFont(answerFont);
        answer3.setFont(answerFont);
        answer4.setFont(answerFont);


        answer1.setBackground(ThemeManager.getBackgroundColor());
        answer1.setForeground(ThemeManager.getForegroundColor());
        answer2.setBackground(ThemeManager.getBackgroundColor());
        answer2.setForeground(ThemeManager.getForegroundColor());
        answer3.setBackground(ThemeManager.getBackgroundColor());
        answer3.setForeground(ThemeManager.getForegroundColor());
        answer4.setBackground(ThemeManager.getBackgroundColor());
        answer4.setForeground(ThemeManager.getForegroundColor());

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);


        String imageName = cards.get(currentIndex).getImageName();
        ImageIcon img = new ImageIcon(imageName);
        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width/4,ss.height/3, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        frame.add(imageLabel,BorderLayout.CENTER);
        frame.add(question,BorderLayout.NORTH);
        frame.add(answers,BorderLayout.SOUTH);

        frame.getContentPane().setBackground(ThemeManager.getBackgroundColor());

        answer1.addActionListener(e -> {
            if (cards.get(currentIndex).correction(0)){
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                game.setWrongAns(game.getWrongAns()+1);
            }
            currentIndex++;
            updateScreen();
        });
        answer2.addActionListener(e -> {
            if (cards.get(currentIndex).correction(1)){
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                game.setWrongAns(game.getWrongAns()+1);
            }
            currentIndex++;
            updateScreen();
        });
        answer3.addActionListener(e -> {
            if (cards.get(currentIndex).correction(2)){
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                game.setWrongAns(game.getWrongAns()+1);
            }
            currentIndex++;
            updateScreen();
        });
        answer4.addActionListener(e -> {
            if (cards.get(currentIndex).correction(3)){
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                game.setWrongAns(game.getWrongAns()+1);
            }
            currentIndex++;
            updateScreen();
        });

    }

    private void updateScreen() {
        if (currentIndex < cards.size()) {
            question.setText(cards.get(currentIndex).getQuestion().getQ());
            answer1.setText(cards.get(currentIndex).getQuestion().getAnswer()[0]);
            answer2.setText(cards.get(currentIndex).getQuestion().getAnswer()[1]);
            answer3.setText(cards.get(currentIndex).getQuestion().getAnswer()[2]);
            answer4.setText(cards.get(currentIndex).getQuestion().getAnswer()[3]);
            String imageName = cards.get(currentIndex).getImageName();
            ImageIcon img = new ImageIcon(imageName);
            imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width / 4, ss.height / 3, Image.SCALE_SMOOTH)));
        } else {
            JOptionPane.showMessageDialog(frame, "Game over! Correct answers: " + game.getCorrectAnsw() + ", Wrong answers: " + game.getWrongAns());
            frame.dispose();
        }
    }
}
