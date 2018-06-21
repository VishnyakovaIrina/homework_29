package home.ivishnyakova.publishing_house;

import java.util.EventObject;
import java.util.Optional;

public class PublishingHouseEvent<T> extends EventObject {
    private T oldValue;
    private T newValue;

    public PublishingHouseEvent(Object source, T oldValue, T newValue) {
        super(source);
        this.newValue = Optional.ofNullable(newValue).orElseThrow(()-> new IllegalArgumentException("The new value is null"));
        this.oldValue = oldValue;
    }

    public PublishingHouseEvent(Object source, T newValue) {
        super(source);
        this.newValue = Optional.ofNullable(newValue).orElseThrow(()-> new IllegalArgumentException("The new value is null"));
    }

    public Optional<T> getOldValue() {
        return oldValue == null ? Optional.empty() : Optional.of(oldValue);
    }

    public Optional<T> getNewValue() {
        return newValue == null ? Optional.empty() : Optional.of(newValue);
    }
}
