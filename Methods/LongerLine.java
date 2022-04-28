import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double x1 = Integer.parseInt(console.nextLine());
        double y1 = Integer.parseInt(console.nextLine());
        double x2 = Integer.parseInt(console.nextLine());
        double y2 = Integer.parseInt(console.nextLine());
        double x3 = Integer.parseInt(console.nextLine());
        double y3 = Integer.parseInt(console.nextLine());
        double x4 = Integer.parseInt(console.nextLine());
        double y4 = Integer.parseInt(console.nextLine());

        double line1 = distanceBetweenTwoPoint(x1, y1, x2, y2);
        double[] lineOne = {x1, y1, x2, y2, line1};
        double line2 = distanceBetweenTwoPoint(x3, y3, x4, y4);
        double[] lineTwo = {x3, y3, x4, y4, line2};
        closestToTheCenter(lineOne, lineTwo);

    }

    private static void closestToTheCenter(double[] pointOne, double[] pointTwo) {
        if (pointOne[4]==pointTwo[4] || pointOne[4] > pointTwo[4]) {
            if(distanceBetweenTwoPoint(0,0,pointOne[0], pointOne[1]) < distanceBetweenTwoPoint(0,0,pointOne[2], pointOne[3]))
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointOne[0], pointOne[1], pointOne[2], pointOne[3]);
            else System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointOne[2], pointOne[3], pointOne[0], pointOne[1]);
        }
        else {
            if(distanceBetweenTwoPoint(0,0,pointTwo[0], pointTwo[1]) < distanceBetweenTwoPoint(0,0,pointTwo[2], pointTwo[3]))
              System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointTwo[0], pointTwo[1], pointTwo[2], pointTwo[3]);
            else System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", pointTwo[2], pointTwo[3], pointTwo[0], pointTwo[1]);
        }
    }

    private static double distanceBetweenTwoPoint(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}
