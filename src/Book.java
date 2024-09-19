public class Book {
    private final String title, author, year, description;
    private boolean available = true;

    public Book(String description, String year, String author, String title) {
        this.description = description;
        this.year = year;
        this.author = author;
        this.title = title;
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
    return "\nTitle: " + this.title + "\nAuthor: " + this.author + "\nYear: " +this.year
            + "\nDescription: " + this.description + (isAvailable() ? "\nAvailable" : "\nNot available");
    }

    public void toggleIsAvailable() {
        this.available = !available;
    }


}
