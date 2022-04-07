import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        for(int i=0; i<number; i++){
            String input = console.nextLine();
            int startName = input.indexOf('@')+1;
            int endName = input.indexOf('|');
            String name = input.substring(startName,endName);
            int startAge = input.indexOf('#')+1;
            int endAge = input.indexOf('*');
            int age = Integer.parseInt(input.substring(startAge,endAge));
            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}
