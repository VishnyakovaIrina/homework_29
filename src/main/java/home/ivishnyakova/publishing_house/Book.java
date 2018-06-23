package home.ivishnyakova.publishing_house;

/* Класс Book представляет собой книгу.
* */
public class Book extends Edition {
    private String series;  //серия
    private String genre;   //жанр

    public Book(){
        super();
    }

    public Book(String name, String series, String genre) {
        super(name);
        this.series = series;
        this.genre = genre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "series='" + series + '\'' +
                ", genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", authors=" + authors +
                ", year=" + year +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", pageFormat='" + pageFormat + '\'' +
                "} ";
    }
}
