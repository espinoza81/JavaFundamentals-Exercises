import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        String regex = "^[^@\\-!:>]*@(?<planet>[A-Z][a-z]*)[^@\\-!:>a-zA-Z]*:(?<population>\\d+)[^@\\-!:>0-9]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldiers>\\d+)[^@\\-!:>0-9]*";
        List<String> attacked = new ArrayList<>();
        int countAttacked = 0;
        List<String> destroyed = new ArrayList<>();
        int countDestroyed = 0;
        for (int i = 0; i < number; i++) {
            String input = console.nextLine();
            int count = input.toLowerCase(Locale.ROOT).replaceAll("[^star]", "").length();
            StringBuilder decryptMessages = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                char toAppend = (char) (input.charAt(j) - count);
                decryptMessages.append(toAppend);
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher messagesMatcher = pattern.matcher(decryptMessages);
            if (messagesMatcher.find()) {
                String planet = messagesMatcher.group("planet");
                String attackType = messagesMatcher.group("attackType");
                switch (attackType){
                    case "A":
                        attacked.add(planet);
                        countAttacked++;
                        break;
                    case "D":
                        destroyed.add(planet);
                        countDestroyed++;
                        break;
                }
            }
        }
        System.out.println("Attacked planets: " + countAttacked);
        attacked.stream().sorted().forEach(s -> System.out.println("-> " + s));
        System.out.println("Destroyed planets: " + countDestroyed);
        destroyed.stream().sorted().forEach(s -> System.out.println("-> " + s));

    }
}
