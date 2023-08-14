import javax.crypto.spec.PSource;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        instantiateDeck();
    }
    public static void instantiateDeck() {
//        int i = 0;
        ArrayList<Card> playerCards = new ArrayList<>();
        ArrayList<Card> computerCards = new ArrayList<>();

        Deck deck = new Deck();
        deck.shuffleDeck();

        //Distributing cards
        for (int i = 0; i < 7; i++) {
            playerCards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }
        for (int i = 7; i < 14; i++) {
            computerCards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }

        Card firstCardinPile = deck.getDeck().get(0);
        System.out.println("First card on board: "+firstCardinPile);
        deck.getDeck().remove(firstCardinPile);


        Hand pHand = new Hand(playerCards);
        Hand cHand = new Hand(computerCards);

        Player player1 = new Player("Player1",pHand);

        Player computer = new Player("Computer",cHand);

        System.out.println("Player 1 Hand : "+player1.getHand());
        System.out.println("Computer Hand: "+computer.getHand());
        startGame(player1,computer,firstCardinPile,deck);


    }
    public static void startGame(Player p,Player c,Card firstCardinPile,Deck deck){
        HashMap<Integer,Card> cardIndexHolder = new HashMap<>();
        Scanner input = new Scanner(System.in);
        boolean won = false;
        Card firstCard =  firstCardinPile;
        System.out.println("\n************Game Board**********\n");
        Player currentPlayer = p;
        Player opponent = c;

//        System.out.println(firstCard);

        while(!won){
            System.out.println(firstCard);
            System.out.println("It's "+ currentPlayer.getName()+ "'s "+ "turn!");
            System.out.println( currentPlayer.getName()+ "'s "+"hand: ");
//            System.out.println(p.getHand().seeHand());
            int cardNumber = 1;
            for (Card card: currentPlayer.getHand().seeHand()) {
                System.out.println(cardNumber + " " +card );
                cardIndexHolder.put(cardNumber,card);
                cardNumber++;
            }
            System.out.println(0 + " " + "Draw a Card");

            System.out.print("Choose to Play: ");
            int cardChosen = input.nextInt();

            if(cardChosen == 0){
                currentPlayer.getHand().seeHand().add(deck.getDeck().get(0));
                deck.getDeck().remove(0);
            }
            else if(canPlayCard(firstCard,cardChosen,cardIndexHolder)){
                System.out.println("yes can play");
                System.out.println(firstCard);
                System.out.println(cardIndexHolder.get(cardChosen));
                System.out.println(cardChosen);
                System.out.println("Card removed from hand "+ currentPlayer.getHand().seeHand().get(cardChosen-1));
                currentPlayer.getHand().seeHand().remove(cardChosen-1);
                System.out.println("Now "+ currentPlayer.getName()+ "'s" +" hand "+ currentPlayer.getHand().seeHand());
            }
            else{
                System.out.println(currentPlayer.getHand().seeHand().contains(firstCard));
                for (Card cardInHand: currentPlayer.getHand().seeHand() ) {
                    if ((cardInHand.getValue().equals(firstCard.getValue()) || (cardInHand.getColor().equals(firstCard.getColor())))) {
                        break;
                    }
                }

            }
            if (currentPlayer.getHand().seeHand().isEmpty()){
                won = true;
            }
            firstCard = cardIndexHolder.get(cardChosen);
            Player tempPlayer = currentPlayer;
            currentPlayer = opponent;
            opponent = tempPlayer;

        }
    }

    public static boolean canPlayCard(Card currentCard, int cardChosen, Map<Integer, Card> cardIndexHolder){
        return cardIndexHolder.get(cardChosen).getColor().equals(currentCard.getColor())||cardIndexHolder.get(cardChosen).getValue().equals(currentCard.getValue());
    }

}