import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command;
        while (!"End".equals(command = console.nextLine())) {
            String[] splitCommand = command.split("\\s+");
            switch (splitCommand[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(splitCommand[1]));
                    break;
                case "Insert":
                    if(Integer.parseInt(splitCommand[2])<0 || Integer.parseInt(splitCommand[2]) >= numbers.size())  System.out.println("Invalid index");
                    else   numbers.add(Integer.parseInt(splitCommand[2]), Integer.parseInt(splitCommand[1]));
                    break;
                case "Remove":
                    if(Integer.parseInt(splitCommand[1])<0 ||Integer.parseInt(splitCommand[1]) >= numbers.size())  System.out.println("Invalid index");
                    else numbers.remove(Integer.parseInt(splitCommand[1]));
                    break;
                case "Shift":
                    if (splitCommand[1].equals("left")) {
                        for (int i = 0; i < Integer.parseInt(splitCommand[2]); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    }
                    else {
                        for (int i = 0; i < Integer.parseInt(splitCommand[2]); i++) {
                            numbers.add(0, numbers.get(numbers.size()-1));
                            numbers.remove(numbers.size()-1);
                        }
                    }
                    break;
            }
        }
        for (Integer n : numbers) {
            System.out.printf("%d ", n);
        }
    }
}
