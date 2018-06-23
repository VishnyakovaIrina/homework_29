package home.ivishnyakova.publishing_house;

import java.util.EventObject;
import java.util.Optional;

/*Обобщенный класс PublishingHouseEvent, который представляет собой событие
 *об изменении свойств издательского дома.
 **/
public class PublishingHouseEvent<T> extends EventObject {
    private T oldValue;     //старое значение свойства
    private T newValue;     //новое значение свойства
    private T[] newValueArr;//новое значение индексированного свойства

    public PublishingHouseEvent(Object source, T oldValue, T newValue) {
        super(source);
        this.newValue = Optional.ofNullable(newValue)
                .orElseThrow(()-> new IllegalArgumentException("The new value is null"));
        this.oldValue = oldValue;
    }

    public PublishingHouseEvent(Object source, T newValue) {
        super(source);
        this.newValue = Optional.ofNullable(newValue)
                .orElseThrow(()-> new IllegalArgumentException("The new value is null"));
    }

    public PublishingHouseEvent(Object source, T[] newValue) {
        super(source);
        this.newValueArr = Optional.ofNullable(newValue)
                .orElseThrow(()-> new IllegalArgumentException("The new value is null"));
    }

    public Optional<T> getOldValue() {
        return Optional.ofNullable(oldValue);
    }

    public Optional<T> getNewValue() {
        return Optional.ofNullable(newValue);
    }

    public Optional<T[]> getNewValueArr() {
        return Optional.ofNullable(newValueArr);
    }
}
