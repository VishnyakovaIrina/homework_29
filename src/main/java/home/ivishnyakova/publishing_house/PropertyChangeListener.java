package home.ivishnyakova.publishing_house;

import java.util.EventListener;

public interface PropertyChangeListener extends EventListener {
    void dataWasChanged(PublishingHouseEvent event);
}
