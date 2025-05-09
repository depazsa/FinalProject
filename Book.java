public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }

    public String toFileString() {
        return title + "," + author;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1]);
    }
}

