import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Library {

    private final ArrayList<Book> books;


    Library(ArrayList<Book> books) {
        this.books = books;

    }

    Scanner scanner = new Scanner(System.in);

    public void virtualDesk() {
        ArrayList<String> menuOptions = new ArrayList<>(List.of(
                "1. View all books",
                "2. Search books",
                "3. Return a book",
                "4. See waiting list",
                "5. Exit"));
        boolean userAtDesk = true;
        while (userAtDesk) {
            System.out.println("Welcome to the library!");
            for (String option : menuOptions) {
                System.out.println(option);
            }
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println("Complete library:");
                    printBooks(books);
                    loanBook(books);
                    break;
                }
                case "2": {
                    System.out.println("Enter a search word (tip: search for \"available\" or \"unavailable\"):");
                    String search = scanner.nextLine();
                    ArrayList<Book> searchResult = searchBook(books, search);
                    System.out.println(searchResult.isEmpty() ? "No result found..." : "You searched for: " + "\"" + search + "\"");
                    printBooks(searchResult);
                    if (!searchResult.isEmpty()) {
                        loanBook(searchResult);
                    }
                    break;
                }
                case "3": {
                    returnBook();
                    break;
                }
                case "4": {
                    final ArrayList<Book> waitingList = new ArrayList<>();
                    for (Book book : books) {
                        if (!book.getWaitingList().isEmpty()) {
                            waitingList.add(book);
                        }
                    }
                    printWaitingList(waitingList);
                    break;
                }
                case "5": {
                    System.out.println("Exiting...");
                    userAtDesk = false;
                    break;
                }
                default: {
                    System.out.println("Invalid input, try again!");
                }
            }
        }
    }

    public void loanBook(ArrayList<Book> books) {
        boolean loaning = true;
        while (loaning) {
            System.out.println("Enter the number of the book to loan (or \"back\" to return to menu): \n");
            String input = scanner.nextLine();
            boolean inputIsValidOption = inputIsValidOption(books, input);
            if (input.equalsIgnoreCase("back")) {
                loaning = false;
            } else if (inputIsValidOption) {
                Book bookToLoan = books.get(Integer.parseInt(input) - 1);
                if (bookToLoan.isAvailable()) {
                    System.out.println("You have successfully borrowed " + "\"" + bookToLoan.getTitle() + "\"");
                    bookToLoan.toggleIsAvailable();
                } else {
                    System.out.println("That book is not available at the moment.");
                    waitingList(bookToLoan);
                }
                loaning = false;
            } else {
                System.out.println("Invalid input, try again!");
            }
        }
    }

    private void waitingList(Book bookToLoan) {
        String input = scanner.nextLine();
        System.out.println("Would you like to join the waiting list?");
        switch (input.toLowerCase()) {
            case "yes": {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                bookToLoan.addNameToWaitingList(name);
            }
            case "no": {
                System.out.println("Returning...");
            }
            default: {
                System.out.println("Enter \"yes\" or \"no\"...");
            }
        }

    }

    private static boolean inputIsValidOption(ArrayList<Book> books, String input) {
        boolean inputIsValidOption = false;
        for (int i = 0; i < books.size(); i++) {
            try {
                if (Integer.parseInt(input) == i + 1) {
                    inputIsValidOption = true;
                    break;
                }
            } catch (NumberFormatException e) {
                break;
            }
        }
        return inputIsValidOption;
    }

    public void returnBook() {
        ArrayList<Book> returnAbleBooks = new ArrayList<>();
        boolean returning = true;
        while (returning) {
            System.out.println("Enter the title of the book to return:");
            String bookName = scanner.nextLine();
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(bookName) && !book.isAvailable()) {
                    returnAbleBooks.add(book);
                }
            }
            if (returnAbleBooks.isEmpty()) {
                System.out.println("No result found for \"" + bookName + "\"");
                returning = false;
            } else {
                printBooks(returnAbleBooks);
                System.out.println("Confirm which book you want to return (\"back\" to exit):");
                String input = scanner.nextLine();
                boolean inputIsValidOption = inputIsValidOption(returnAbleBooks, input);
                if (input.equalsIgnoreCase("back")) {
                    returning = false;
                } else if (inputIsValidOption) {
                    Book returnedBook = returnAbleBooks.get(Integer.parseInt(input) - 1);
                    if (returnedBook.getWaitingList().isEmpty()) {
                        returnedBook.toggleIsAvailable();
                    }
                    System.out.println("You have successfully returned: " + returnedBook);
                    returning = false;
                } else {
                    System.out.println("Invalid input, try again!");
                }
            }
        }
    }


    public void printBooks(ArrayList<Book> books) {
        int index = 0;
        for (Book book : books) {
            System.out.println();
            System.out.println(index + 1 + ": " + book);
            index++;
        }
    }

    public void printWaitingList(ArrayList<Book> books) {
        for (Book book : books) {
            int index = 0;
            System.out.println("Waiting list for " + book.getTitle());
            System.out.println();
            for (String name : book.getWaitingList()) {
                System.out.println(index + 1 + ": " + name);
                index++;
            }
        }
    }


    public ArrayList<Book> searchBook(ArrayList<Book> books, String search) {
        //Använd LinkedHashSet för att undvika samma sökresultat flera gånger
        LinkedHashSet<Book> searchResult = new LinkedHashSet<>();
        for (Book book : books) {
            //Prioriterar titel över författare, över beskrivning
            if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
                searchResult.add(book);
            } else if (book.getAuthor().toLowerCase().contains(search.toLowerCase())) {
                searchResult.add(book);
            } else if (book.getDescription().toLowerCase().contains(search.toLowerCase())) {
                searchResult.add(book);
            } else if (search.equals("available") && book.isAvailable()) {
                searchResult.add(book);
            } else if (search.equals("unavailable") && !book.isAvailable()) {
                searchResult.add(book);
            }
        }
        return new ArrayList<>(searchResult);
    }
}
