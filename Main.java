// Name: Jerry Zhang
// Task: Print the Tree
// Date: Nov.5
// import
import java.util.*;
import java.lang.*;
public class Main {
// initialize and declare global varibles here
// Text colors to display
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // color for trunks and leaves
    public static String f_leaf_color;
    public static String f_trunk_color;

    // boolean for the program to run again
    public static boolean run_again = true;

    // main void
    public static void main(String[] args) {
        // declare local variable run
        boolean run = true;
        do {
            // initialize global variables
            int tree_leaf_rows;
            int tree_times;
            int i_leaf_color;
            int tree_height;
            int tree_width;
            char text;
            int i_trunk_color;
            //Ask the user to input the number of rows of the leaf
            Scanner input = new Scanner(System.in);
            // a series of do-while loops to ensure user inputs are valid
            do {
                System.out.println("Please input the rows of the tree leaf");
                tree_leaf_rows = input.nextInt();
                if (tree_leaf_rows <= 0){
                    System.out.println(ANSI_YELLOW + "Warning: Invalid input, please a number that is larger than 0!!!" + ANSI_RESET);
                }
            }
            while (tree_leaf_rows <= 0);

            //ask the user for the times to display the leaf pattern
            do {
                System.out.println("Please input times you want the leaf pattern to be displayed");
                tree_times = input.nextInt();
                if (tree_times <= 0){
                    System.out.println(ANSI_YELLOW + "Warning: Invalid input, please a number that is larger than 0!!!" + ANSI_RESET);
                }
            }
            while (tree_times <= 0);

            String leaf_color = ANSI_RESET;
            do {
                // ask the user for the color of the leaf pattern
                System.out.println("Please input the number of the pattern you want the leaf pattern to be displayed \n" +
                        "0 for default (white) \n" +
                        "1 for black \n" +
                        "2 for red \n" +
                        "3 for green \n" +
                        "4 for yellow \n" +
                        "5 for blue \n" +
                        "6 for purple \n" +
                        "7 for cyan \n");
                i_leaf_color = input.nextInt();


                // switch statement for assigning leaf color
                switch (i_leaf_color) {
                    case 0:
                        leaf_color = ANSI_WHITE;
                        System.out.println(leaf_color + "You have selected Default for leaves" + ANSI_RESET);
                        break;
                    case 1:
                        leaf_color = ANSI_BLACK;
                        System.out.println(leaf_color + "You have selected Black for leaves" + ANSI_RESET);
                        break;
                    case 2:
                        leaf_color = ANSI_RED;
                        System.out.println(leaf_color + "You have selected Red for leaves" + ANSI_RESET);
                        break;
                    case 3:
                        leaf_color = ANSI_GREEN;
                        System.out.println(leaf_color + "You have selected Green for leaves" + ANSI_RESET);
                        break;
                    case 4:
                        leaf_color = ANSI_YELLOW;
                        System.out.println(leaf_color + "You have selected Yellow for leaves" + ANSI_RESET);
                        break;
                    case 5:
                        leaf_color = ANSI_BLUE;
                        System.out.println(leaf_color + "You have selected Blue for leaves" + ANSI_RESET);
                        break;
                    case 6:
                        leaf_color = ANSI_PURPLE;
                        System.out.println(leaf_color + "You have selected Purple for leaves" + ANSI_RESET);
                        break;
                    case 7:
                        leaf_color = ANSI_CYAN;
                        System.out.println(leaf_color + "You have selected Cyan for leaves" + ANSI_RESET);
                        break;
                    default:
                        // if the user has an invalid input
                        System.out.println(ANSI_YELLOW + "Invalid Input: Please input A number from 0 to 7" + ANSI_RESET);
                }
            }
            while (i_leaf_color<0 || i_leaf_color>7);
            //  assigning it to the global variable
            f_leaf_color = leaf_color;
            // ask the user to input the height of the trunk
            do {
                System.out.println("Please input the height of the tree trunk");
                tree_height = input.nextInt();
                if (tree_height <= 0){
                    System.out.println(ANSI_YELLOW + "Warning: Invalid input, please a number that is larger than 0!!!" + ANSI_RESET);
                }
            }
            while (tree_height <= 0);
            // ask the user to input the width of the trunk
            do {
                System.out.println("Please input the width of the tree trunk");
                 tree_width = input.nextInt();
                if (tree_width <= 0){
                    System.out.println(ANSI_YELLOW + "Warning: Invalid input, please a number that is larger than 0!!!" + ANSI_RESET);
                }
                else if(tree_width > (tree_leaf_rows*2 - 1)){
                    System.out.println(ANSI_YELLOW + "Warning: The Tree Trunk is TOO Wide, please input the width of the trunk that is smaller than the tree leaf width!!!" + ANSI_RESET);
                }
            }
            while (tree_width <= 0 || tree_width > (tree_leaf_rows*2 - 1));


            String trunk_color = ANSI_RESET;
            do {
                // ask the user for the color of the trunk pattern
                System.out.println("Please input the number of the pattern you want the trunk pattern to be displayed \n" +
                        "0 for default (white) \n" +
                        "1 for black \n" +
                        "2 for red \n" +
                        "3 for green \n" +
                        "4 for yellow \n" +
                        "5 for blue \n" +
                        "6 for purple \n" +
                        "7 for cyan \n");
               i_trunk_color = input.nextInt();
                // switch statement for assigning leaf color
                switch (i_trunk_color) {
                    case 0:
                        trunk_color = ANSI_WHITE;
                        System.out.println(trunk_color + "You have selected Default for trunk" + ANSI_RESET);
                        break;
                    case 1:
                        trunk_color = ANSI_BLACK;
                        System.out.println(trunk_color + "You have selected Black for trunk" + ANSI_RESET);
                        break;
                    case 2:
                        trunk_color = ANSI_RED;
                        System.out.println(trunk_color + "You have selected Red for trunk" + ANSI_RESET);
                        break;
                    case 3:
                        trunk_color = ANSI_GREEN;
                        System.out.println(trunk_color + "You have selected Green for trunk" + ANSI_RESET);
                        break;
                    case 4:
                        trunk_color = ANSI_YELLOW;
                        System.out.println(trunk_color + "You have selected Yellow for trunk" + ANSI_RESET);
                        break;
                    case 5:
                        trunk_color = ANSI_BLUE;
                        System.out.println(trunk_color + "You have selected Blue for trunk" + ANSI_RESET);
                        break;
                    case 6:
                        trunk_color = ANSI_PURPLE;
                        System.out.println(trunk_color + "You have selected Purple for trunk" + ANSI_RESET);
                        break;
                    case 7:
                        trunk_color = ANSI_CYAN;
                        System.out.println(trunk_color + "You have selected Cyan for trunk" + ANSI_RESET);
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid Input: Please input A number from 0 to 7!" + ANSI_RESET);
                     
                }
             }
            while (i_trunk_color<0 || i_trunk_color>7);

            f_trunk_color = trunk_color;
            // ask the user to input the text pattern
            char empty_char = ' ';
            do {
                System.out.println("Please enter the text pattern to display");
                text = input.next().charAt(0);

                if (tree_width <= 0) {
                    System.out.println(ANSI_YELLOW + "Warning: Invalid input, please a number that is larger than 0!!!" + ANSI_RESET);
                }
            }
            while (text == empty_char);

            // print the user input
            System.out.println("The rows of leaf is: " + tree_leaf_rows + ".");
            System.out.println("The leaf will be printing " + tree_times + " times.");
            System.out.println("The height of trunk is: " + tree_height + ".");
            System.out.println("The width of trunk is: " + tree_width + ".");
            System.out.println("The text pattern to display is: '" + text + "'.");

            // Display the tree
            // print the tree leaf in a certain number of times
            treeLeafTimes(tree_times, tree_leaf_rows, text, f_leaf_color);
            // print the tree trunk
            treeTrunk(tree_height, tree_width, tree_leaf_rows, text, f_trunk_color);

            int user_choice;
            //ask the user if they want to run the program again!
            do {
                System.out.println("Do you want to run the program again? \n 0 for yes, \n 1 for no!");
                 user_choice= input.nextInt();
                //switch statement
                switch (user_choice) {
                    case 0:
                        // if the user wants to run the program again
                        run = true;
                        System.out.println("Running the program again...");
                        break;
                    case 1:
                        // if the user wants to end the program
                        System.out.println("The Program has ended. Thank you!");
                        // exit the program
                        System.exit(0);
                        break;
                    default:
                        System.out.println(ANSI_RED + "Invalid Input: Please input 0 for yes 1 for no!" + ANSI_RESET);
                }
            }
            while(user_choice <0  || user_choice>1);
            // set run again to the value of run
            run_again = run;
        }
        // run the program again using do while loop
        while (run_again = true);
    }

// I use private static voids to print the leaf and trunk
    private static void treeLeaf(int leaf_rows, int max, char text,String leaf_color) {
        //the for loop to print the rows of the leaf, i would be the rows it will be printing
        for (int i = 0; i < leaf_rows; i++) {
            // for loop to print the spaces
            for (int j = 0; j < max - i - 1; j++) {
                // j would be smaller than the rows - i - 1 (if the rows are 5, it would print spaces from 4 to 0)
                System.out.print(" ");
            }

            for (int j = 0; j < i * 2 + 1; j++) {
                // for loop to print the leaf
                // i * 2 + 1 = the amount of leaves it will be on each row
                System.out.print(leaf_color + text +ANSI_RESET);
            }
            // new line
            System.out.println();
        }
    }
    private static void treeTrunk(int tree_height, int tree_width,int leaf_rows, char text, String trunk_color) {
        // for loop to print the rows of the tree trunk
        for (int i = 1; i <= tree_height; i++) {
            // while loop to print the spaces before the trunk
            int j = 1;
            // rows - width / 2 for the alignment of the tree
            while (j < leaf_rows - (tree_width/2)) {
                System.out.print(" ");
                j++;
            }
           for(int k = 1; k<=tree_width;k++) {
               // print the tree trunk with corresponding colors
               System.out.print(trunk_color + text + ANSI_RESET);
           }
            System.out.println();
        }
    }
    private static void treeLeafTimes(int tree_times, int tree_leaf_rows, char text, String leaf_color) {
        // for loop to print the leaf pattern a certain of times.
        for (int i = 1; i <= tree_times; i++) {
            treeLeaf(tree_leaf_rows,tree_leaf_rows,text,leaf_color);
        }
    }
}
