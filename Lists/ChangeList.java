import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command;
        while (!"end".equals(command = console.nextLine())) {
            String[] splitCommand = command.split(" ");
            switch (splitCommand[0]){
                case "Delete":
                    numbers.removeIf(n -> n==Integer.parseInt(splitCommand[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(splitCommand[2]), Integer.parseInt(splitCommand[1]));
                    break;
            }

        }
        for (Integer n : numbers) {
            System.out.printf("%d ", n);
        }
    }
}
