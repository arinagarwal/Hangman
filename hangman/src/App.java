import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class App {
    public static void main(String[] args) throws Exception  {
        //welcome text for the game
        System.out.println("Welcome to hangman! Guess the word by letter by letter! If not watch the man hang!");
        System.out.println("Start by guessing a letter!");

        //creates file of all words that could be used in the game
        File dictionary = new File("/Users/arin/Desktop/Coding Projects/hangman/src/usa.txt");
        Scanner textScanner = new Scanner(dictionary);
        //scanner for user input
        Scanner input = new Scanner(System.in);

        

        //creates arrayList filled with words from dictionary
        ArrayList<String> words = new ArrayList<>();

        while(textScanner.hasNextLine())
        {
            words.add(textScanner.nextLine());
        }

        //creates a string that the game will be played with and charArray for that string

        String s = words.get((int) (Math.random() * words.size()));
        char[] letters = s.toCharArray();

        char[] answer = new char[letters.length];

        ArrayList<Character> wrongGuesses = new ArrayList<>();

        //fills answers with question marks so that they can easily be replaced
        for(int i = 0; i < answer.length;i++)
        {
            answer[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while (!finished)
        {
            
            //enterPressed(input.nextKey);
            System.out.println("**************************");
            
            String StrGuess = input.next();
            //check if guess is a valid input
            while(StrGuess.length() > 1 || Character.isDigit(StrGuess.charAt(0)))
            {
                System.out.println("Error. Input must be a single character that is not a digit");
                StrGuess = input.next();
            }

            StrGuess.toLowerCase();
            char guess = StrGuess.charAt(0);

            //checks if guess is in the answer
            boolean found = false;
            for(int i = 0; i < letters.length; i++)
            {
                if(letters[i] == guess)
                {
                    answer[i] = letters[i];
                    found = true;
                }
            }
            
            if(!found)
            {
                wrongGuesses.add(guess);
                lives--;
                System.out.println("Wrong Letter!");
            }
            
            boolean done = true;
            System.out.println("\n");
            for(int i = 0; i<answer.length;i++)
            {
                if(answer[i] == '?')
                {
                    System.out.print(" _ ");
                    done = false;
                }
                else
                {
                    System.out.print(" "+ answer[i] + " ");
                }
            }

            System.out.println("\n");

            
            System.out.println("\n" + " Lives Left: " + lives );
            drawHangman(lives);
            System.out.println("\n");
            System.out.println("Your previous guesses are: ");
            for( int i = 0; i < wrongGuesses.size();i++)
            {
                System.out.print(" " + wrongGuesses.get(i));
            }

            System.out.println("\n");
            System.out.println("\n");

            
            if(done)
            {
                System.out.println("Congrats! You found the word!");
                finished = true;

            }

            if(lives <= 0)
            {
                System.out.println("Oh No! You ran out of lives. Game over!");
                finished = true;
                System.out.println("The word was " + s);
            }

        


        }



    }

    public static void drawHangman(int l) {
        if(l == 6) {
         System.out.println("|----------");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 5) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 4) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|    |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 3) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 2) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 1) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   /");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else{
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   /|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
       }

       public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

   public static void enterPressed (java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            clearScreen();
         }
        }
}
