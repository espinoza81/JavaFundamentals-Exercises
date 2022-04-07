import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] words = console.nextLine().split("\\s+");
        double sum = 0.00;
        for(String word:words){
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length()-1);
            double number = Double.parseDouble(word.substring(1, word.length()-1));
            if(Character.isLowerCase(firstChar)) number *= (firstChar-'a'+1);
            else number /= (firstChar - 'A'+1);
            if(Character.isLowerCase(lastChar)) number += (lastChar-'a'+1);
            else number -= (lastChar-'A'+1);
            sum +=number;
        }
        System.out.printf("%.2f", sum);
    }
}
