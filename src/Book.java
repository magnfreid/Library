import java.util.ArrayList;

public class Book {
    private final String title, author, year, description;
    private boolean available = true;
    private final ArrayList<String> waitingList;

    public Book(String description, String year, String author, String title) {
        this.description = description;
        this.year = year;
        this.author = author;
        this.title = title;
        waitingList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public String toString() {
    return "\nTitle: " + title + "\nAuthor: " + author + "\nYear: " +year
            + "\nDescription: " +description + (isAvailable() ? "\nAvailable" : "\nNot available");
    }

    public void toggleIsAvailable() {
        available = !available;
    }

    public void addNameToWaitingList(String name) {
        waitingList.add(name);
    }

    public ArrayList<String> getWaitingList(){
        return waitingList;
    }


}
