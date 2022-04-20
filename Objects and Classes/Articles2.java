import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Articles2 {
    private String title;
    private String content;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Articles2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    @Override
    public String toString() {
        return getTitle() + " - " + getContent() + ": "+ getAuthor();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        List<Articles2> articlesList = new ArrayList<>();

        for(int i=0; i<number; i++) {
            String[] attributeArticles = console.nextLine().split(", ");

            String title = attributeArticles[0];
            String content = attributeArticles[1];
            String author = attributeArticles[2];

            Articles2 singleArticle = new Articles2(title, content, author);
            articlesList.add(singleArticle);
        }

                articlesList.stream().forEach(s -> System.out.println(s.toString()));

    }
}
