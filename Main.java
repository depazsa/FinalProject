import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Check Out Book");
            System.out.println("3. View Available Books");
            System.out.println("4. View Checked Out Books");
            System.out.println("5. Save and Exit");
            choice = getValidInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    manager.addBook(new Book(title, author));
                    break;
                case 2:
                    manager.listAvailableBooks();
                    int index = getValidInt(sc, "Enter index to check out: ");
                    manager.checkOutBook(index);
                    break;
                case 3:
                    manager.listAvailableBooks();
                    break;
                case 4:
                    manager.listCheckedOutBooks();
                    break;
                case 5:
                    manager.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }

    public static int getValidInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            sc.next(); // clear bad input
            System.out.println("Invalid input. Try again.");
            return getValidInt(sc, prompt); // recursion
        }
    }
}

