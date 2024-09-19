import java.util.ArrayList;

public class ListedBooks {
    private static final ArrayList<Book> listedBooks = new ArrayList<>();

    static {
        //Genererade böcker av chatGPT
        listedBooks.add(new Book("A tale of lost love and redemption.", "2010", "Sarah Jenkins", "Whispers in the Wind"));
        listedBooks.add(new Book("Mystery unravels in a deserted futuristic metropolis.", "2015", "Michael Harper", "The Silent City"));
        listedBooks.add(new Book("A historian uncovers a centuries-old secret.", "2008", "Rachel Morris", "Echoes of the Past"));
        listedBooks.add(new Book("Deep-sea exploration leads to shocking discoveries.", "2012", "Kevin Porter", "Beneath the Surface"));
        listedBooks.add(new Book("A daring expedition to the edge of civilization.", "2020", "Amelia Cross", "The Last Frontier"));
        listedBooks.add(new Book("A hacker stumbles upon a dangerous conspiracy.", "2017", "Tom Wilkins", "Digital Shadows"));
        listedBooks.add(new Book("A chef competes in a high-stakes culinary challenge.", "2011", "Nina Alvarez", "The Final Plate"));
        listedBooks.add(new Book("A small town cop investigates a series of disappearances.", "2016", "Liam Cole", "Vanished"));
        listedBooks.add(new Book("An artist struggles with fame and inspiration.", "2009", "Anna Torres", "The Empty Canvas"));
        listedBooks.add(new Book("Survivors of a global pandemic rebuild society.", "2021", "Jack Matthews", "The New Dawn"));
        listedBooks.add(new Book("A detective races against time to solve a murder.", "2013", "Emily Grant", "The Final Hour"));
        listedBooks.add(new Book("An archaeologist uncovers the ruins of a lost city.", "2006", "Peter Green", "The Lost Civilization"));
        listedBooks.add(new Book("An astronaut stranded on Mars fights to survive.", "2018", "Lena Clark", "Alone on the Red Planet"));
        listedBooks.add(new Book("A spy mission goes horribly wrong.", "2019", "James Bennett", "Double Cross"));
        listedBooks.add(new Book("A fantasy realm's fate lies in the hands of a hero.", "2005", "Ella Brown", "The Last Kingdom"));
        listedBooks.add(new Book("A young girl’s journey through a magical forest.", "2004", "Grace White", "The Enchanted Woods"));
        listedBooks.add(new Book("A professor unearths a mystical artifact.", "2014", "William Foster", "The Stone of Destiny"));
        listedBooks.add(new Book("Two rival kingdoms clash in a brutal war.", "2007", "Olivia Reed", "War of Crowns"));
        listedBooks.add(new Book("A journalist uncovers corruption at the highest level.", "2011", "Dylan Hayes", "The Power Behind the Throne"));
        listedBooks.add(new Book("A young boy discovers he has magical powers.", "2003", "Sophia King", "The Hidden Spell"));
    }

    public static ArrayList<Book> loadLibrary() {
        return listedBooks;
    }
}
