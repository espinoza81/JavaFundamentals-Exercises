import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languages = new LinkedHashMap<>();
        String input;
        while (!"exam finished".equals(input = console.nextLine())) {
            String[] command = input.split("-");
            String username = command[0];
            String language = command[1];
            int points=0;
            if(!"banned".equals(language)) points = Integer.parseInt(command[2]);
            else {
                students.remove(username);
                continue;
            }
            students.putIfAbsent(username, points);
            if(students.get(username) < points)  students.put(username,points);
            languages.putIfAbsent(language, 0);
            languages.put(language, languages.get(language)+1);
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languages.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
