import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);
        int[] bombNumber = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = numbers.size()-1; i >= 0 ; i--) {
            if(numbers.get(i)==bombNumber[0]){
                if(bombNumber[1]==0) {
                    numbers.remove(i);
                    continue;
                }
                int start = i+bombNumber[1];
                if (i+bombNumber[1]>=numbers.size()) start = numbers.size()-1;
                int end = i-bombNumber[1];
                if (i-bombNumber[1] < 0) end = 0;
                for (i = start; i>=end; i--) numbers.remove(i);
            }
        }
        long sum=0;
        for (int n : numbers) {
            sum +=n;
        }
        System.out.println(sum);
    }
}
