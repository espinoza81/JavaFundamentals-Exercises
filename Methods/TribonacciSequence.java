import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        printTribonacci(number);
    }

    private static void printTribonacci(int number) {
        List<Integer> tribonacci = new ArrayList<>();
        if(number >= 1) tribonacci.add(1);
        if(number >= 2) tribonacci.add(1);
        if(number >= 3) tribonacci.add(2);
        if(number >= 4) {
            for (int i=4; i<=number; i++){
                tribonacci.add(sumOfTree(tribonacci.get(i-4), tribonacci.get(i-3), tribonacci.get(i-2)));
            }
        }
        for (Integer integer : tribonacci) {
            System.out.printf("%d ", integer);
        }
    }

    private static Integer sumOfTree(Integer integer, Integer integer1, Integer integer2) {
        return integer+integer1+integer2;
    }
}
