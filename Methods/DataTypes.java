import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String kindDataTypes = console.nextLine();
        switch (kindDataTypes){
            case "int":
                int number = Integer.parseInt(console.nextLine());
                onlyOneMethod(number);
                break;
            case "real":
                double numberDouble = Double.parseDouble(console.nextLine());
                onlyOneMethod(numberDouble);
                break;
            case "string":
                String word = console.nextLine();
                onlyOneMethod(word);
                break;
        }
    }

    private static void onlyOneMethod(int number) {
        System.out.println(number*2);
    }

    private static void onlyOneMethod(double number) {
        System.out.println(new DecimalFormat("0.00").format(number*1.5));
    }

    private static void onlyOneMethod(String number) {
        System.out.println("$" + number + "$");
    }
}
