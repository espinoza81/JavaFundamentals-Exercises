import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> data = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());
        String command;
        while (!"3:1".equals(command=console.nextLine())){
            String[] splitCommand = command.split("\\s+");
            switch (splitCommand[0]){
                case "merge":
                    int start = Integer.parseInt(splitCommand[1]);
                    int end = Integer.parseInt(splitCommand[2]);

                    if (start < 0) start=0;
                    if (start >= data.size() || end <0) continue;
                    if (end >= data.size()) end = data.size()-1;
                    String concatenateData = "";
                    for (int i = end; i>=start; i--) {
                        concatenateData = data.get(i) + concatenateData;
                        if (i> start) data.remove(i);
                    }
                    data.set(start,concatenateData);
                    break;
                case "divide":
                    int index = Integer.parseInt(splitCommand[1]);
                    int partitions = Integer.parseInt(splitCommand[2]);
                    String strDivide = data.get(index);
                    data.remove(index);
                    int len = strDivide.length();
                    int tempIndex = 0;
                    int lenPartition = len/partitions;
                    String[] strDivideArray = new String [partitions];
                    String part;
                    for(int i = 0; i < len; i = i+lenPartition) {
                        if(tempIndex<partitions-1)   part = strDivide.substring(i, i+lenPartition);
                        else  {
                            part = strDivide.substring(i, strDivide.length());
                            strDivideArray[tempIndex] = part;
                            break;
                        }
                        strDivideArray[tempIndex] = part;
                        tempIndex++;
                    }
                    data.addAll(index, List.of(strDivideArray));
                    break;
            }
        }
        System.out.println(String.join(" ", data));
    }
}
