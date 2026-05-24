package Properties;

/**
 * The Card class represents a single flashcard, containing a name, an image path, and a question.
 */
public class Card {

    private String name;
    private String imagePath;
    private Question question;


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