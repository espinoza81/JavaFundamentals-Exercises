import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum=0;
        int value;
        while (!numbers.isEmpty()){
            int index = Integer.parseInt(console.nextLine());
            if (index<0) {
                value = numbers.get(0);
                numbers.set(0, numbers.get(numbers.size()-1));
            }
            else if (index>=numbers.size()) {
                value = numbers.get(numbers.size()-1);
                numbers.set(numbers.size()-1, numbers.get(0));
            }
            else {
                value = numbers.get(index);
                numbers.remove(index);
            }
            sum +=value;
            for(int i=0; i<numbers.size(); i++){
                if(numbers.get(i)<=value) numbers.set(i,numbers.get(i)+value );
                else numbers.set(i,numbers.get(i)-value );
            }

        }
        System.out.println(sum);
    }
}
