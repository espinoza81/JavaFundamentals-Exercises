import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> playerOne = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (playerOne.size()>0 && playerTwo.size()>0){
            if(playerOne.get(0).equals(playerTwo.get(0))){
                playerOne.remove(0);
                playerTwo.remove(0);
            }
            else if(playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            }
            else {
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            }
        }
        long sum=0;
        String winPlayer;
        if(playerOne.size()>0) {
            winPlayer = "First";
            for (int n : playerOne) {
                sum += n;
            }
        }
        else {
            winPlayer = "Second";
            for (int n : playerTwo) {
                sum += n;
            }
        }
        System.out.printf("%s player wins! Sum: %d", winPlayer, sum);
    }
}
