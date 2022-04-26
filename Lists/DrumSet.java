import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double savings = Double.parseDouble(console.nextLine());
        List<Integer> numbers = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        String hitPower;
        while (!"Hit it again, Gabsy!".equals(hitPower= console.nextLine())){
            int hitPowerInt = Integer.parseInt(hitPower);
            for(int i=0; i<numbersCopy.size(); i++){
                int restPower = numbersCopy.get(i)-hitPowerInt;
                if (restPower>0) numbersCopy.set(i, restPower);
                else if(savings>=numbers.get(i)*3) {
                    numbersCopy.set(i, numbers.get(i));
                    savings -= numbers.get(i)*3;
                }
                else {
                    numbersCopy.remove(i);
                    numbers.remove(i);
                    i--;
                }
            }
        }
        System.out.println(numbersCopy.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
