import java.util.Arrays;
import java.util.Scanner;

public class String_Calculator_TDD_Kata {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(add(sc.nextLine()));

        sc.close();
    }

    static int add(String numbers) {
        // Conditions
        try {
            String delimiter = ",";
            int[] numbersArray = Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).toArray();
            return Arrays.stream(numbersArray).sum();
        } catch (Exception e) {
            if (numbers.equals("")) {
                return 0;
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        }

    }

}
