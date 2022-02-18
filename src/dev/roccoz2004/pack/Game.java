package dev.roccoz2004.pack;
import java.util.Scanner;

public class Game {
    String[] list = {"apple", "air", "bank", "basket", "cake", "candle", "dream", "duck", "earth", "egg", "fact", "freedom", "garden", "goat", "heaven", "house", "job", "key", "ladder", "number", "orange", "peace", "queen", "radio", "sugar", "table", "uncle", "village", "window", "yard", "zero"};
    int random = (int) (Math.random() * list.length);
    String word = list[random];
    int wordLength = word.length() + 1;
    int tries = 10;
    String answer;

    public static void ask() {
        Game access = new Game();
        Scanner scan = new Scanner(System.in);
        access.answer = scan.nextLine();
        if (!(access.answer.length() == 1)) {
            System.out.println("Please enter only ONE letter at a time!");
            ask();
        } else if (!access.word.contains(access.answer)) {
            System.out.println("There is no " + access.answer + " in the word");
            access.tries--;
            System.out.println("You have " + access.tries + " tries");
            if (access.tries == 0) {
                System.out.println("YOU LOSE");
            }
        } else {
            String[] wordSplit = access.word.split("");
            for (int i = 0; i < access.word.length(); i++) {
                System.out.print(access.word.charAt(i));
            }
            System.out.println("\n");
            ask();
        }
    }

    public static void main(String[] args) {
        Game access = new Game();
        System.out.println("Lets play Hangman! \nPlease enter only 1 letter.\n");
        int i = 0;
        while (i < access.wordLength) {
            System.out.print("_");
            i++;
        }
        System.out.println("\n");
        System.out.println("You have " + access.tries + " tries");
        ask();
    }
}