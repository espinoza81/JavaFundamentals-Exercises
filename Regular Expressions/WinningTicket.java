import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().trim().split("\\s*,\\s+");
        Pattern pattern = Pattern.compile("(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*");
        for (String s : input) {
            if(s.length()!=20) {
                System.out.println("invalid ticket");
                continue;
            }
            Matcher ticketMatcher = pattern.matcher(s);
            if(ticketMatcher.find()){
                String match = ticketMatcher.group("match");
                System.out.printf("ticket \"%s\" - %d%s%s%n",
                        s, match.length(), match.charAt(0),
                        (match.length() == 10) ? " Jackpot!" : "");
            }
            else System.out.println("ticket \"" + s + "\" - no match");
        }
    }
}
