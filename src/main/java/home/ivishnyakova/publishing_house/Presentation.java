package home.ivishnyakova.publishing_house;

public class Presentation {
  /*  protected Date date;
    protected String address;
    protected String nameEdition;*/
    protected String speakers;

    public Presentation(String speakers) {
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "speakers='" + speakers + '\'' +
                '}';
    }
}
