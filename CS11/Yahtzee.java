import java.util.*;
public class Yahtzee {
        // global variables
        // Text colors to display
        public static final String ANSI_RESET = "\u001B[0m"; //from      https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_CYAN = "\u001B[36m";
        // int array for multiplayer score tracking
        static int[] total_score = new int[10];
        // reroll and contiune variable allows reroll and    multiple rounds
        static int reroll = 0;
        static int contiune = 0;
        // Multiplayer: Ask the user if they want to play multiplayer (currently only up to 10)
        // @param: none
        // @return: int
        public static int Multiplayer(){
            // initialize variable for player counts
            int player_count = 0;
            do {
                // ask the user how many players are playing
                System.out.println(ANSI_CYAN + "Welcome to Yahtzee game: \nHow many players are playing? (at lease one, up to 10)" + ANSI_RESET);
                Scanner input = new Scanner(System.in);
                 player_count = input.nextInt();
                 // check for invalid input
               if (player_count<1 || player_count>10){
                   System.out.println(ANSI_YELLOW+"Invalid input!, please input an integer between 1 and 10"+ANSI_RESET);
               }
            }
            // keep running if the input is invalid
            while (player_count>10 || player_count <1);
            // if the input is valid, print the player count to user
            if (player_count>=1 || player_count<=10) {
                System.out.println(ANSI_GREEN+"Player Count: " + player_count+ANSI_RESET);
            }
            return player_count;
        }
        //rollDice: rolls a dice and returns it's value
        //@param: none
        //@return: int
        public static int rollDice(){
            return (int)(Math.random() * 6) + 1; //from Ms. Postma
        }
        //reRoll : rerolls a dice and return its value
        //@param: int[]
        //@return: int[]
        public static int[] reRoll(int[] dice, int reroll){
        // reroll each index of the dice
            if (reroll == 0) {
                for (int i = 0; i < dice.length; i++) {
                    dice[i] = rollDice();
                }
            }
            //sort the dice:
            Arrays.sort(dice); //From: https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
            //print the dice:
            System.out.println(Arrays.toString(dice));
            return dice;
        }

        //twoofaKind: check if there is two of a kind in the array
        //@param: int[] dice
        //@return: int
        public static int TwoofaKind(int[] dice) {
            // initialize for score tracking
           int twoofakindscore = 0;
            for (int i = 0; i < dice.length - 1; i++) {
                // check if there is two indexes with the same value
                if (dice[i] == dice[i + 1]) {
                    // calculate the score
                    twoofakindscore = dice[i]*2;
                }
            }
            // return the score for two of a kind
            return twoofakindscore;
        }
        //threeofaKind: check if there is three of a kind in the array
        //@param: int[] dice
        //@return: int
        public static int ThreeofaKind(int[] dice) {
            // initialize for score tracking
            int threeofakind = 0;
            for (int i = 0; i < dice.length - 2; i++) {
                // check if there are 3 indexes with the same value
                if (dice[i] == dice[i + 2]) {
                    // calculate the score
                    threeofakind = dice[i]*3;
                }
            }
            // return the score
         return threeofakind;
        }
        //fourofaKind: check if there is four of a kind in the array
        //@param: int[] dice
        //@return: int
        public static int FourofaKind(int[] dice) {
            int fourofakind = 0;
            for (int i = 0; i < dice.length - 3; i++) {
                // check if there are 4 indexes with the same value
                if (dice[i] == dice[i + 3]) {
                    // calculate the score
                    fourofakind = dice[i]*4;
                }
            }
            // return the score
            return fourofakind;
         }

         //full house: check if there is a fullhouse in the array
         //@param: int[] dice
         //@return: int
        public static int FullHouse(int[] dice) {
         // one three of a kind and a different two of a kind
         // we look for the first card and last card in the array
             int first_card = dice [0];
             int same_first = 0;
             int last_card = dice [4];
             int same_last = 0;
            for (int i=0;i<dice.length;i++){
                // if the first card equals to any index
                if(first_card == dice[i]){
                    same_first++;
             }
                // if the last card equals to any index
                if(last_card == dice[i]){
                 same_last++;
            }
         }
            // if there are 3 indexes same with the first integer and 2 indexes same with the last integer, or the other way around, there is a fullhouse
            if (same_first == 3 && same_last ==2 ||same_first == 2 && same_last ==3 ){
                // return 25
                return 25;
            }
            // if there is no fullhouse, return 0
            else {
                return 0;
            }
         }
         //small straight: check if there are 4 of the dice sequential
        //@param: int[] dice
        //@return: int
        public static int SmallStraight(int[] dice) {

            for (int i = 0; i < dice.length - 3; i++) {
                // if there are 4 consecutive integers in a row, there is a small straight
                if (dice[i+3] - dice[i]== 3 && dice[i+2] - dice[i] == 2 && dice[i+1] - dice[i] == 1 && dice[i] != dice[i+1] && dice[i] != dice[i+2] && dice[i] != dice[i+3]
                        && dice[i+1] != dice[i+2] && dice[i+1] != dice[i+3]&& dice[i] != dice[i+1]){
                    return 30;
                }
            }
            // else return 0
            return 0;
        }
        //large straight: check if there are 5 of the dice sequential
        //@param: int[] dice
        //@return: int
        public static int LargeStraight(int[] dice) {
         // we can use a counter here
            int count = 0;
            for (int i = 0; i < dice.length - 1; i++) {
                 if (dice[i + 1] - dice[i] == 1) {
                    count++;
                }
                 // if counter =4 which means there are 5 consecutive indexes
                if (count == 4) {
                    return 40;
                }
            }
            return 0;
         }

        //Yahtzee: check if all 5 values are the same
        //@param: int[] dice
        //@return: int
        public static int Yahtzee(int[] dice){
            // let the first index to be a variable and compare other index.
            int same = dice [0];
            for (int i=1; i<dice.length; i++){
                // if there is any value that are not the same, there is no yahtzee
                if (dice[i] != same){
                    return 0;
                }
            }
            // else there is yahtzee and return 50
            return 50;
          }
        // UserChoice: User select which one to keep
        // @param: int (k2, k3, k4, fh, ss, ls, y)
        //@return: int
        public static int UserChoice ( int k2, int k3, int k4, int fh, int ss, int ls, int y){
            // initialize user choice integer
            int user_choice = 0;
            // ask user which one they want to keep
            do {
                System.out.println("Which one would you want to keep: \n 0 for two of a kind \n 1 for three of a kind \n" +
                        " 2 for four of a kind \n 3 for fullhouse \n 4 for smallstraight \n 5 for longstraight \n 6 for yahtzee!");
                Scanner input = new Scanner(System.in);
                // get user input
                user_choice = input.nextInt();
                // check for invalid input
                if (user_choice < 0 || user_choice > 6 ){
                    System.out.println(ANSI_YELLOW+"Invalid input! Please input a number from 0 to 6!"+ANSI_RESET);
                }
                // keep running if the user input is invalid
            } while (user_choice < 0 || user_choice > 6 );
            int score = 0;
            // tell the user which one they choose
            System.out.println(ANSI_CYAN+"You choose: "+user_choice+ANSI_RESET);
            // switch statement for assigning points to the user based on their choice
            switch (user_choice) {
                case 0:
                    // two of a kind
                    score = k2;
                    break;
                case 1:
                    // three of a kind
                    score = k3;
                    break;
                case 2:
                    // 4 of a kind
                    score = k4;
                    break;
                case 3:
                    // fullhouse
                    score = fh;
                    break;
                case 4:
                    // small straight
                    score = ss;
                    break;
                case 5:
                    // large straight
                    score = ls;
                    break;
                case 6:
                    // yahtzee
                    score = y;
                    break;
                default:
                    // if the user has an invalid input
                    System.out.println( ANSI_YELLOW+"Invalid Input: Please input A number from 0 to 6"+ANSI_RESET);
            }
            // return user's score
            return score;
         }
            // PrintScores: print the score of all players
            // @param: int
            //@return: void
        public static void printScore (int player_count){
            // print each player's score at the end of each round
            for (int i=0; i<player_count; i++){
                System.out.println("Player " + (i + 1) + "'s score is:" + total_score[i]);
            }
        }
        // main method
        public static void main(String[] args) {
            // ask the user how many players are playing the game
            int player_count = Multiplayer();
            // the game
            do {
                // tell the user whose turn is it
                for (int j=0; j<player_count; j++) {
                    System.out.println("Player " + (j + 1) + " 's turn.");
                    int[] dice = new int[5];
                    //call roll dice 5 times and store in the array!
                    for (int i = 0; i < dice.length; i++) {
                        dice[i] = rollDice();
                    }
                    //sort the dice:
                    Arrays.sort(dice); //From: https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
                    //print the dice:
                    System.out.println(Arrays.toString(dice));
                    do {
                        System.out.println(ANSI_GREEN+"Reroll the dice? 0 for yes ,1 for no"+ANSI_RESET);
                        Scanner input = new Scanner(System.in);
                        reroll = input.nextInt();
                        if (reroll != 0 && reroll != 1){
                            System.out.println(ANSI_YELLOW+"Invalid input!, please input 0 for yes, 1 for no"+ANSI_RESET);
                        }
                        else{

                            dice = reRoll(dice, reroll);
                        }
                    }
                    while (reroll == 0 || (reroll !=0 && reroll !=1 ));
                    //call all other methods on the dice and return the values:
                    //two of a kind
                    int k2_score = TwoofaKind(dice);
                    System.out.println(ANSI_CYAN+"Two of a kind:   " + k2_score+ANSI_RESET);
                    //three of a kind
                    int k3_score = ThreeofaKind(dice);
                    System.out.println(ANSI_CYAN+"Three of a kind: " + k3_score+ANSI_RESET);
                    //four of a kind
                    int k4_score = FourofaKind(dice);
                    System.out.println(ANSI_CYAN+"Four of a kind:  " + k4_score+ANSI_RESET);
                    //full house
                    int fh_score = FullHouse(dice);
                    System.out.println(ANSI_CYAN+"Full House:      " + fh_score+ANSI_RESET);
                    //small straight
                    int ss_score = SmallStraight(dice);
                    System.out.println(ANSI_RED+"Small Straight:  " + ss_score+ANSI_RESET);
                    //large straight
                    int ls_score = LargeStraight(dice);
                    System.out.println(ANSI_RED+"Large Straight:  " + ls_score+ANSI_RESET);
                    //yahtzee
                    int Y_score = Yahtzee(dice);
                    System.out.println(ANSI_RED+"Yahtzee:         " + Y_score+ANSI_RESET);
                    // call userChoice and store their score into the score tracker
                    total_score[j] = total_score[j] + UserChoice(k2_score, k3_score, k4_score, fh_score, ss_score, ls_score, Y_score);
                }
                    // print the score for each player
                    printScore(player_count);
                    do {
                        // ask the user if they want to contiune the game
                        System.out.println(ANSI_CYAN+"To contiune the game, input 0. To end the game, input 1."+ANSI_RESET);
                        Scanner input = new Scanner(System.in);
                        contiune = input.nextInt();
                        // check for invalid input
                        if (contiune != 0 && contiune != 1) {
                            System.out.println(ANSI_YELLOW + "Invalid Input! To contiune the game, input 0. To end the game, input 1." + ANSI_RESET);
                        }
                        // end the game
                        if (contiune == 1){
                            System.out.println(ANSI_CYAN + "Thank you for playing the Yahtzee game, have a nice day!" + ANSI_RESET);
                        }
                    }
                    // keep running until input is valid
                    while (contiune !=0 && contiune != 1);
                    // if user want to contiune the game, run it again
            } while (contiune ==0);
        }
    }

