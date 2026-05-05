import java.awt.*;

public class Card {

    private String name;
    private String imageName;
    private Question question;

    private boolean isCorrect;

    public Card(String name, String imageName, Question question) {
        this.name = name;
        this.imageName = imageName;
        this.question = question;
    }


    public boolean correction(int index){
        if (index==question.getrAnswerIndex()){
            return true;
        }
        return false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
