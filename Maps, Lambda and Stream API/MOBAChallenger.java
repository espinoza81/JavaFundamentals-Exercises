import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> pool = new TreeMap<>();
        String input;
        TreeMap<String, Integer> players = new TreeMap<>();

        while (!"Season end".equals(input = console.nextLine())) {
            String[] command = input.split(" -> | vs ");
            if (input.contains(" -> ")) {
                String player = command[0];
                String position = command[1];
                int skill = Integer.parseInt(command[2]);
                pool.putIfAbsent(player, new TreeMap<>());
                pool.get(player).putIfAbsent(position, 0);
                if (pool.get(player).get(position) < skill) {
                    players.computeIfPresent(player, (k, v) -> players.get(player) - pool.get(player).get(position) + skill);
                    pool.get(player).put(position, skill);
                }
                players.putIfAbsent(player, skill);
            } else {
                String playerOne = command[0];
                String playerTwo = command[1];
                if (pool.containsKey(playerOne) && pool.containsKey(playerTwo)) {
                    pool.get(playerOne).forEach((key1, value1) -> pool.get(playerTwo).forEach((key, value) -> {
                        if (key.equals(key1)) {
                            int demoted = players.get(playerOne).compareTo(players.get(playerTwo));
                            if (demoted < 0) {
                                pool.remove(playerOne);
                                players.remove(playerOne);
                            }
                            if (demoted > 0) {
                                pool.remove(playerTwo);
                                players.remove(playerTwo);
                            }
                        }
                    }));
                }
            }
        }

        players.entrySet().stream().sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> {
                    System.out.println(k.getKey() + ": " + k.getValue() + " skill");
                    pool.get(k.getKey()).entrySet().stream()
                            .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                            .forEach(s -> System.out.println("- " + s.getKey() + " <::> " + s.getValue()));
                });
    }
}
