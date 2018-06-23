package home.ivishnyakova.publishing_house;

import java.time.LocalDate;

/* Класс Presentation представляет собой презентацию, которую организуют
для представления печатного издания.
* */
public class Presentation {
    protected LocalDate date;   //дата и время
    protected String address;   //адрес
    protected String nameEdition;   //название печатного издания
    protected String speakers;      //спикеры мероприятия

    public Presentation(){}

    public Presentation(LocalDate date, String address, String nameEdition, String speakers) {
        this.date = date;
        this.address = address;
        this.nameEdition = nameEdition;
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                " date=" + date +
                ", address='" + address + '\'' +
                ", nameEdition='" + nameEdition + '\'' +
                ", speakers='" + speakers + '\'' +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameEdition() {
        return nameEdition;
    }

    public void setNameEdition(String nameEdition) {
        this.nameEdition = nameEdition;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }
}
