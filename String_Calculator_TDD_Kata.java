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
        // Conditions of prechecking
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains("-")) {
            throw new IllegalArgumentException("Negatives not allowed");
        }

        // Logic
        String delimiter = configureDelimiter(numbers);
        if (delimiter != ",") {
            numbers = numbers.substring(3, numbers.length());
        }
        String[] preNumbersArray = numberSpliter(numbers, delimiter);
        int[] numbersArray = Arrays.stream(preNumbersArray).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(numbersArray).sum();
    }

    static String configureDelimiter(String x) {
        String delimiter = ",";
        if (x.startsWith("//")) {
            delimiter = x.substring(2, 3);

        }
        return delimiter;
    }

    static String[] numberSpliter(String numbers, String delimiter) {
        String[] redifinedNumbers = new String[] {};

        try {
            // This is the condition for new line
            if (numbers.contains("n")) {
                if (numbers.charAt(numbers.length() - 1) == 'n') {
                    System.out.println("Wrong Input");
                    return new String[] {};
                }
                numbers = numbers.replaceAll("n", "");

                numbers = numbers.replaceAll("\\\\", delimiter);

            }
            // Handling meta characters
            try {
                redifinedNumbers = numbers.split(delimiter);

            } catch (Exception e) {
                redifinedNumbers = numbers.split("\\" + delimiter);

            }
        } catch (Exception e) {
            // Conditions
            // New Line Condition

        }
        return redifinedNumbers;

    }

}
