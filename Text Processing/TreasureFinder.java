import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] keys = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input;
        while (!"find".equals(input= console.nextLine())){
            StringBuilder decryptMessages = new StringBuilder();
            for(int i=0; i<input.length(); i++){
                char toAppend = (char) (input.charAt(i) - keys[i%keys.length]);
                decryptMessages.append(toAppend);
            }
            String treasure = decryptMessages.substring(decryptMessages.indexOf("&")+1, decryptMessages.lastIndexOf("&"));
            String coordinates = decryptMessages.substring(decryptMessages.indexOf("<")+1, decryptMessages.lastIndexOf(">"));
            System.out.printf("Found %s at %s%n", treasure, coordinates);
        }
    }
}
