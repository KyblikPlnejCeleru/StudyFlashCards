package Properties;

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
        return index == question.getrAnswerIndex();

    }



    public String getImageName() {
        return imageName;
    }


    public Question getQuestion() {
        return question;
    }


}
