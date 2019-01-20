import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class GuessTheMovie {

    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game();
        File file = new File("movies.txt");
        String movieName = game.getRandomMovie(file);
        String cryptedString = game.hideString(movieName);
        System.out.println(cryptedString);
        int count = 10;
        Scanner scanner = new Scanner(System.in);
        char [] correctLetters = cryptedString.toCharArray();
        char [] movieLetters = movieName.toCharArray();
        while (count > 0)
        {
            System.out.println("Guess a letter you have (" + count + ") guesses left");
            String s = scanner.nextLine();
            int i = movieName.indexOf(s);
            char ch = 0;
            try {
                ch = s.charAt(0);
            }catch (Exception ex){
                System.out.println("Please enter only letter");
            }
            String nameGuessed = "";
            if (i >= 0) {
                for (int x = 0; x < movieLetters.length; x++){
                    if (movieLetters[x] == ch){
                        correctLetters[x] = movieLetters[x];
                    }
                }
                nameGuessed = new String(correctLetters);
                System.out.println(nameGuessed);
                if (game.checkWon(correctLetters)){
                    System.out.println("You have Won!");
                    break;
                }
            }else{
                count --;
                if(count == 0 ){
                    System.out.println("Out of guesses, GAME OVER!");
                    System.exit(0);
                }else {
                    System.out.println("WRONG! There is no letter '" + s + "' in the movie name!");
                    System.out.println("You have guessed (" + count + ") wrong letters!  try again.");
                    nameGuessed = new String(correctLetters);
                    System.out.println(nameGuessed);
                }
            }
        }
    }
}
