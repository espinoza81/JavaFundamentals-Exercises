import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double x1 = Integer.parseInt(console.nextLine());
        double y1 = Integer.parseInt(console.nextLine());
        double diagonal1 = distanceToTheCenter(x1,y1);
        double[] pointOne = {x1, y1, diagonal1};
        double x2 = Integer.parseInt(console.nextLine());
        double y2 = Integer.parseInt(console.nextLine());
        double diagonal2 = distanceToTheCenter(x2,y2);
        double[] pointTwo = {x2, y2, diagonal2};
        closestToTheCenter(pointOne, pointTwo);

    }

    private static void closestToTheCenter(double[] pointOne, double[] pointTwo) {
        if (pointOne[2]==pointTwo[2] || pointOne[2] < pointTwo[2]) System.out.printf("(%.0f, %.0f)", pointOne[0], pointOne[1]);
        else System.out.printf("(%.0f, %.0f)", pointTwo[0], pointTwo[1]);
    }

    private static double distanceToTheCenter(double x, double y) {
        return Math.sqrt(x*x+y*y);
    }
}
