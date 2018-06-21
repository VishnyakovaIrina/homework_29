package home.ivishnyakova.publishing_house;

import java.util.ArrayList;
import java.util.List;

public class ListenersSupport<T> {
    private List<PropertyChangeListener> listeners;

    public ListenersSupport(){
        listeners = new ArrayList<>();
    }

    public void addListener(PropertyChangeListener listener){
        listeners.add(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        listeners.remove(listener);
    }

    @SuppressWarnings("unchecked")
    public void fireChangeListenerSupport(T oldValue, T newValue){
        for(PropertyChangeListener listener : listeners) {
            if (oldValue == null) {
                listener.dataWasChanged(new PublishingHouseEvent(this, newValue));
            }else{
                listener.dataWasChanged(new PublishingHouseEvent(this, oldValue, newValue));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void fireChangeListenerSupport(List<T> newValue){
        for(PropertyChangeListener listener : listeners)
            listener.dataWasChanged(new PublishingHouseEvent(this, newValue));
    }



}
