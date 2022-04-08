import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, int[]> dragons = new LinkedHashMap<>();
        LinkedHashMap<String, int[]> dragonsStatsByType = new LinkedHashMap<>();
        int number = Integer.parseInt(console.nextLine());
        for(int i=0; i<number; i++){
            String[] command = console.nextLine().split(" ");
            //{type} {name} {damage} {health} {armor}
            String type = command[0];
            String name = command[1];
            String dragon = type + ", " + name;
            int damage = 45;
            int health = 250;
            int armor = 10;
            if(!"null".equals(command[2])) damage = Integer.parseInt(command[2]);
            if(!"null".equals(command[3])) health = Integer.parseInt(command[3]);
            if(!"null".equals(command[4])) armor = Integer.parseInt(command[4]);
            int[] stats = new int[]{damage, health, armor};
            dragons.putIfAbsent(dragon, stats);
            dragons.put(dragon, stats);
        }
        dragons.forEach((key, value) -> {
            String type = key.split(", ")[0];
            int damage = value[0];
            int health = value[1];
            int armor = value[2];
            dragonsStatsByType.putIfAbsent(type, new int[4]);
            int[] stats = dragonsStatsByType.get(type);
            stats[0] += damage;
            stats[1] += health;
            stats[2] += armor;
            stats[3]++;
            dragonsStatsByType.put(type, stats);
        });
        dragonsStatsByType.forEach((key, value) -> {
            double damage = value[0]*1.00/value[3];
            double health = value[1]*1.00/value[3];
            double armor = value[2]*1.00/value[3];
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, damage, health, armor);
            dragons.entrySet().stream().filter(s-> s.getKey().split(", ")[0].equals(key)).
                    sorted(Comparator.comparing(s -> s.getKey().split(", ")[1])).
                    forEach(s ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", s.getKey().split(", ")[1], s.getValue()[0], s.getValue()[1], s.getValue()[2]));
        });
    }
}
