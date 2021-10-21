/*
* Program Name: Substitution Cipher
* Created on: Sept. 16
* Name: Jerry Z
* Purpose: To make the program encrypt or decrypt according to a key depending on the user input 
*/
import java.io.*;
import java.util.*;
/**
 * @author Jerry
 */
public class Main {
    static String plainText = "plaintext.txt";
    static String cipherText = "ciphertext.txt";
    static String userFile = "Nothing here";
    static String userEmail = "";
    public static void main(String[] args) throws IOException{

        Scanner input = new Scanner(System.in);
        //read and store key
        String[] rawKey = readKey();
        //ask user to encrypt or decrypt
        boolean userInput = false;
        while(!userInput) {
            System.out.println("Welcome to Jerry's cipher machine! \n Please enter 0 if you want to encrypt \n enter 1 if you want to decrypt");
            
            int userDecision = input.nextInt();
            
            if (userDecision == 0) {
                String[] userText = readText(plainText);
                String[] encryptText = encrypt(userText, rawKey);
                writeText(cipherText, encryptText);
                userFile = cipherText;
                userInput = true;
            } else if (userDecision == 1) {
                String[] userText = readText(cipherText);
                String[] decryptText = decrypt(userText, rawKey);
                writeText(plainText, decryptText);
                userFile = plainText;
                userInput = true;
            } else {
                System.out.println("Sorry, you have entered an invalid input. Please input 0 if you want to encrypt " +
                        "\n enter 1 if you want to decrypt");
                userInput = true;
            }
        }
        boolean emailChoice = false;
        while(!emailChoice) {
             System.out.println("Program Completed, would you like to have your encrypted / decrypted file sent through email? \n Please input 0 for no, input 1 for yes");
            
            int userChoice = input.nextInt();
            
            if(userChoice == 0){
                System.out.println("Thank you for using CipherApp!");
                emailChoice = true;
            }
            else if(userChoice == 1){
                System.out.println("Please enter your email address:");
                userEmail = input.next();
                Email.sendEmail();
                emailChoice = true;
            }
            else{
                emailChoice = false;
            }
        }
    }
    /**
    readKey
     Purpose: Read Key From A file and store the keys into a String array
     @Param: none
     @Return: String[]
     */
    public static String[] readKey() throws IOException{
        try{
            File key = new File("key.txt");
            key.createNewFile();
        }
        catch(IOException FileNotFoundException){
        }
        String[] key = new String[68];
        try {
            FileReader fr = new FileReader("key.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                key = line.trim().split(" ");
                line = br.readLine();
            }
            br.close();
        }
        catch(Exception ex){
            System.out.println("Sorry! Something went wrong while reading the file.");
        }

        return key;
    }

    /**
     readText
     Purpose: Read text file and store the elements of the text file depending on the user's choice
     @Param: String
     @Return: String[]
     */
    public static String[] readText(String filePath) throws IOException{
        // Detecting empty files
        // from: https://stackoverflow.com/questions/7190618/most-efficient-way-to-check-if-a-file-is-empty-in-java-on-windows
        try{
            File userFile = new File(filePath);
            userFile.createNewFile();
            if(userFile.length() == 0){
                System.out.println("Seems like the file is empty, please enter the content you want to encrypt or decrypt.");
                Scanner extraFile = new Scanner(System.in);
                String userInput = extraFile.nextLine();
                return new String[]{userInput};
            }
        }
        catch(IOException FileNotFoundException){
        }
        ArrayList<String> textList = new ArrayList<>();;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                textList.add(line);
                line = br.readLine();
            }
            br.close();
        } catch(Exception ex){
            System.out.println("Something went wrong when reading the file");
        }
        String[] textLines = new String[textList.size()];
        textLines = textList.toArray(textLines);
        return textLines;
    }

    /**
     encrypt
     Purpose: Encrypt the content from the user file according to the key
     @Param: String[], String[]
     @Return: String[]
     */
    public static String[] encrypt(String[] text, String[] key){

        for(int i = 0; i<text.length; i++){
            char[] textChars = text[i].toCharArray();
            for(int j = 0; j<textChars.length; j++) {
                for (String k : key) {
                    if (k.charAt(0) == textChars[j]) {
                        textChars[j] = k.charAt(1);
                        break;
                    }
                }
            }
            text[i] = String.valueOf(textChars);
        }
        return text;
    }
    /**
     decrypt
     Purpose: Decrypt the content from the user file according to the alphabet
     @Param: String[], String[]
     @Return: String[]
     */

    public static String[] decrypt(String[] text, String[] key){

        for(int i = 0; i<text.length; i++){
            char[] textChars = text[i].toCharArray();
            for(int j = 0; j<textChars.length; j++) {
                for (String k : key) {
                    if (k.charAt(1) == textChars[j]) {
                        textChars[j] = k.charAt(0);
                        break;
                    }
                }
            }
            text[i] = String.valueOf(textChars);
        }

        return text;
   }
    /**
     encrypt
     Purpose: write the encrypted or decrypted content back into the file depending on the user's choice
     @Param: String, String[]
     @Return: String[]
     */
    public static void writeText(String filePath, String[] text) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for (String s : text) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        } catch (Exception ex){
            System.out.println("Sorry, something went wrong when writing the file");
        }
    }
}
