import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StringBuilder input = new StringBuilder(console.nextLine());
        int count=0;
        List <Integer> take = new ArrayList<>();
        List <Integer> skip = new ArrayList<>();

        for(int i=0; i<input.length();i++){
            if(isDigit(input.charAt(i))){
                if(count%2==0) take.add((int) input.charAt(i)-'0');
                else skip.add((int) input.charAt(i)-'0');
                input.deleteCharAt(i);
                i--;
                count++;
            }
        }
        String output="";
        int index=0;
        for(int j=0; j<take.size(); j++){
            if(index+take.get(j)>=input.length()){
                output += input.substring(index,input.length());
                break;
            }
            output += input.substring(index, index+take.get(j));
            index += take.get(j)+skip.get(j);
        }
        System.out.println(output);
    }
}
