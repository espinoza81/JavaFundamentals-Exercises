import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int commandCount = Integer.parseInt(console.nextLine());
        List<String> peopleParty = new ArrayList<>();
        for (int i = 0; i < commandCount; i++) {
            String command = console.nextLine();
            String name = command.substring(0, command.indexOf(' '));

            if (command.contains("not")) {
                if(!peopleParty.removeIf(n -> n.equals(name))) System.out.printf("%s is not in the list!%n", name);
            }
            else if(peopleParty.contains(name)) System.out.printf("%s is already in the list!%n", name);
            else peopleParty.add(name);
        }
        for (String names : peopleParty) {
            System.out.println(names);
        }
    }
}
