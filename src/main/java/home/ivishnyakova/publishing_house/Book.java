package home.ivishnyakova.publishing_house;

public class Book extends Edition {
    protected String series;
    protected String genre;


    public Book(String name, String series, String genre) {
        super(name);
        this.series = series;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                " name='" + name + '\'' +
                ", series='" + series + '\'' +
                ", genre='" + genre + '\'' +
                "}";
    }
}
