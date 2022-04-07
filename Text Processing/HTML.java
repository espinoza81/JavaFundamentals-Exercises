import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String newText = "    ";
        output.append("<h1>").append(newLine);
        String titleArticle = console.nextLine();
        output.append(newText).append(titleArticle).append(newLine);
        output.append("</h1>").append(newLine);
        output.append("<article>").append(newLine);
        String contentArticle = console.nextLine();
        output.append(newText).append(contentArticle).append(newLine);
        output.append("</article>").append(newLine);
        String commentArticle;
        while (!"end of comments".equals(commentArticle= console.nextLine())){
            output.append("<div>").append(newLine);
            output.append(newText).append(commentArticle).append(newLine);
            output.append("</div>").append(newLine);
        }
        System.out.println(output);
    }
}
