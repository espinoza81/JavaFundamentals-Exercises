import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+[.\\-_]?[a-zA-Z0-9]*@[a-z-]+.?[a-z]+[.][a-z]+");
        Matcher emailMatcher = pattern.matcher(input);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }
    }
}
