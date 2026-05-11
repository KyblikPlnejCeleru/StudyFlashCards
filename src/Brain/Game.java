package Brain;

public class Game {

    private int correctAnsw;
    private int wrongAns;

    public Game() {
        this.correctAnsw =0;
        this.wrongAns =0;
    }

    public int numberOfAnswers(){
     return correctAnsw+wrongAns;
    }


    public int getCorrectAnsw() {
        return correctAnsw;
    }

    public void setCorrectAnsw(int correctAnsw) {
        this.correctAnsw = correctAnsw;
    }

    public int getWrongAns() {
        return wrongAns;
    }

    public void setWrongAns(int wrongAns) {
        this.wrongAns = wrongAns;
    }




}
