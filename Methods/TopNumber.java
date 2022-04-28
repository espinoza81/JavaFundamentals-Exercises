import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        for (int i=1; i<=n; i++){
            String num = String.valueOf(i);
            int sum=sumOfDigits(num);
            if (sum%8==0) {
                haveOneOddDigit(num);
            }
        }
    }

    private static void haveOneOddDigit(String num) {
        int digit=0;
        for (int i=0; i<num.length();i++){
            digit = Integer.parseInt(getNextDigit(num, i));
            if(digit%2==1) {
                System.out.println(num);
                return;
            }
        }
    }

    private static String  getNextDigit(String num, int index) {
        return String.valueOf(num.charAt(index));
    }
    private static int sumOfTwoNumber(int numberOne, int numberTwo) {
         return  numberOne+numberTwo;
    }
    private  static int sumOfDigits(String num){
        int digit=0;
        int sum=0;
        for (int i=0; i<num.length();i++){
            digit = Integer.parseInt(getNextDigit(num, i));
            sum = sumOfTwoNumber(sum, digit);
        }
        return sum;
    }
}
