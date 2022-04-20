import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderByAge {
    private String name;
    private String id;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OrderByAge(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<OrderByAge> personList = new ArrayList<>();
        String input;
        while (!"End".equals(input= console.nextLine())){
            String[] attributePerson = input.split(" ");
            String name = attributePerson[0];
            String id = attributePerson[1];
            int age = Integer.parseInt(attributePerson[2]);

            OrderByAge singlePerson = new OrderByAge(name, id, age);
            personList.add(singlePerson);
        }
        personList.stream().sorted(Comparator.comparing(OrderByAge::getAge)).collect(Collectors.toList())
                .forEach(s -> System.out.printf("%s with ID: %s is %d years old.%n", s.getName(), s.getId(), s.getAge()));
    }
}
