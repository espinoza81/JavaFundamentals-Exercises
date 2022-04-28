import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] arrayStart = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command;
        while(!"end".equals(command = console.nextLine())) {
            String[] commandSplit = command.split(" ");
            switch (commandSplit[0])
            {
                case "exchange":
                    int index = Integer.parseInt(commandSplit[1]);
                    arrayStart = exchange(arrayStart, index);
                    break;
                case "max":
                    max(arrayStart, commandSplit[1]);
                    break;
                case "min":
                    min(arrayStart, commandSplit[1]);
                    break;
                case "first":
                    int count = Integer.parseInt(commandSplit[1]);
                    first(arrayStart, count, commandSplit[2]);
                    break;
                case "last":
                    count = Integer.parseInt(commandSplit[1]);
                    last(arrayStart, count, commandSplit[2]);
                    break;

            }
        }
        System.out.println(Arrays.toString(arrayStart));
    }

    private static void first(int[] arrayStart, int count, String s) {
        if (count> arrayStart.length) {
            System.out.println("Invalid count");
            return;
        }
        int a = 1;
        List<Integer> list = new ArrayList<>();
        if ("even".equals(s)) a = 0;
        for (int i = 0; i < arrayStart.length; i++) {
            if (arrayStart[i] % 2 == a) {
                list.add(arrayStart[i]);
                count--;
                if(count==0) break;
            }
        }
        System.out.println(list);
    }

    private static void last(int[] arrayStart, int count, String s) {
        if (count> arrayStart.length) {
            System.out.println("Invalid count");
            return;
        }
        int a = 1;
        List<Integer> list = new ArrayList<>();
        if ("even".equals(s)) a = 0;
        for (int i = arrayStart.length-1; i >=0; i--) {
            if (arrayStart[i] % 2 == a) {
                list.add(0,arrayStart[i]);
                count--;
                if(count==0) break;
            }
        }
        System.out.println(list);
    }

    private static void max(int[] arrayStart, String s) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        boolean hasMax = false;
        int a = 1;
        if ("even".equals(s)) a = 0;
        for (int i = 0; i < arrayStart.length; i++) {
            if (arrayStart[i] % 2 == a) {
                if (arrayStart[i] >= max) {
                    max = arrayStart[i];
                    index = i;
                    hasMax = true;
                }
            }
        }
        if (hasMax) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void min(int[] arrayStart, String s) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        boolean hasMin = false;
        int a = 1;
        if ("even".equals(s)) a = 0;
        for (int i = 0; i < arrayStart.length; i++) {
            if (arrayStart[i] % 2 == a) {
                if (arrayStart[i] <= min) {
                    min = arrayStart[i];
                    index = i;
                    hasMin = true;
                }
            }
        }
        if (hasMin) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    private static int[] exchange(int[] arrayStart, int index) {
        if (index<0 || index>=arrayStart.length) {
            System.out.println("Invalid index");
            return arrayStart;
        }
        int[] arrayAfterRotation = new int[arrayStart.length];
        System.arraycopy(arrayStart, 0, arrayAfterRotation, arrayStart.length-index-1, index+1);
        for(int i=index+1; i < arrayStart.length; i++){
            arrayAfterRotation[i-index-1]=arrayStart[i];
        }
        return arrayAfterRotation;
    }
}
