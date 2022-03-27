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
                System.out.println(st);
                System.out.println(add(st));
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
        int[] numbersArray = Arrays.stream(numberSpliter(numbers, delimiter)).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbersArray).sum();
    }

    static String[] numberSpliter(String numbers, String delimiter) {
        String[] redifinedNumbers = new String[] {};
        try {
            if (numbers.length() == 0) {
                return new String[] {};
            }
            redifinedNumbers = numbers.split(delimiter);
        } catch (Exception e) {
            // Conditions

            e.printStackTrace();
        }
        return redifinedNumbers;
    }

}
