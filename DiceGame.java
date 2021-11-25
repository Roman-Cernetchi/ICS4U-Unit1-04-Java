/*
 * This program generates a random number between one and six,
 * then gets the user to guess it.
 *
 * @author  Roman Cernetchi
 * @version 1.0
 * @since   2021-11-23
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
* This class runs the Dice Game program.
*/
final class DiceGame {

    /**
    * This constant represents the lowest number in the randomizer.
    */
    public static final int LOWEST_NUM = 1;
    /**
    * This constant represents the highest number in the randomizer.
    */
    public static final int HIGHEST_NUM = 6;

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private DiceGame() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Generates a random number.
    *
    * @param lowestNum It is the lowest value that the randomizer can produce.
    *
    * @param highestNum is the highest value that the randomizer can produce.
    *
    * @return This function returns the random number.
    *
    */
    private static int randomNum(
            final int lowestNum, final int highestNum) {
        return new Random().nextInt(highestNum) + lowestNum;
    }

    /**
    * Checks if the user's guess is higher or lower than the random number.
    *
    * @param guess It is the user's latest guess.
    *
    * @param randomNum It is the generated random number that the user guesses.
    *
    * @return This function returns whether the user's guess is too high or too
    *     low.
    *
    */
    private static String tooHighOrLow(
            final int guess, final int randomNum) {

        final String highOrLow;

        if (guess > randomNum) {
            highOrLow = "Your guess is too high!";
        } else {
            highOrLow = "Your guess is too low!";
        }

        return highOrLow;
    }

    /**
     * Calculates and outputs the energy generated from a certain amount of
     * mass.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the user input.
     * @throws NumberFormatException if the user input cannot be turned into
     *     an integer.
     * */
    public static void main(final String[] args)
            throws NumberFormatException, IOException {

        final int randomNum = randomNum(LOWEST_NUM, HIGHEST_NUM);
        int numOfTries = 0;

        String guessString;
        int guess;

        while (true) {
            try {
                // Input
                System.out.print("Guess a number between 1 and 6: ");

                // Gathers input
                guessString = new BufferedReader(
                        new InputStreamReader(System.in)
                ).readLine();

                guess = Integer.parseInt(guessString);

                if (guess == randomNum) {
                    numOfTries++;
                    System.out.println("\nCorrect!");
                    System.out.println("It took a total of "
                                          + numOfTries + " tries.");
                    break;
                } else {
                    numOfTries++;
                    System.out.println(tooHighOrLow(guess, randomNum));
                    System.out.println("Lets try that again.");
                }

            } catch (IOException | NumberFormatException exception) {
                // Error check
                System.out.println("Please enter a correct input.\n");
            }

        }

        System.out.println("\nDone.");
    }

}
