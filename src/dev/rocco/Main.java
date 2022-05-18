package dev.rocco;// Hangman game

import java.util.Scanner;

class Main {
    // the array of word strings
    public static String[] list = {"apple", "air", "bank", "basket", "cake", "candle", "dream", "duck", "earth", "egg", "fact", "freedom", "garden", "goat", "heaven", "house", "job", "key", "ladder", "number", "orange", "peace", "queen", "radio", "sugar", "table", "uncle", "village", "window", "yard", "zero"};
    // create Scanner input
    static Scanner input;

    public static void main(String[] args) {
        // play hangman game
        hangman();
    }

    public static void hangman() {
        input = new Scanner(System.in);

        // begin setup
        System.out.println("Welcome to HANGMAN!\n");
        initialize();

    }

    public static void initialize() {
        // randomizes word array and picks one word
        int Ran_num = (int) (Math.random() * list.length);

        // takes input of the word
        String word = (list[Ran_num]);
        word = word.toUpperCase();

        // To show the word in underscores
        String hiddenWord = word.replaceAll("[A-Z]", "_ ");

        // play the game
        startGame(word, hiddenWord, menu());
    }

    public static int menu() {
        int tries = 0;
        System.out.println("Would you like to play on EASY, MEDIUM, or HARD difficulty?");
        System.out.println("Enter 'E', 'M', or 'H' to select difficulty.");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("E")) {
            System.out.println("EASY MODE (+5 tries)");
            tries = 5;
        } else if (answer.equalsIgnoreCase("M")) {
            System.out.println("MEDIUM MODE (+2 tries)");
            tries = 2;
        } else if (answer.equalsIgnoreCase("H")) {
            System.out.println("HARD MODE (No extra tries)");
        } else {
            menu();
        }
        return tries;
    }

    public static void startGame(String word, String hiddenWord, int diff) {
        // total chances
        int numChances = word.length() + diff;

        // total guesses
        int guess_ = 0;

        // number of wrong guesses
        int wrong = 0;

        // for each guess
        String answer;

        // stores the guessed letter
        char letter;

        // stores if the letter was already guessed
        boolean guessescontainsguess;
        String guesses = "";
        boolean guessinword;

        System.out.println("You have " + numChances + " guesses.");

        // while loop starts here
        while (wrong < numChances && hiddenWord.contains("_")) {

            System.out.println(hiddenWord + "\n");
            int temp = numChances - wrong;
            if (wrong != 0) {

                // for picture 1
                System.out.println("You have " + temp + " guesses left.");
            }

            System.out.println("Your Guess: ");

            // takes guess input
            answer = input.nextLine();
            if (answer == "") {
                answer = " ";
            }

            // converts to uppercase
            // for comparison
            answer = answer.toUpperCase();

            // gets the first letter
            // as guessed letter
            letter = answer.charAt(0);

            guessescontainsguess = (guesses.indexOf(letter)) != -1;

            // stores every letter
            // guessed in guesses
            guesses += letter;

            // converts to uppercase for
            // comparison
            letter = Character.toUpperCase(letter);
            System.out.println();

            // if letter already guessed
            if (guessescontainsguess == true) {

                // already guessed letter
                System.out.println("You ALREADY guessed " + letter + ". \n");
            }

            // guessed letter is in the word
            guessinword = (word.indexOf(letter)) != -1;

            // if statement begins
            if (guessinword == true) {

                // print the letter
                System.out.println(
                        letter + " is present in the word.");
                System.out.print("\n");

                // find the letter positions
                // replace dashes with those
                // letter at valid positions
                for (int position = 0; position < word.length(); position++) {

                    // guessed letter is equal to
                    // letter at position in word
                    // and hiddenWord has previously does not
                    // have that letter
                    if (word.charAt(position) == letter
                            && hiddenWord.charAt(position) != letter) {

                        hiddenWord = hiddenWord.replaceAll("_ ", "_ ");
                        String word2;
                        word2 = hiddenWord.substring(0, position) + letter + hiddenWord.substring(position + 1);
                        word2 = word2.replaceAll("_ ", "_ ");
                        hiddenWord = word2;
                    }
                }
            }

            // if statement ends, else if begins
            else {

                // prints
                // wrong = wrong + 1, after every
                // wrong answer
                System.out.println(letter + " is not present in the word.");
                wrong++;
            }

            // guess_ = guess_ + 1, after every
            // attempt
            guess_++;

        } // while loop ends

        // if the lifelines finishes
        if (wrong == numChances) {
            System.out.println("\nYOU LOSE!");
        } else {
            // when solved
            System.out.print("The word is: " + hiddenWord + "\nWell Played, you did it!!");
        }
    }
}
