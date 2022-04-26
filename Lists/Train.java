import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> passengersInWagon = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxPassengersForWagon = Integer.parseInt(console.nextLine());
        String command;
        while (!"end".equals(command = console.nextLine())) {
            if (command.contains("Add")) {
                passengersInWagon.add(Integer.valueOf(command.replaceAll("[^0-9]", "")));
            } else {
                for (int i = 0; i < passengersInWagon.size(); i++) {
                    if (passengersInWagon.get(i) + Integer.parseInt(command) <= maxPassengersForWagon) {
                        passengersInWagon.set(i, passengersInWagon.get(i) + Integer.parseInt(command));
                        break;
                    }
                }
            }
        }
        for (Integer n : passengersInWagon) {
            System.out.printf("%d ", n);
        }

    }
}
