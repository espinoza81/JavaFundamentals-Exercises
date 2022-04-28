import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        isCharacters6To10(input);
    }

    private static void isCharacters6To10(String input) {
        boolean notValid=false;
        if (input.length() < 6 || input.length() > 10 ) {
            System.out.println("Password must be between 6 and 10 characters");
            notValid = true;
        }
        consistsLettersDigits(input, notValid);
    }

    private static void consistsLettersDigits(String input, boolean notValid) {
        if (!input.matches("\\w+") || input.replaceAll("\\D", "").length()==input.length()) {
            System.out.println("Password must consist only of letters and digits");
            notValid = true;
        }
        haveAtLeastTwoDigits(input, notValid);

    }

    private static void haveAtLeastTwoDigits(String input, boolean notValid) {
        if (input.replaceAll("\\D", "").length()<2)  {
            System.out.println("Password must have at least 2 digits");
            notValid = true;
        }
        if(!notValid) System.out.println("Password is valid");
    }
}
