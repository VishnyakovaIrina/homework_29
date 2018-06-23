package home.ivishnyakova.publishing_house;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/* The class PublishingHouseBean represents a publishing house, that
*  publishes editions (books, magazines), and also holds presentations of
*  new editions.
*  @author  Irina Vishnyakova
*  Date 20/06/18
* */
public class PublishingHouseBean implements Serializable{
    private String name;        //название издательского дома
    private String address;     //адрес
    private Edition[] editions; //изданные печатные издания
    private Presentation[] presentations;   //презентации печатных изданий

    //размер массива по умолчанию
    transient private static int DEFAULT_ARRAY_SIZE = 1 << 8;

    //объект, для обслуживания слушателей бина
    transient private PublishingHouseListenersSupport listenersSupport;

    public PublishingHouseBean(){
        editions = new Edition[DEFAULT_ARRAY_SIZE];
        presentations = new Presentation[DEFAULT_ARRAY_SIZE];
        listenersSupport = new PublishingHouseListenersSupport(this);
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name)
                .orElseThrow(() -> new IllegalArgumentException("The name is null"));
    }

    public void setAddress(String address) {
        String addressOpt = Optional.ofNullable(address)
                .orElseThrow(() -> new IllegalArgumentException("The address is null"));
        String oldValue = this.address;
        this.address = addressOpt;

        //сообщить всем слушателям об изменении значения свойства
        listenersSupport.fireAddressChangeListener(oldValue, this.address);
    }

    public void setEditions(Edition[] editions) {
        Edition[] editionsOpt = Optional.ofNullable(editions)
                .orElseThrow(() -> new IllegalArgumentException("The new values of editions are null"));
        this.editions = Arrays.copyOf(editionsOpt, editionsOpt.length);

        //сообщить всем слушателям об изменении значения свойства
        listenersSupport.fireEditionsChangeListener(this.editions);
    }

    public void setEditions(int index, Edition edition) {
        Edition editionOpt = Optional.ofNullable(edition)
                .orElseThrow(() -> new IllegalArgumentException("The new value of edition is null"));
        Edition oldValue = this.editions[index];
        this.editions[index] = editionOpt;

        //сообщить всем слушателям об изменении значения свойства
        listenersSupport.fireEditionsChangeListener(oldValue, editionOpt);
    }

    public void setPresentations(Presentation[] presentations){
        Presentation[] presentationsOpt = Optional.ofNullable(presentations)
                .orElseThrow(() -> new IllegalArgumentException("The new values of presentations are null"));
        this.presentations = Arrays.copyOf(presentationsOpt, presentationsOpt.length);

        //сообщить всем слушателям об изменении значения свойства
        listenersSupport.firePresentationsChangeListener(this.presentations);
    }

    public void setPresentations(int index, Presentation presentation) {
        Presentation presentationOpt = Optional.ofNullable(presentation).orElseThrow(() -> new IllegalArgumentException("The new value of presentation is null"));
        Presentation oldValue = this.presentations[index];
        this.presentations[index] = presentationOpt;

        //сообщить всем слушателям об изменении значения свойства
        listenersSupport.firePresentationsChangeListener(oldValue, presentationOpt);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Edition[] getEditions() {
        Edition[] tmp = Arrays.copyOf(editions, editions.length);
        return tmp;
    }
    public Edition getEditions(int index) {
        return editions[index];
    }

    public Presentation[] getPresentations() {
        Presentation[] tmp = Arrays.copyOf(presentations, presentations.length);
        return tmp;
    }
    public Presentation getPresentations(int index) {
        return presentations[index];
    }

    public PublishingHouseListenersSupport getListenersSupport() {
        return listenersSupport;
    }
}
