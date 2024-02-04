import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreInput {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the score (0-100): ");
            int score = scanner.nextInt();

            if (score < 0 || score > 100) {
                throw new UnsupportedOperationException("Score must be in the range of 0-100");
            }

            System.out.println("Entered score: " + score);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
