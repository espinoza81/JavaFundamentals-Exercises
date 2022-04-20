import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email; //n/a
        private int age;      //-1

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }
    }
    public static class Departments{
        private String name;
        private double salary;
        private int count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Departments(String name, double salary, int count) {
            this.name = name;
            this.salary = salary;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        List<Departments> departmentsList = new ArrayList<>();

        for (int i=0; i<number; i++){
            String input = console.nextLine();
            String[] attribute = input.split(" ");

            String name = attribute[0];
            double salary = Double.parseDouble(attribute[1]);
            String position = attribute[2];
            String department = attribute[3];
            String email = "n/a";
            int age = -1;

            if(attribute.length >= 5) {
                if(attribute[4].contains("@"))  email = attribute[4];
                else age = Integer.parseInt(attribute[4]);
            }
            if(attribute.length == 6) {
                age = Integer.parseInt(attribute[5]);
            }

            Employee singleEmployee = new Employee(name, salary, position, department, email, age);
            employeeList.add(singleEmployee);

            Departments singleDepartment = departmentsList.stream().filter(s -> s.getName().equals(department)).findFirst().orElse(null);
            if (singleDepartment == null) {
                Departments departmentToAdd = new Departments(department, salary, 1);
                departmentsList.add(departmentToAdd);
            } else {
                singleDepartment.setSalary(singleDepartment.getSalary() + salary);
                singleDepartment.setCount(singleDepartment.getCount()+1);
            }
        }
        double highestAverageSalary = 0.00;
        String departmentToPrint = " ";
        for (Departments dep:departmentsList) {
            double averageSalary = dep.salary/dep.count;
            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                departmentToPrint = dep.name;
            }
        }
        System.out.printf("Highest Average Salary: %s%n", departmentToPrint);
        String finalDepartmentToPrint = departmentToPrint;
        employeeList.stream().filter(s -> s.getDepartment().equals(finalDepartmentToPrint)).sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList())
                .forEach(s -> System.out.printf("%s %.2f %s %d%n", s.getName(), s.getSalary(), s.getEmail(), s.getAge()));

    }
}
