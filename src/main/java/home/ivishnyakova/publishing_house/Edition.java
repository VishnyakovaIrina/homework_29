package home.ivishnyakova.publishing_house;

import java.io.Serializable;
import java.util.List;

/* Класс Edition представляет собой печатное издание.
* */
public class Edition implements Serializable {
    protected String name;              //название
    protected int id;                   //код
    protected List<String> authors;     //список авторов
    protected short year;               //год издания
    protected short pageCount;          //количество страниц
    protected String language;          //язык издания
    protected String pageFormat;        //формат страниц


    public Edition() {
    }

    public Edition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", authors=" + authors +
                ", year=" + year +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", pageFormat='" + pageFormat + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getPageCount() {
        return pageCount;
    }

    public void setPageCount(short pageCount) {
        this.pageCount = pageCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageFormat() {
        return pageFormat;
    }

    public void setPageFormat(String pageFormat) {
        this.pageFormat = pageFormat;
    }

}
