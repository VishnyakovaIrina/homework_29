package home.ivishnyakova.publishing_house;

import java.util.Date;

public class Magazine extends Edition{
    protected Date releaseDate;
    protected byte number;
    protected PublishFrequency frequency;

    public Magazine(String name, Date releaseDate, byte number, PublishFrequency frequency) {
        super(name);
        this.releaseDate = releaseDate;
        this.number = number;
        this.frequency = frequency;
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
