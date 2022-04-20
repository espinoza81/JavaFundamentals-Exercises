import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        String [] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String [] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String [] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String [] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Scanner console = new Scanner(System.in);
        Random rnd = new Random();
        int number = console.nextInt();
        for(int i=0; i<number; i++){
            int index = rnd.nextInt(phrases.length);
            String phrase = phrases[index];
            index = rnd.nextInt(phrases.length);
            String event = events[index];
            index = rnd.nextInt(phrases.length);
            String author = authors[index];
            index = rnd.nextInt(phrases.length);
            String city = cities[index];
            System.out.printf("%s %s %s – %s.%n", phrase, event, author, city);
        }
    }
}
