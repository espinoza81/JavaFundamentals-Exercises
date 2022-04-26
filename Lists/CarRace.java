import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> stepOfRace = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double leftCar=countRace(stepOfRace);
        Collections.reverse(stepOfRace);
        double rightCar=countRace(stepOfRace);
        String winner = "left";
        if(rightCar<leftCar) winner="right";
        System.out.printf("The winner is %s with total time: %.1f", winner, Math.min(leftCar, rightCar));
    }

    private static double countRace(List<Integer> stepOfRace) {
        double sum=0;
        for(int i=0; i<stepOfRace.size()/2; i++){
            if(stepOfRace.get(i)==0) sum *= 0.8;
            else sum += stepOfRace.get(i);
        }
        return sum;
    }
}
