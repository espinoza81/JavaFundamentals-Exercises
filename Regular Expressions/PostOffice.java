import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String firstPart = input.split("\\|")[0];
        String secondPart = input.split("\\|")[1];
        String thirdPart = input.split("\\|")[2];

        Pattern capital = Pattern.compile("(#|\\$|%|\\*|&)(?<capital>[A-Z]+)\\1");
        Matcher capitalMatcher = capital.matcher(firstPart);
        String capitalLetters = "";
        if(capitalMatcher.find()){
            capitalLetters = capitalMatcher.group("capital");
        }
        HashMap<String, Integer> letterCount = new LinkedHashMap<>();
        for (int i=0; i<capitalLetters.length(); i++){
            letterCount.put(String.valueOf(capitalLetters.charAt(i)), 0);
        }

        Pattern lengthPattern = Pattern.compile("(?<ascii>([7-8]\\d)|(90)|(6[5-9])):(?<length>\\d{2})");
        Matcher lengthMatcher = lengthPattern.matcher(secondPart);
        while (lengthMatcher.find()) {
            String ascii = Character.toString(Integer.parseInt(lengthMatcher.group("ascii")));
            int length = Integer.parseInt(lengthMatcher.group("length"));
            letterCount.computeIfPresent(ascii, (k, v) -> length);
        }
        letterCount.forEach((k,v) -> {
            Pattern word = Pattern.compile("(?<!\\S)" + k + "\\S{" + v + "}(?!\\S)");
            Matcher wordMatcher = word.matcher(thirdPart);
            if(wordMatcher.find())  System.out.println(wordMatcher.group());
        });
    }
}
