import javax.crypto.spec.PSource;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Card> cardarr = new ArrayList<>();
//
//        Color col= Color.BLUE;
//        Value val =  Value.FIVE;
//
//        Card card = new Card(col,val);
//        Color col2= Color.RED;
//        Value val2 =  Value.FOUR;
//        Card card2 = new Card(col2,val2);
//
//        Color col3= Color.YELLOW;
//        Value val3 =  Value.ONE;
//        Card card3 = new Card(col3,val3);
//
//        cardarr.add(card);
//        cardarr.add(card2);
//
////        System.out.println(cardarr);
//
//        Hand pHand = new Hand(cardarr);
//        pHand.addCardToHand(card3);
//
//        Player pranjal = new Player("Pranjal" , pHand);
//        System.out.println(pranjal.getHand());
//
//        System.out.println("all cards: ");
//        Deck deck = new Deck();
//        Card[] theDeck = deck.getDeck();
//
//        deck.shuffleDeck();
//        System.out.println(Arrays.toString(theDeck));
        instantiateDeck();

    }

    public static void instantiateDeck() {
//        int i = 0;
        ArrayList<Card> playerCards = new ArrayList<>();
        ArrayList<Card> computerCards = new ArrayList<>();

        Deck deck = new Deck();
        deck.shuffleDeck();
        System.out.println(deck.getDeck());
        for (int i = 0; i < 7; i++) {
            playerCards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }
        for (int i = 7; i < 14; i++) {
            computerCards.add(deck.getDeck().get(i));
            deck.getDeck().remove(deck.getDeck().get(i));
        }
//        int i = 14;

        Card firstCardinPile = deck.getDeck().get(14);

        deck.getDeck().remove(firstCardinPile);
        System.out.println("First card on board: "+firstCardinPile);
        System.out.println("Deck now: "+deck.getDeck());
        System.out.println("Now length of deck: "+deck.getDeck().size());
        System.out.println(deck.getDeck().contains(firstCardinPile));


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

        System.out.println(firstCard);

        while(!won){
            System.out.println("It's "+ currentPlayer.getName()+ "'s "+ "turn!");
            System.out.println("Your hand: ");
//            System.out.println(p.getHand().seeHand());
            int cardNumber = 1;
            for (Card card: p.getHand().seeHand()) {
                System.out.println(String.valueOf(cardNumber) + " " +card );
                cardIndexHolder.put(cardNumber,card);
                cardNumber++;
            }
            System.out.println("Choose to Play: ");
            int cardChosen = input.nextInt();
            if(canPlayCard(firstCard,cardChosen,cardIndexHolder)){
                System.out.println("yes can play");
                System.out.println(firstCard);
                System.out.println(cardIndexHolder.get(cardChosen));
                System.out.println(cardChosen);


                System.out.println("Card removed from hand "+ p.getHand().seeHand().get(cardChosen-1));
                p.getHand().seeHand().remove(cardChosen-1);

                System.out.println("Now hand "+ p.getHand().seeHand());
            }
            else{
                boolean cardFound = false;
                System.out.println(p.getHand().seeHand().contains(firstCard));
                for (Card cardInHand: p.getHand().seeHand() ) {
                    if ((cardInHand.getValue().equals(firstCard.getValue()) || (cardInHand.getColor().equals(firstCard.getColor())))) {
                        cardFound = true;
                        break;
                    }
                }
                if (cardFound){
                    System.out.println("Card cannot be played...play another!");
                    continue;
                }
                else{
                    System.out.println("Necessary card not in your deck...drawing....");
                    for (Card deckCheck: deck.getDeck() ) {
                        if ((deckCheck.getValue().equals(firstCard.getValue())||(deckCheck.getColor().equals(firstCard.getColor())))){
                            p.getHand().seeHand().add(deckCheck);
                            deck.getDeck().remove(deckCheck);
                            System.out.println("Added card "+ deckCheck);
                            System.out.println("Now Deck "+ deck.getDeck());
                            System.out.println("Now Hand "+ p.getHand().seeHand());
                        }
                    }
                }

                if (currentPlayer.getHand().seeHand().isEmpty()){
                    won = true;
                }

                System.out.println("neeche");
                Player tempPlayer = currentPlayer;
                currentPlayer = opponent;
                opponent = tempPlayer;
                //hard code kar raha hoon sirf check karne ke liye baad mein update karunga
                firstCard = deck.getDeck().get(15);

            }
        }
    }

    public static boolean canPlayCard(Card currentCard, int cardChosen, Map<Integer, Card> cardIndexHolder){
        return cardIndexHolder.get(cardChosen).getColor().equals(currentCard.getColor())||cardIndexHolder.get(cardChosen).getValue().equals(currentCard.getValue());
    }

}