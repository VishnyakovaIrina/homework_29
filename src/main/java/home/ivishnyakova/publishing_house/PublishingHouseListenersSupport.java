package home.ivishnyakova.publishing_house;

public class PublishingHouseListenersSupport {
    private PublishingHouseBean publishingHouseBean;

    private ListenersSupport<Presentation> presentationsChangeListeners;
    private ListenersSupport<Edition> editionsChangeListeners;
    private ListenersSupport<String> addressChangeListeners;

    public PublishingHouseListenersSupport(PublishingHouseBean publishingHouseBean){

        presentationsChangeListeners = new ListenersSupport<>();
        editionsChangeListeners = new ListenersSupport<>();
        addressChangeListeners = new ListenersSupport<>();

        this.publishingHouseBean = publishingHouseBean;

    }

    public void fireAddressChangeListener(String oldValue, String newValue){
        addressChangeListeners.fireChangeListenerSupport(oldValue,newValue);
    }
    public void fireEditionsChangeListener(Edition oldValue, Edition newValue){
        editionsChangeListeners.fireChangeListenerSupport(oldValue,newValue);
    }
    public void firePresentationsChangeListener(Presentation oldValue, Presentation newValue){
        presentationsChangeListeners.fireChangeListenerSupport(oldValue,newValue);
    }
    public void fireEditionsChangeListener(Edition[] newValue){
        editionsChangeListeners.fireChangeListenerSupport(newValue);
    }
    public void firePresentationsChangeListener(Presentation[] newValue){
        presentationsChangeListeners.fireChangeListenerSupport(newValue);
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
