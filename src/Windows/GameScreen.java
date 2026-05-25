package Windows;


import Brain.Game;
import Brain.ThemeManager;
import Properties.Card;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The GameScreen class represents the main game window where flashcards are displayed
 * and users can answer questions. It extends JFrame to provide a graphical user interface.
 */
public class GameScreen extends JFrame{


    /**
     * Stores the screen size of the default toolkit.
     */
    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();




    private ArrayList<Card> cards;
    private int currentIndex;
    private Game game;
    private JLabel question;
    private RoundedButton[] answer;
    private JLabel imageLabel;
    private WelcomeScreen welcomeScreen;



    /**
     * Constructs a new GameScreen.
     *
     * @param cards The ArrayList of Card objects to be used in the game.
     * @param welcomeScreen The WelcomeScreen instance to return to after the game.
     */
    public GameScreen(ArrayList<Card> cards, WelcomeScreen welcomeScreen) {
        setTitle("StudyFlaSHcARDS");
        this.cards = cards;
        this.currentIndex = 0;
        this.game = new Game();
        this.answer = new RoundedButton[4];
        this.welcomeScreen = welcomeScreen;

        ThemeManager.applyTheme();

        setExtendedState(Frame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(800,800));
        setSize(ss);



        question = new JLabel(cards.get(currentIndex).getQuestion().getQ());
        question.setPreferredSize(new Dimension(ss.width/7,ss.height/7));
        question.setBorder(BorderFactory.createLineBorder(ThemeManager.getForegroundColor(), 2));
        question.setFont(new Font("Q", Font.PLAIN,ss.width / 60));

        question.setHorizontalAlignment(JLabel.CENTER);
        question.setSize(ss.width,ss.height/2);

        JPanel answers = new JPanel();
        answers.setLayout(new GridLayout(2,2));
        answers.setPreferredSize(new Dimension(ss.width/7,ss.height/7));



        Font answerFont = new Font("A", Font.PLAIN, ss.width / 80);


        for (int i = 0; i < 4; i++) {
            answer[i] = new RoundedButton(cards.get(currentIndex).getQuestion().getAnswer()[i]);
            answer[i].setFont(answerFont);
            answer[i].setFocusable(false);
            answers.add(answer[i]);
        }


        String imageName = cards.get(currentIndex).getImageName();
        imageLabel = new JLabel();
        imageLabel.setIcon(loadImage(imageName));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(imageLabel,BorderLayout.CENTER);
        add(question,BorderLayout.NORTH);
        add(answers,BorderLayout.SOUTH);

        getContentPane().setBackground(ThemeManager.getBackgroundColor());
        for (int i = 0; i < answer.length; i++) {
            int finalI = i;
            answer[i].addActionListener(e -> {
                if (cards.get(currentIndex).correction(finalI)){
                    answer[finalI].setBackground(Color.GREEN);
                    game.setCorrectAnsw(game.getCorrectAnsw()+1);
                } else {
                    answer[finalI].setBackground(Color.RED);
                    answer[cards.get(currentIndex).getQuestion().getrAnswerIndex()].setBackground(Color.GREEN);
                    game.setWrongAns(game.getWrongAns()+1);
                }
                disableButtons();
                currentIndex++;
                waitTimer(finalI);
            });
        }

    }

    /**
     * Makes the GameScreen visible to the user.
     */
    public void showApp() {
        setVisible(true);
    }

    /**
     * Updates the screen with the next card's question, answers, and image.
     * If all cards have been played, it displays a game over message and returns to the welcome screen.
     *
     * @param c The index of the card to display.
     */
    public void updateScreen(int c) {
        if (currentIndex < cards.size()) {
            question.setText(cards.get(c).getQuestion().getQ());
            updateButtons(c);
            for (int i = 0; i < 4; i++) {
                answer[i].setBackground(ThemeManager.getBackgroundColor());
            }
            String imageName = cards.get(c).getImageName();
            imageLabel.setIcon(loadImage(imageName));
        } else {
            JOptionPane.showMessageDialog(this, "Game over! Correct answers: " + game.getCorrectAnsw() + ", Wrong answers: " +game.getWrongAns()+" "+ game.succesPercentage()+"%","Game Over", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            welcomeScreen.setVisible(true);
        }
    }

    /**
     * Updates the text of the answer buttons with the answers from the card at the given index.
     *
     * @param c The index of the card whose answers are to be displayed.
     */
    public void updateButtons(int c){
        for (int i = 0; i <4 ; i++) {
            answer[i].setText(cards.get(c).getQuestion().getAnswer()[i]);
        }
    }

    /**
     * Disables all answer buttons, preventing further interaction.
     */
    public void disableButtons(){
        for (int i = 0; i <4 ; i++) {
            answer[i].setEnabled(false);
        }
    }

    /**
     * Enables all answer buttons, allowing user interaction.
     */
    public void enableButtons(){
        for (int i = 0; i <4 ; i++) {
            answer[i].setEnabled(true);
        }
    }

    /**
     * Implements a short delay using a Swing Timer before updating the screen
     * and re-enabling buttons after an answer is selected.
     * @Author claude.ai
     * @param index The index of the button that was clicked.
     */
    public void waitTimer(int index){
        javax.swing.Timer timer = new javax.swing.Timer(500, event -> {
            answer[index].setBackground(ThemeManager.getBackgroundColor());
            updateScreen(currentIndex);
            enableButtons();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private ImageIcon loadImage(String imageName) {
        try {
            java.io.InputStream stream = getClass().getResourceAsStream("/" + imageName);
            if (stream != null) {
                Image img = javax.imageio.ImageIO.read(stream);
                return new ImageIcon(img.getScaledInstance(ss.width / 2, ss.height / 2, Image.SCALE_SMOOTH));
            }
            java.io.File jarDir = new java.io.File(
                    getClass().getProtectionDomain().getCodeSource().getLocation().toURI()
            ).getParentFile();
            java.io.File imgFile = new java.io.File(jarDir, imageName);
            if (imgFile.exists()) {
                Image img = javax.imageio.ImageIO.read(imgFile);
                return new ImageIcon(img.getScaledInstance(ss.width / 2, ss.height / 2, Image.SCALE_SMOOTH));
            }
            Image img = javax.imageio.ImageIO.read(new java.io.File(imageName));
            return new ImageIcon(img.getScaledInstance(ss.width / 2, ss.height / 2, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            return new ImageIcon();
        }
    }
}