import java.util.ArrayList;

public class CardHolder {
    private ArrayList<Card> cards = new ArrayList<>();

    public CardHolder(){

    }
    public void addCardToHand(Card card){
        this.cards.add(card);
    }
    public void removeCardFromHand(Card card){
        this.cards.remove(card);
    }
    public ArrayList<Card> seeHand(){
        return this.cards;
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
