import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, List<String>> forceBook = new LinkedHashMap<>();
        String input;
        while (!"Lumpawaroo".equals(input = console.nextLine())) {
            String[] command = input.split(" \\| | -> ");
            boolean haveUser = false;
            if (input.contains("|")) {
                String forceSide = command[0];
                String forceUser = command[1];

                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        haveUser = true;
                        break;
                    }
                }
                if(haveUser) continue;
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(forceUser);
            } else {
                String forceUser = command[0];
                String forceSide = command[1];
                String haveSideS = "";
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        haveUser = true;
                        haveSideS = entry.getKey();
                        break;
                    }
                }
                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                if (haveUser) {
                    List<String> forceUserArray = forceBook.get(haveSideS);
                    forceUserArray.remove(forceUser);
                    forceBook.put(haveSideS, forceUserArray);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());
                for (String name : entry.getValue()) System.out.printf("! %s%n", name);
            }
        }
    }
}
