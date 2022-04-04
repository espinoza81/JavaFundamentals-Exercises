import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        Pattern symbol = Pattern.compile("(?<symbol>[^\\d]+)(?<number>\\d+)");
        Matcher symbolFind = symbol.matcher(input);
        StringBuilder messages = new StringBuilder();
        StringBuilder uniqueSymbols = new StringBuilder();
        while (symbolFind.find()) {
            String rageQuit = symbolFind.group("symbol").toUpperCase(Locale.ROOT);
            int number = Integer.parseInt(symbolFind.group("number"));
            if (number==0) continue;
            for (int i=0; i<rageQuit.length(); i++){
                char singleSymbol = rageQuit.charAt(i);
                if(uniqueSymbols.indexOf(String.valueOf(singleSymbol))==-1) uniqueSymbols.append(singleSymbol);
            }
            messages.append(rageQuit.repeat(Math.max(0, number)));
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.length());
        System.out.println(messages);
    }
}
