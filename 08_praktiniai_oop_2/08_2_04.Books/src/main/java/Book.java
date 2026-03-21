public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int years) {
        this.title = title;
        this.pages = pages;
        this.year = years;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + ", " + pages + " pages, " + year;
    }
}
