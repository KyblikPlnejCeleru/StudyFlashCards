package Properties;

/**
 * The Question class represents a single question with its text, multiple-choice answers,
 * and the index of the correct answer.
 */
public class Question {

    private String q;
    private String[] answer;
    private int rAnswerIndex;


    public String getQ() {
        return q;
    }

    public String[] getAnswer() {
        return answer;
    }

    public int getrAnswerIndex() {
        return rAnswerIndex;
    }
}