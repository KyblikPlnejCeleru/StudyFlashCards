package Brain;

/**
 * The Game class manages the game's statistics, such as the number of correct and wrong answers.
 */
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


    /**
     * Calculates the success percentage based on the number of correct answers and total cards.
     *
     * @return The success percentage, rounded to the nearest whole number.
     */
    public double succesPercentage(){
        return  Math.round((double) correctAnsw /numberOfAnswers()*100);
    }
}