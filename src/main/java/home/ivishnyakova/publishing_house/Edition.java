package home.ivishnyakova.publishing_house;

public class Edition {
    protected String name;

/*    protected int id;
    protected List<String> authors;
    protected short year;
    protected short pageCount;
    protected String language;
    protected String pageFormat;
    */

    public Edition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name='" + name + '\'' +
                '}';
    }
}
