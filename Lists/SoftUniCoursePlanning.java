import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> lessons = Arrays.stream(console.nextLine().split(",\\s+")).collect(Collectors.toList());
        String command;
        while (!"course start".equals(command = console.nextLine())) {
            String[] commandWhitArgument = command.split(":");
            String lessonTitle = commandWhitArgument[1];
            switch (commandWhitArgument[0]) {
                case "Add":
                    if (!lessons.contains(lessonTitle)) lessons.add(lessonTitle);
                    break;
                case "Insert":
                    if (!lessons.contains(lessonTitle))
                        lessons.add(Integer.parseInt(commandWhitArgument[2]), lessonTitle);
                    break;
                case "Remove":
                    if (lessons.remove(lessonTitle)) {
                        lessons.remove(lessonTitle + "-Exercise");
                    }
                    break;
                case "Swap":
                    if (lessons.contains(lessonTitle) && lessons.contains(commandWhitArgument[2])) {
                        int indexFirst = lessons.indexOf(lessonTitle);
                        int indexSecond = lessons.indexOf(commandWhitArgument[2]);
                        lessons.set(indexSecond, lessonTitle);
                        lessons.set(indexFirst, commandWhitArgument[2]);
                        if (lessons.remove(lessonTitle + "-Exercise")) {
                            lessons.add(indexSecond + 1, lessonTitle + "-Exercise");
                        }
                        if (lessons.remove(commandWhitArgument[2] + "-Exercise")) {
                            lessons.add(indexFirst + 1, commandWhitArgument[2] + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (lessons.contains(lessonTitle) ) {
                        if(lessons.contains(lessonTitle+ "-Exercise")) continue;
                        lessons.add(lessons.indexOf(lessonTitle) + 1, lessonTitle + "-Exercise");
                    }
                    else {
                        lessons.add(lessonTitle);
                        lessons.add(lessonTitle + "-Exercise");
                    }
                    break;
            }
        }
        for (int i = 1; i <= lessons.size(); i++) {
            System.out.println(i + "." + lessons.get(i - 1));
        }
    }
}
