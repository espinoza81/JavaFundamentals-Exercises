import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, Integer> studentsTotalPoint = new TreeMap<>();
        LinkedHashMap<String, TreeMap<String, Integer>> contests = new LinkedHashMap<>();
        String input;
        while (!"no more time".equals(input = console.nextLine())) {
            String[] command = input.split(" -> ");
            String username = command[0];
            String contest = command[1];
            int points = Integer.parseInt(command[2]);
            contests.putIfAbsent(contest,new TreeMap<>());
            contests.get(contest).putIfAbsent(username,0);
            if(contests.get(contest).get(username)<points) contests.get(contest).put(username,points);
        }
        for (Map.Entry<String, TreeMap<String, Integer>> contest : contests.entrySet()) {
            AtomicInteger index = new AtomicInteger(1);
            System.out.println(contest.getKey() + ": " + contest.getValue().size() + " participants");
            contest.getValue().entrySet().stream()
                    .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                    .forEach(k -> {
                        studentsTotalPoint.putIfAbsent(k.getKey(), 0);
                        studentsTotalPoint.put(k.getKey(), studentsTotalPoint.get(k.getKey()) + k.getValue());
                        System.out.println(index.getAndIncrement() + ". " + k.getKey() + " <::> " + k.getValue());
                    });
        }
        System.out.println("Individual standings:");
        AtomicInteger index = new AtomicInteger(1);
        studentsTotalPoint.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(index.getAndIncrement() + ". " + k.getKey() + " -> " + k.getValue()));
    }
}
