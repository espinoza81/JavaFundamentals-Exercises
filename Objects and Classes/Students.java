import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students {
    private String firstName;
    private String secondName;
    private double grade;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Students(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", getFirstName(), getSecondName(), getGrade());
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Students> studentsList = new ArrayList<>();
        int number = Integer.parseInt(console.nextLine());

        for (int i=0; i<number; i++){
            String[] attributeStudent = console.nextLine().split(" ");

            String firstName = attributeStudent[0];
            String secondName = attributeStudent[1];
            double grade = Double.parseDouble(attributeStudent[2]);

            Students singleStudent = new Students(firstName, secondName, grade);
            studentsList.add(singleStudent);
        }

        studentsList.stream().sorted(Comparator.comparing(Students::getGrade).reversed()).collect(Collectors.toList()).forEach(s -> System.out.println(s.toString()));
    }
}
