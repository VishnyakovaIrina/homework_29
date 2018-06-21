package home.ivishnyakova.publishing_house;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* The class PublishingHouseBean represents a publishing house, that
*  publishes editions (books, magazines), and also holds presentations of
*  new editions.
*  @author  Irina Vishnyakova
*  Date 20/06/18
* */
public class PublishingHouseBean implements Serializable{


    private String name;
    private String address;
    private List<Edition> editions;
    private List<Presentation> presentations;

    private PublishingHouseListenersSupport listenersSupport;


    public PublishingHouseBean(){
        editions = new ArrayList<>();
        presentations = new ArrayList<>();

        listenersSupport = new PublishingHouseListenersSupport();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        String oldValue = this.address;
        this.address = address;
        listenersSupport.getAddressChangeListeners().fireChangeListenerSupport(oldValue, this.address);
    }

    public void setEditions(List<Edition> editions) {
        this.editions = setIndexedProperty(editions, listenersSupport.getEditionsChangeListeners());
    }

    public void setEditions(int index, Edition edition) {
        setIndexedProperty(editions, index, edition, listenersSupport.getEditionsChangeListeners());
    }

    public void setPresentations(int index, Presentation presentation) {
        setIndexedProperty(presentations, index, presentation, listenersSupport.getPresentationsChangeListeners());
    }

    public void setPresentations(List<Presentation> presentations){
        this.presentations = setIndexedProperty(presentations, listenersSupport.getPresentationsChangeListeners());

    }

    public PublishingHouseListenersSupport getListenersSupport() {
        return listenersSupport;
    }

    private <T> List<T> setIndexedProperty(List<T> newIndexedProperty, ListenersSupport<T> listenersSupport){
        listenersSupport.fireChangeListenerSupport(newIndexedProperty);
        return new ArrayList<>(newIndexedProperty);
    }

    private <T> void setIndexedProperty(List<T> indexedProperty, int index, T newValue, ListenersSupport<T> listenersSupport){
        T oldValue = null;
        if (index >= indexedProperty.size()) {
            indexedProperty.add(newValue);
        }
        else {
            oldValue = indexedProperty.get(index);
            indexedProperty.set(index, newValue);
        }
        listenersSupport.fireChangeListenerSupport(oldValue, newValue);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Edition> getEditions() {
        return editions;
    }
    public Edition getEditions(int index) {
        return editions.get(index);
    }
    public List<Presentation> getPresentations() {
        return presentations;
    }
    public Presentation getPresentations(int index) {
        return presentations.get(index);
    }

}
