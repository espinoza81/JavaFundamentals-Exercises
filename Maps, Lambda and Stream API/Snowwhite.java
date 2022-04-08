import java.util.LinkedHashMap;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, Integer> dwarfs = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> dwarfsHatCount = new LinkedHashMap<>();
        String input;
        while (!"Once upon a time".equals(input = console.nextLine())) {
            String[] command = input.split(" <:> ");
            String name = command[0];
            String hatColor = command[1];
            String dwarf = hatColor + ", " + name;
            int physics = Integer.parseInt(command[2]);
            if(dwarfs.putIfAbsent(dwarf, 0)==null) {
                dwarfsHatCount.putIfAbsent(hatColor, 0);
                dwarfsHatCount.put(hatColor, dwarfsHatCount.get(hatColor) + 1);
            }
            if(dwarfs.get(dwarf)<physics) dwarfs.put(dwarf, physics);

        }
        dwarfs.entrySet().stream().sorted((k1, k2) -> {
                    int sort = k2.getValue().compareTo(k1.getValue());
                    if (sort==0) {
                        String[] color1 = k1.getKey().split(", ");
                        String[] color2 = k2.getKey().split(", ");

                        int size1 = dwarfsHatCount.get(color1[0]);
                        int size2 = dwarfsHatCount.get(color2[0]);
                        sort = Integer.compare(size2, size1);
                    }
                    return sort;
        }).
                forEach(s->{
                    String[] dwarf = s.getKey().split(", ");
                    String name = dwarf[1];
                    String hatColor = dwarf[0];
                    System.out.printf("(%s) %s <-> %d%n", hatColor, name, s.getValue());
        });
    }
}
