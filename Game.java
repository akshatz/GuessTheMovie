import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Game {
    private int countLines(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int linesNumber = 0;
        while (scanner.hasNextLine()) {
            linesNumber++;
            if (scanner.nextLine().equals("")) {
                break;
            }
        }
        return linesNumber;
    }
    public String getRandomMovie(File file) throws FileNotFoundException {
        int moviesCount = countLines(file);
        int i = 0;
        String[] moviesList = new String[moviesCount];
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String movie = scanner.nextLine();
            moviesList[i] = movie;
            i++;
        }
        int randomNumber = (int) (Math.random() * (moviesCount - 1)) + 1;
        return moviesList[randomNumber];
    }
    public String hideString(String string) {
        char[] stringChars = string.toCharArray();
        String hiddenString = "";
        for (int i = 0; i < stringChars.length; i++) {
            if (stringChars[i] == ' ') {
                stringChars[i] = ' ';
            } else {
                stringChars[i] = '*';
            }
            hiddenString += stringChars[i];
        }
        return hiddenString;
    }
    public boolean checkWon(char[] letters) {
        boolean isWon= false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '*') {
                isWon = false;
                break;
            } else {
                isWon = true;
            }
        }
        return isWon;
    }
}