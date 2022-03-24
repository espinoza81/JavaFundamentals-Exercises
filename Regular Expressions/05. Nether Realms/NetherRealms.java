import java.util.Arrays;
import java.util.Scanner;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] demons = console.nextLine().split("\\s*,\\s*");
        for (String demon:demons) {
            String healthStr = demon.replaceAll("[0-9+\\-*/.]","");
            int health = 0;
            for(int i= 0; i<healthStr.length(); i++){
                health +=healthStr.charAt(i);
            }

            double damage =0.00;
            String damageStr = demon.replaceAll("[^0-9+\\-.]"," ").replaceAll("[+]", " +").replaceAll("[-]", " -").trim();
            if(!damageStr.isEmpty()) {
                double[] damageArr = Arrays.stream(damageStr.split("\\s+")).mapToDouble(Double::parseDouble).toArray();
                damage = Arrays.stream(damageArr).sum();
                String damageCalculate = demon.replaceAll("[^*/]","");
                for(int i=0; i<damageCalculate.length(); i++){
                    if(damageCalculate.charAt(i)=='*') damage *=2;
                    else damage /=2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
