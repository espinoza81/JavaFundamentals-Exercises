import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String numberBig = console.nextLine().replaceAll("^0+","");
        int multiplayer = Integer.parseInt(console.nextLine());
        StringBuilder output = new StringBuilder();
        int numberToSum = 0;
        for(int i=numberBig.length()-1; i>=0; i--){
            int a = numberBig.charAt(i) - '0';
            int numberToAdd = (a*multiplayer+numberToSum)%10;
            numberToSum = (a*multiplayer+numberToSum)/10;
            output.insert(0,numberToAdd);
            if(i==0 && numberToSum!=0) output.insert(0, numberToSum);
        }
        if(output.toString().replaceAll("0", "").length()==0) output = new StringBuilder("0");
        System.out.println(output);
    }
}
