package Properties;

public class Card {

    private String name;
    private String imagePath;
    private Question question;

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
