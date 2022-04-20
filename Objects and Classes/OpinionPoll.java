import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OpinionPoll(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(console.nextLine());
        List<OpinionPoll> peopleList = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String input = console.nextLine();
            String[] attributePeople = input.split(" ");

            String name = attributePeople[0];
            int age = Integer.parseInt(attributePeople[1]);

            OpinionPoll singlePerson = new OpinionPoll(name, age);
            peopleList.add(singlePerson);
        }

        peopleList.stream().filter(s -> s.getAge() > 30).forEach(s -> System.out.printf("%s - %d%n", s.getName(), s.getAge()));
    }
}
