package home.ivishnyakova.publishing_house;

public class PublishingHouseListenersSupport {

    private ListenersSupport<Presentation> presentationsChangeListeners;
    private ListenersSupport<Edition> editionsChangeListeners;
    private ListenersSupport<String> addressChangeListeners;

    public PublishingHouseListenersSupport(){

        presentationsChangeListeners = new ListenersSupport<>();
        editionsChangeListeners = new ListenersSupport<>();
        addressChangeListeners = new ListenersSupport<>();

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

    public ListenersSupport<Presentation> getPresentationsChangeListeners() {
        return presentationsChangeListeners;
    }

    public ListenersSupport<Edition> getEditionsChangeListeners() {
        return editionsChangeListeners;
    }

    public ListenersSupport<String> getAddressChangeListeners() {
        return addressChangeListeners;
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
