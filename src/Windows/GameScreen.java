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

public class GameScreen extends JFrame{


    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();



    private ArrayList<Card> cards;
    private int currentIndex;
    private Game game;
    private JLabel question;
    private RoundedButton[] answer;
    private JLabel imageLabel;



    public GameScreen(ArrayList<Card> cards) {
        setTitle("StudyFlaSHcARDS");
        this.cards = cards;
        this.currentIndex = 0;
        this.game = new Game();
        this.answer = new RoundedButton[4];

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
        ImageIcon img = new ImageIcon(imageName);
        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(img.getImage().getScaledInstance(ss.width/2, ss.height/2, Image.SCALE_SMOOTH)));
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

    public void showApp() {
        setVisible(true);
    }

    public void updateScreen(int c) {
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
            JOptionPane.showMessageDialog(this, "Game over! Correct answers: " + game.getCorrectAnsw() + ", Wrong answers: " + game.getWrongAns(),"Game Over", JOptionPane.INFORMATION_MESSAGE);
            dispose();
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
