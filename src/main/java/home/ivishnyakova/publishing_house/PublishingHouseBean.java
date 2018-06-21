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

    private ListenersSupport<Presentation> presentationsChangeListeners;
    private ListenersSupport<Edition> editionsChangeListeners;
    private ListenersSupport<String> addressChangeListeners;

    public PublishingHouseBean(){
        presentationsChangeListeners = new ListenersSupport<>();
        editionsChangeListeners = new ListenersSupport<>();
        addressChangeListeners = new ListenersSupport<>();

        editions = new ArrayList<>();
        presentations = new ArrayList<>();
    }

    public void addEditionsChangeListener(PropertyChangeListener listener){
        addPropertyChangeListener(editionsChangeListeners, listener);
    }

    public void addPresentationsChangeListener(PropertyChangeListener listener){
        addPropertyChangeListener(presentationsChangeListeners, listener);
    }

    public void addAddressChangeListener(PropertyChangeListener listener){
        addPropertyChangeListener(addressChangeListeners, listener);
    }

    public void removeEditionsChangeListener(PropertyChangeListener listener){
        removePropertyChangeListener(editionsChangeListeners, listener);
    }

    public void removePresentationsChangeListener(PropertyChangeListener listener){
        removePropertyChangeListener(presentationsChangeListeners, listener);
    }

    public void removeAddressChangeListener(PropertyChangeListener listener){
        removePropertyChangeListener(addressChangeListeners, listener);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        String oldValue = this.address;
        this.address = address;
        addressChangeListeners.fireChangeListenerSupport(oldValue, this.address);
    }

    public void setEditions(List<Edition> editions) {
        this.editions = setIndexedProperty(editions, editionsChangeListeners);
    }

    public void setEditions(int index, Edition edition) {
        setIndexedProperty(editions, index, edition, editionsChangeListeners);
    }

    public void setPresentations(int index, Presentation presentation) {
        setIndexedProperty(presentations, index, presentation, presentationsChangeListeners);
    }

    public void setPresentations(List<Presentation> presentations){
        this.presentations = setIndexedProperty(presentations, presentationsChangeListeners);

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

    private <T> void addPropertyChangeListener(ListenersSupport<T> listeners, PropertyChangeListener listener){
        try {
            listeners.addListener(listener);
        }catch(Exception e){

        }
    }

    private <T> void removePropertyChangeListener(ListenersSupport<T> listeners, PropertyChangeListener listener){
        try {
            listeners.removeListener(listener);
        }catch(Exception e){

        }
    }
}
