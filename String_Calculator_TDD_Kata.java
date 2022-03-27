import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class String_Calculator_TDD_Kata {
    public static void main(String[] args) {
        // Condition holds true till
        // there is character in a string
        try {
            File file = new File("cases.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null) {
                System.out.println("Input   :" + st);
                System.out.println("Output   :" + add(st));
            } // Print the string
            br.close();
        } catch (Exception e) {
            // "" Condition
            e.printStackTrace();
        }

    }

    static int add(String numbers) {
        // Conditions
        String delimiter = ",";
        String[] preNumbersArray = numberSpliter(numbers, delimiter);
        int[] numbersArray = Arrays.stream(preNumbersArray).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbersArray).sum();
    }

    static String[] numberSpliter(String numbers, String delimiter) {
        String[] redifinedNumbers = new String[] {};

        try {
            if (numbers.length() == 0) {
                return new String[] {};
            }
            // This is the condition for new line
            if (numbers.contains("n")) {
                if (numbers.charAt(numbers.length() - 1) == 'n') {
                    System.out.println("Wrong Input");
                    return new String[] {};
                }
                numbers = numbers.replaceAll("n", "");

                numbers = numbers.replaceAll("\\\\", ",");

            }

            redifinedNumbers = numbers.split(delimiter);
        } catch (Exception e) {
            // Conditions
            // New Line Condition

        }
        return redifinedNumbers;

    }

}

class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}