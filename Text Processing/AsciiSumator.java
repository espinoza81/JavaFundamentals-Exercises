import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char first = console.nextLine().charAt(0);
        char second = console.nextLine().charAt(0);
        String input = console.nextLine();
        int sum = 0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) > first && input.charAt(i) < second) sum += input.charAt(i);
        }
        System.out.println(sum);
    }
}
