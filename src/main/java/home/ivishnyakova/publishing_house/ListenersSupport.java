package home.ivishnyakova.publishing_house;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*Обобщенный класс ListenersSupport предназначенный для поддержки слушателей событий:
* - ведение списка слушателей;
* - оповещение слушателей об наступлении соотв.события.
*
* @author Вишнякова И.
* Дата: 22/06/18
* */
public class ListenersSupport<T> {
    //слушатели событий
    private List<PropertyChangeListener> listeners;

    public ListenersSupport(){
        listeners = new ArrayList<>();
    }

    /*Добавление слушателя события*/
    public void addListener(PropertyChangeListener listener){
        listeners.add(listener);
    }

    /*Удаление слушателя события*/
    public void removeListener(PropertyChangeListener listener){
        listeners.remove(listener);
    }

    /*Оповещение слушателей о событии изменения значения свойства.
    * @param oldValue - текущее значение свойства;
    * @param newValue - новое значение свойства.*/
    @SuppressWarnings("unchecked")
    public void fireChangeListenerSupport(T oldValue, T newValue){
        for(PropertyChangeListener listener : listeners) {
            if (Optional.ofNullable(oldValue).isPresent()) {
                listener.dataWasChanged(new PublishingHouseEvent(this, newValue));
            }else{
                listener.dataWasChanged(new PublishingHouseEvent(this, oldValue, newValue));
            }
        }
    }

    /*Оповещение слушателей о событии изменения значения свойства.
    * @param newValue - новое значение свойства.*/
    @SuppressWarnings("unchecked")
    public void fireChangeListenerSupport(T[] newValue){
        for(PropertyChangeListener listener : listeners)
            listener.dataWasChanged(new PublishingHouseEvent(this, newValue));
    }



}
