import java.util.Scanner;

public class Articles {
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

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void Rename(String newTitle) {
        this.title = newTitle;
    }

    public void ChangeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void Edit(String newContent) {
        this.content = newContent;
    }

    public void ToString(){
        System.out.printf("%s - %s: %s", getTitle(), getContent(), getAuthor());
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] attributeArticles = console.nextLine().split(", ");

        String title = attributeArticles[0];
        String content = attributeArticles[1];
        String author = attributeArticles[2];

        Articles singleArticle = new Articles(title, content, author);

        int number = Integer.parseInt(console.nextLine());
        for(int i=0; i<number; i++) {
            String[] command = console.nextLine().split(": ");
            switch (command[0]){
                case "Edit":
                    String newContent = command[1];
                    singleArticle.Edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = command[1];
                    singleArticle.ChangeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = command[1];
                    singleArticle.Rename(newTitle);
                    break;
            }
        }
        singleArticle.ToString();
    }
}
