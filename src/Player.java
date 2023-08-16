public class Player {
    private String name;
    private CardHolder cardHolder;

    public Player(String name, CardHolder cardHolder){
        this.name= name;
        this.cardHolder = cardHolder;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardHolder getHand() {
        return this.cardHolder;
    }

    public void setHand(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }


    public void playCard(Card card) {
        cardHolder.removeCardFromHand(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + cardHolder +
                '}';
    }
}
