package Windows;


import Brain.Game;
import Brain.ThemeManager;
import Properties.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameScreen {


    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();


    private JFrame frame;
    private ArrayList<Card> cards;
    private int currentIndex;
    private Game game;
    private JLabel question;
    private RoundedButton[] answer;
    private JLabel imageLabel;


    public GameScreen(ArrayList<Card> cards) {
        this.frame = new JFrame("FlashCards by romek");
        this.cards = cards;
        this.currentIndex = 0;
        this.game = new Game();
        this.answer = new RoundedButton[4];

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,800));
        frame.setSize(ss);



        question = new JLabel(cards.get(currentIndex).getQuestion().getQ());
        question.setPreferredSize(new Dimension(ss.width/7,ss.height/7));
        question.setOpaque(true);
        question.setBackground(ThemeManager.getBackgroundColor());
        question.setForeground(ThemeManager.getForegroundColor());
        question.setBorder(BorderFactory.createLineBorder(ThemeManager.getForegroundColor(), 2));

        question.setFont(new Font("Q", Font.PLAIN,ss.width / 60));

        question.setHorizontalAlignment(JLabel.CENTER);
        question.setSize(ss.width,ss.height/2);

        JPanel answers = new JPanel();
        answers.setLayout(new GridLayout(2,2));
        answers.setPreferredSize(new Dimension(ss.width/7,ss.height/7));
        answers.setBackground(ThemeManager.getBackgroundColor());



        Font answerFont = new Font("A", Font.PLAIN, ss.width / 80);


        for (int i = 0; i < 4; i++) {
            answer[i] = new RoundedButton(cards.get(currentIndex).getQuestion().getAnswer()[i]);
            answer[i].setFont(answerFont);
            answer[i].setBackground(ThemeManager.getBackgroundColor());
            answer[i].setForeground(ThemeManager.getForegroundColor());
            answer[i].setFocusable(false);
            answers.add(answer[i]);
        }


        String imageName = cards.get(currentIndex).getImageName();
        ImageIcon img = new ImageIcon(imageName);
        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width/2, ss.height/2, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        frame.add(imageLabel,BorderLayout.CENTER);
        frame.add(question,BorderLayout.NORTH);
        frame.add(answers,BorderLayout.SOUTH);

        frame.getContentPane().setBackground(ThemeManager.getBackgroundColor());

        answer[0].addActionListener(e -> {
            if (cards.get(currentIndex).correction(0)){
                answer[0].setBackground(Color.GREEN);
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                answer[0].setBackground(Color.RED);
                answer[cards.get(currentIndex).getQuestion().getrAnswerIndex()].setBackground(Color.GREEN);
                game.setWrongAns(game.getWrongAns()+1);
            }
            disableButtons();
            currentIndex++;
            waitTimer(0);
        });
        answer[1].addActionListener(e -> {
            if (cards.get(currentIndex).correction(1)){
                answer[1].setBackground(Color.GREEN);
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                answer[1].setBackground(Color.RED);
                answer[cards.get(currentIndex).getQuestion().getrAnswerIndex()].setBackground(Color.GREEN);
                game.setWrongAns(game.getWrongAns()+1);
            }
            disableButtons();
            currentIndex++;
            waitTimer(1);
        });
        answer[2].addActionListener(e -> {
            if (cards.get(currentIndex).correction(2)){
                answer[2].setBackground(Color.GREEN);
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                answer[2].setBackground(Color.RED);
                answer[cards.get(currentIndex).getQuestion().getrAnswerIndex()].setBackground(Color.GREEN);
                game.setWrongAns(game.getWrongAns()+1);
            }
            disableButtons();
            currentIndex++;
            waitTimer(2);
        });
        answer[3].addActionListener(e -> {
            if (cards.get(currentIndex).correction(3)){
                answer[3].setBackground(Color.GREEN);
                game.setCorrectAnsw(game.getCorrectAnsw()+1);
            } else {
                answer[3].setBackground(Color.RED);
                answer[cards.get(currentIndex).getQuestion().getrAnswerIndex()].setBackground(Color.GREEN);
                game.setWrongAns(game.getWrongAns()+1);
            }
            disableButtons();
            currentIndex++;
            waitTimer(3);
        });

    }

    public void showApp() {
        frame.setVisible(true);
    }

    private void updateScreen(int c) {
        if (currentIndex < cards.size()) {
            question.setText(cards.get(c).getQuestion().getQ());
            updateButtons(c);
            for (int i = 0; i < 4; i++) {
                answer[i].setBackground(ThemeManager.getBackgroundColor());
            }
            String imageName = cards.get(c).getImageName();
            ImageIcon img = new ImageIcon(imageName);
            imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width/2, ss.height/2, Image.SCALE_SMOOTH)));
        } else {
            JOptionPane.showMessageDialog(frame, "Game over! Correct answers: " + game.getCorrectAnsw() + ", Wrong answers: " + game.getWrongAns(),"Game Over", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            WelcomeScreen.getInstance().showApp();
        }
    }
    public void updateButtons(int c){
        for (int i = 0; i <4 ; i++) {
            answer[i].setText(cards.get(c).getQuestion().getAnswer()[i]);
        }
    }

    public void disableButtons(){
        for (int i = 0; i <4 ; i++) {
            answer[i].setEnabled(false);
        }
    }

    public void enableButtons(){
        for (int i = 0; i <4 ; i++) {
            answer[i].setEnabled(true);
        }
    }

    // waitTimer method was made with help of AI - claude.ai
    public void waitTimer(int index){
        javax.swing.Timer timer = new javax.swing.Timer(500, event -> {
            answer[index].setBackground(ThemeManager.getBackgroundColor());
            updateScreen(currentIndex);
            enableButtons();
        });
        timer.setRepeats(false);
        timer.start();
    }
}
