import java.util.Arrays;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] index = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String messages = console.nextLine();
        String output="";
        for (int n : index) {
            int sum = 0;
            String currentNumber = String.valueOf(n);
            for (int j = 0; j < currentNumber.length(); j++) {
                int digit = Integer.parseInt(String.valueOf(currentNumber.charAt(j)));

                sum += digit;
            }
            int tempIndex = sum % messages.length();
            output += messages.charAt(tempIndex);
            messages = messages.substring(0, tempIndex) + messages.substring(tempIndex + 1);
        }
        System.out.println(output);
    }
}
