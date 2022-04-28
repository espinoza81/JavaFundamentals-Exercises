import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String number;
        while (!"END".equals(number = console.nextLine())) {
            boolean output = isPalindrome(number);
            System.out.println(output);
        }
    }

    private static boolean isPalindrome(String number) {
        for (int i=0; i<=number.length()/2; i++){
            if(!(number.charAt(i)==number.charAt(number.length()-1-i))) return false;
        }
        return true;
    }
}
