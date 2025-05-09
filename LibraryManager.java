import java.util.*;
import java.io.*;

public class LibraryManager {
    ArrayList<Book> availableBooks = new ArrayList<>();
    Book[] checkedOutBooks = new Book[100];
    int checkedOutCount = 0;

    final String FILE_AVAILABLE = "available_books.txt";
    final String FILE_CHECKED_OUT = "checked_out_books.txt";

    public LibraryManager() {
        loadFromFile();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void checkOutBook(int index) {
        if (index >= 0 && index < availableBooks.size() && checkedOutCount < checkedOutBooks.length) {
            Book book = availableBooks.remove(index);
            checkedOutBooks[checkedOutCount++] = book;
            System.out.println("Checked out: " + book);
        } else {
            System.out.println("Invalid index or max checked-out limit reached.");
        }
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println(i + ": " + availableBooks.get(i));
        }
    }

    public void listCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (int i = 0; i < checkedOutCount; i++) {
            System.out.println(i + ": " + checkedOutBooks[i]);
        }
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(FILE_AVAILABLE)) {
            for (Book book : availableBooks) {
                pw.println(book.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving available books.");
        }

        try (PrintWriter pw = new PrintWriter(FILE_CHECKED_OUT)) {
            for (int i = 0; i < checkedOutCount; i++) {
                pw.println(checkedOutBooks[i].toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving checked out books.");
        }
    }

    public void loadFromFile() {
        try (Scanner sc = new Scanner(new File(FILE_AVAILABLE))) {
            while (sc.hasNextLine()) {
                availableBooks.add(Book.fromFileString(sc.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("No available books file found.");
        }

        try (Scanner sc = new Scanner(new File(FILE_CHECKED_OUT))) {
            while (sc.hasNextLine() && checkedOutCount < checkedOutBooks.length) {
                checkedOutBooks[checkedOutCount++] = Book.fromFileString(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("No checked out books file found.");
        }
    }
}

