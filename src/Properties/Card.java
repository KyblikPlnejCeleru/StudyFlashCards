package Properties;

public class Card {

    private String name;
    private String imagePath;
    private Question question;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    private boolean isCorrect;

    public Card(String name, String imagePath, Question question) {
        this.name = name;
        this.imagePath = imagePath;
        this.question = question;
    }


    public boolean correction(int index){
        return index == question.getrAnswerIndex();

    }



    public String getImageName() {
        return imagePath;
    }


    public Question getQuestion() {
        return question;
    }


}
