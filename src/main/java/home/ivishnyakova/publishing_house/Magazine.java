package home.ivishnyakova.publishing_house;

import java.time.LocalDate;

/* Класс Magazine представляет собой журнал.
* */
public class Magazine extends Edition{
    private LocalDate releaseDate;      //дата выпуска
    private byte number;                //номер по порядку
    private PublishFrequency frequency; //частота выхода журнала

    public Magazine() {
        super();
    }

    public Magazine(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                " name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", number=" + number +
                ", frequency=" + frequency +
                "} ";
    }
}
