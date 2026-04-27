import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;
    private int answCount;
    private int rightAnswCount;

    private double successPercentage(){
        return (double)rightAnswCount/(double)answCount;
    }

    public Player(ArrayList<Card> cards, int rightAnswCount, int answCount) {
        this.cards = cards;
        this.rightAnswCount = rightAnswCount;
        this.answCount = answCount;
    }


}
