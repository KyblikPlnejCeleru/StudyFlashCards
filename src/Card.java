import java.awt.*;

public class Card {

    private String name;
    private int id;
    private String imageName;
    private Question question;

    private boolean isCorrect;

    public Card(String name, int id, String imageName, Question question) {
        this.name = name;
        this.id = id;
        this.imageName = imageName;
        this.question = question;
    }


    public boolean correction(int index){
        if (index==question.getrAnswerIndex()){
            return true;
        }
        return false;

    }





}
