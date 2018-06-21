package home.ivishnyakova.subsriber_bean;

import home.ivishnyakova.publishing_house.EditionsChangeListener;
import home.ivishnyakova.publishing_house.PresentationsChangeListener;
import home.ivishnyakova.publishing_house.PublishingHouseEvent;

public class Subscriber implements EditionsChangeListener, PresentationsChangeListener{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void dataWasChanged(PublishingHouseEvent event) {

        System.out.println("Subscriber " + name + " have got event:");
        event.getOldValue().ifPresent((oldValue)->System.out.println("old value = " + oldValue));
        event.getNewValue().ifPresent((newValue)->System.out.println("new value = " + newValue));
    }
}
