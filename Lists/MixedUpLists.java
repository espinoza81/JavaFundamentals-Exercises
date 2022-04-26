import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> numbersOne = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbersTwo = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixedNumber = new ArrayList<>();
        int smallSize = Math.min(numbersOne.size(), numbersTwo.size());
        for(int i = 0; i < smallSize; i++){
            mixedNumber.add(numbersOne.get(i));
            mixedNumber.add(numbersTwo.get(numbersTwo.size()-1-i));
        }
        int startRange;
        int endRange;
        if(numbersTwo.size() > smallSize) {
            startRange = Math.min(numbersTwo.get(0), numbersTwo.get(1));
            endRange = Math.max(numbersTwo.get(0), numbersTwo.get(1));
        }
        else {
            startRange = Math.min(numbersOne.get(smallSize), numbersOne.get(smallSize + 1));
            endRange = Math.max(numbersOne.get(smallSize), numbersOne.get(smallSize + 1));
        }
        int finalStartRange = startRange;
        int finalEndRange = endRange;
        mixedNumber.removeIf(n -> n<= finalStartRange || n>= finalEndRange);
        Collections.sort(mixedNumber);
        System.out.println(mixedNumber.toString().replaceAll("[\\[\\],]", ""));
    }
}
