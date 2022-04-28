import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberOne = Integer.parseInt(console.nextLine());
        int numberTwo = Integer.parseInt(console.nextLine());
        int numberThree = Integer.parseInt(console.nextLine());
        int[] signArray = {numberOne, numberTwo, numberThree};
        System.out.println(signOfMultiplying(signArray));
    }

    private static String signOfMultiplying(int[] signArray) {
        int minus = 0;
        for(int i=0; i<signArray.length; i++){
            if(signArray[i]==0) return "zero";
            else if(signArray[i] < 0) minus++;
        }
        if (minus%2==0) return "positive";
        else return "negative";
    }
}
