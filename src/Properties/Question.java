package Properties;

public class Question {

    private String q;
    private String[] answer;
    private int rAnswerIndex;

    public void setQ(String q) {
        this.q = q;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public void setrAnswerIndex(int rAnswerIndex) {
        this.rAnswerIndex = rAnswerIndex;
    }

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
