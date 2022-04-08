import java.util.*;

public class Ranking {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> candidates = new TreeMap<>();
        String input;
        while (!"end of contests".equals(input = console.nextLine())) {
            String[] command = input.split(":");
            String contest = command[0];
            String password = command[1];
            contests.put(contest, password);
        }
        while (!"end of submissions".equals(input = console.nextLine())) {
            String[] command = input.split("=>");
            String contest = command[0];
            String password = command[1];
            String username = command[2];
            int points = Integer.parseInt(command[3]);
            if(contests.containsKey(contest) && contests.get(contest).equals(password)){
                candidates.putIfAbsent(username, new LinkedHashMap<>());
                candidates.get(username).putIfAbsent(contest,0);
                if(candidates.get(username).get(contest)<points) candidates.get(username).put(contest, points);
            }
        }
        String bestCandidate="";
        int bestTotalPoints=0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> candidate : candidates.entrySet()) {
            int totalPoints = candidate.getValue().values().stream().mapToInt(i -> i).sum();
            if(totalPoints>bestTotalPoints){
                bestTotalPoints = totalPoints;
                bestCandidate = candidate.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n",bestCandidate,bestTotalPoints);
        System.out.println("Ranking: ");
        for (Map.Entry<String, LinkedHashMap<String, Integer>> candidate : candidates.entrySet()) {
            System.out.println(candidate.getKey());
            candidate.getValue().entrySet().stream()
                    .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                    .forEach(k -> System.out.println("#  "+ k.getKey() + " -> " + k.getValue()));
        }
    }
}
