import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class String_Calculator_TDD_Kata {
    public static void main(String[] args) {
        // Condition holds true till
        // there is character in a string
        try {
            File file = new File("Inputs.txt");
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

        String delimiter = configureDelimiter(numbers);
        numbers = prebake(numbers, delimiter);
        String[] preNumbersArray = numberSpliter(numbers, delimiter);
        checkNegative(preNumbersArray);

        // Logic
        try {
            int[] numbersArray = Arrays.stream(preNumbersArray).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(numbersArray).sum();
        } catch (Exception e) {
            System.out.println("Error: " + "Wrong Input");
            return 0;
        }
    }

    static String configureDelimiter(String x) {
        String delimiter = ",";
        if (x.startsWith("//")) {
            delimiter = x.charAt(2) + "";

        }
        return delimiter;
    }

    static String[] numberSpliter(String numbers, String delimiter) {
        String[] redifinedNumbers = new String[] {};
        // Handling meta characters
        try {

            redifinedNumbers = Arrays.stream(numbers.split(delimiter))
                    .filter(x -> x.equals("") == false)
                    .filter(x -> x.contains("//") == false)
                    .toArray(String[]::new);

        } catch (Exception e) {
            redifinedNumbers = numbers.split("\\" + delimiter);
            redifinedNumbers = Arrays.stream(redifinedNumbers).filter(x -> x.equals("") == false)
                    .toArray(String[]::new);
        }
        return redifinedNumbers;

    }

    static void checkNegative(String[] numbersArray) {
        String negativeNumbers = "";
        for (String number : numbersArray) {
            try {
                if (Integer.parseInt(number) < 0) {
                    negativeNumbers += number + ",";
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(
                        "Wrong Input");
            }
        }
        if (negativeNumbers.equals("")) {
            return;
        }
        throw new IllegalArgumentException(
                "negatives not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
    }

    static String prebake(String numbers, String delimiter) {
        if (numbers.isEmpty()) {
            return "0";
        }

        if (numbers.contains("n")) {
            if (numbers.charAt(numbers.length() - 1) == 'n') {
                System.out.println("Wrong Input");
                return "0";
            }
            numbers = numbers.replaceAll("n", "");

            numbers = numbers.replaceAll("\\\\", delimiter);

        }
        if (numbers.contains("\\\n")) {
            numbers = numbers.replaceAll("\\\n", delimiter);
        }
        if (numbers.startsWith("//")) {
            numbers = numbers.substring(2);
        }
        return numbers;

    }

}
