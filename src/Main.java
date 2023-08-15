import javax.crypto.spec.PSource;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        instantiateDeck();
    }
    public static void instantiateDeck() {
//        int i = 0;
        ArrayList<Card> player1Cards = new ArrayList<>();
        ArrayList<Card> player2Cards = new ArrayList<>();
        ArrayList<Card> player3Cards = new ArrayList<>();

        Deck deck = new Deck();
        deck.shuffleDeck();

        //Distributing cards
        for (int i = 0; i < 7; i++) {
            player1Cards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }
        for (int i = 0; i < 7; i++) {
            player2Cards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }
        for (int i = 0; i < 7; i++) {
            player3Cards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }


        Card firstCardinPile = deck.getDeck().get(0);
        System.out.println("First card on board: "+firstCardinPile);
        deck.getDeck().remove(firstCardinPile);


        Hand p1Hand = new Hand(player1Cards);
        Hand p2Hand = new Hand(player2Cards);
        Hand p3Hand = new Hand(player3Cards);

        Player player1 = new Player("Player 1",p1Hand);
        Player player2 = new Player("Player 2",p2Hand);
        Player player3 = new Player("PLayer 3",p3Hand);

        System.out.println("Player 1 Hand : "+player1.getHand());
        System.out.println("Player 2 Hand: "+player2.getHand());
        System.out.println("Player 3 Hand: "+player2.getHand());

        startGame(player1,player2,player3,firstCardinPile,deck);


    }

    public static void startGame(Player p1,Player p2,Player p3, Card firstCardinPile,Deck deck){
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        HashMap<Integer,Card> cardIndexHolder = new HashMap<>();
        Scanner input = new Scanner(System.in);
        boolean won = false;
        Card topCard =  firstCardinPile;
        System.out.println("\n************Game Board**********\n");

        Player currentPlayer = p1;
        Player nextPlayer = p2;

        while(!won){
            System.out.println("Top card is: " + topCard);
            System.out.println("It's "+ currentPlayer.getName()+ "'s "+ "turn!");
            System.out.println( currentPlayer.getName()+ "'s "+"hand: ");
//            System.out.println(p.getHand().seeHand());
            int cardNumber = 1;
            //creating hash map
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
            //playable card block
            else if(canPlayCard(topCard,cardChosen,cardIndexHolder)){
                System.out.println("Player choose to play: "+cardIndexHolder.get(cardChosen));

                System.out.println(currentPlayer.getHand().seeHand().get(cardChosen-1));
                currentPlayer.getHand().seeHand().remove(cardChosen-1);
            }
            else{
                System.out.println("Cannot play card choose a card again: ");
                break;
            }
            //checking win condition
            if (currentPlayer.getHand().seeHand().isEmpty()){
                won = true;
            }
            topCard = cardIndexHolder.get(cardChosen);


            //changing players
            currentPlayer = players.get(players.indexOf(currentPlayer));


        }
    }

    public static boolean canPlayCard(Card currentCard, int cardChosen, Map<Integer, Card> cardIndexHolder){
        return cardIndexHolder.get(cardChosen).getColor().equals(currentCard.getColor())||cardIndexHolder.get(cardChosen).getValue().equals(currentCard.getValue());
    }



}