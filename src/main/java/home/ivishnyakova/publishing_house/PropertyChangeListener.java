package home.ivishnyakova.publishing_house;

import java.util.EventListener;

/*Интерфейс PropertyChangeListener содержит метод dataWasChanged,
 *который вызывается слушателями при наступлении события -
 * изменение значения свойства*/
public interface PropertyChangeListener extends EventListener {
    <T> void dataWasChanged(T event);
}
