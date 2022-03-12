/*
* Program Name: Card Battle
* Created on: Nov. 5
* Name: Jerry Z
* Purpose: To make a card game using Object Oriented Programming
*/
import java.util.*;

public class Main {
    // instance variables
    private static Player playerComputer = new Player("Computer");
    private static Player playerHuman;
    private static Player playerInTurn;
    private static final Deck deck = new Deck(true);
    private static ArrayList<Card> cardPool = new ArrayList<>();
    private static boolean gameOver = false;
    private static boolean continueGame = true;

    public static void main(String[] args) {
        // Initialize the game and continue until the user does not want to play anymore
        do {
            initGame();
            System.out.println("Would you like to play again? 1 for yes, 0 for no");
            Scanner sc = new Scanner(System.in);
            int playAgain = sc.nextInt();
            if (playAgain == 0) {
                continueGame = false;
                System.out.println("Thank you for playing Card Battles!");
            }
            // Clear the user's hand and the computer's hand
            gameOver = false;
            playerComputer.clearCard();
            playerHuman.clearCard();
        } while (continueGame);
    }

    public static void initGame() {
        System.out.println("The Card Battle Game is initializing...\n");
        System.out.println();
        // introduce the game
        System.out.println(" Rules: \n"+
                "1. In the Card Battle game, the user and the computer got half of the shuffled deck,\n"+
                "2. The player who plays first is randomly chosen,\n" +
                "3. If the suit of the last 2 played card matches, the player who had a higher card value wins the round and takes all cards previous played in the card pool.\n" +
                "4. The user can select how many rounds he/she wants to play\n" +
                "5. If one of the user has all 52 cards in hand before the game ends, that user wins the game.\n" +
                "6. Otherwise, the player with more card in hand will win at the end.\n" +
                "7. If the user and the computer has the same number of cards at the end, there will be a tiebreaker with extra 3 rounds being played.");
        System.out.println();
        // ask user for username
        System.out.println("Please input your username: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        playerHuman = new Player(userName);

        System.out.println("Would you like to request the help of Neo?, 1 for yes, 0 for no");
        int Neo = sc.nextInt();
        if(Neo == 1) {
            System.out.println("\033[32m Welcome to the Matrix Mode! Congratulations! You have discovered an easter egg!");
        }
        // Deal 26 cards to each player
        dealDeck();
        // Randomly choose who goes first
        chooseFirstPlayer();

        // ask user how many rounds he/she wants to play
        boolean roundsInRange = true;
        int rounds;
        do{
        System.out.println("How many rounds do you want to play in the game? Please enter a number between 5 and 25");
             rounds = sc.nextInt();
            if (rounds >= 5 && rounds <= 25) {
                break;
            }
            else
             {
                 System.out.println("Please enter a number between 5 and 25.");
                 roundsInRange = false;
            }
        } while(!roundsInRange);
        // play the game
        playRounds(rounds);
        // Display the winner
        declareWinner();
        System.out.println("Game over");
    }
    // Deal 26 cards to each player in alternating order
    public static void dealDeck() {
        for (int i = 0; i < 26; i++) {
            playerComputer.takeCard(deck.dealDeck());
            playerHuman.takeCard(deck.dealDeck());
        }
    }

    // Randomly choose who goes first
    public static void chooseFirstPlayer() {
        Random random = new Random();
        int n = random.nextInt(2);
        // make human player the player in turn
        if (n == 1) {
            playerInTurn = playerHuman;
        } else{
            // computer player goes first
            playerInTurn = playerComputer;
        }
    }

    // Play rounds, max rounds depends on user input (No more than 25 rounds)
    public static void playRounds(int rounds) {
        int roundCount = 1;
        while (roundCount <= rounds && (!gameOver)) {
            // Display the round number
            System.out.println("Round " + roundCount);
            System.out.println();

            // Display each player's hand
            displayHands();

            // Play individual round
            playRound();

            // Increment roundsPlayed counter
            roundCount++;
        }
    }

    // Play an individual round
    public static void playRound() {
        boolean suitMatch = false; // flag to indicate if the suit of the last 2 played cards matches
        Card cardToPlay;

        // if any player has a hand with 52 cards, game is over
        if ((playerComputer.handSize() >= 52) || (playerHuman.handSize() >= 52)) {
            gameOver = true;
        }

        while (!suitMatch) {
            // Current player places card on table if there are cards in hand
            if (playerInTurn.handSize() >= 1) {
                cardToPlay = playerInTurn.playCard();
                cardPool.add(cardToPlay);
            }
            else{
                gameOver = true;
                break;
            }

            if (gameOver){
                // if game is over, declare the winner
                System.out.println("Game Over!");
                declareWinner();
            }


            // Check if there's a suit match
            suitMatch = checkSuitMatch();

            if (!suitMatch){
                // if there's no suit match, switch player
                switchCurrentPlayer();
            }
        }
        // check the winner of the round if there is a suit match
        Player winner = checkWinner();
        collectCards(winner);

        System.out.println();

        // Sleep for 1 second before beginning a new round
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
    }

    // Switch current player
    public static void switchCurrentPlayer() {
        if (playerInTurn == playerComputer)
            playerInTurn = playerHuman;
        else if (playerInTurn == playerHuman)
            playerInTurn = playerComputer;
    }

    // Check for a suit match
    public static boolean checkSuitMatch() {
        int cardSize = cardPool.size();
        int lastSuit;
        int topSuit;

        if (cardSize < 2) {
            return false;
        }
        else {
            // get the last 2 cards in the card pool using accessor methods
            lastSuit = cardPool.get(cardSize - 1).getSuit();
            topSuit = cardPool.get(cardSize - 2).getSuit();
        }

        // Check suit equivalence
        return lastSuit == topSuit;
    }

    public static Player checkWinner(){
        int cardSize = cardPool.size();
        int lastValue;
        int topValue;

        // get the value of last 2 cards in the card pool
        lastValue = cardPool.get(cardSize - 1).getValue();
        topValue = cardPool.get(cardSize - 2).getValue();

        // compare value and check winner
            if(lastValue > topValue) {
                System.out.println();
                System.out.println(playerInTurn.getName() + " wins the round!");
                System.out.println();
                return playerInTurn;
            }
            else{
                if(playerInTurn == playerComputer) {
                    System.out.println();
                    System.out.println(playerHuman.getName() + " wins the round!");
                    System.out.println();
                    return playerHuman;
                }
                else{
                    System.out.println();
                    System.out.println(playerComputer.getName() + " wins the round!");
                    System.out.println();
                    return playerComputer;
                }
            }
    }

    // Collect cards from the pool
    public static void collectCards(Player winner) {
        // let the user know who took the cards from the card pool
        System.out.print(winner.getName() + " takes the card pool [" +
                cardPool.size() + "]: ");
        displayCardPool();

        // Player takes each card from the card pool and adds to hand
        for (Card cardToTake : cardPool) {
            winner.takeCard(cardToTake);
        }
        // clear the card pool
        cardPool.clear();
    }

    // Displays all the cards in the card pool
    public static void displayCardPool() {
        for (Card card : cardPool) {
            if (card != null) {
                System.out.print(card.getCard() + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    // Displays human player's current hand
    public static void displayHands() {
        playerHuman.displayHand();
    }

    // Declare the winner of the game based on the number of cards in their hand
    public static void declareWinner() {
        if (playerComputer.handSize() > playerHuman.handSize()) {
            System.out.println("\033[37m"+playerComputer.getName() + " Wins the game " +
                    "With a total of " + playerComputer.handSize() + " Cards in hand!");
        }
        else if (playerHuman.handSize() > playerComputer.handSize()) {
            System.out.println("\033[37m"+playerHuman.getName() + " Wins the game " +
                    "With a total of " + playerHuman.handSize() + " Cards in hand!");
        }
        // if there is a tie, run the tiebreaker!
        else if (playerComputer.handSize() == playerHuman.handSize()) {
            System.out.println("\033[33m"+"It's a tie?! Wow! Let's get into the tiebreaker!");
            // plays extra 3 rounds
            tieBreaker();
        }

        System.out.println();
    }

    public static void tieBreaker(){
        // plays extra 3 rounds
        playRounds(3);
        // declare winner
        declareWinner();
    }
}

