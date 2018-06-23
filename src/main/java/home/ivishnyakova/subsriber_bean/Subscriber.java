package home.ivishnyakova.subsriber_bean;

import home.ivishnyakova.publishing_house.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

/*Класс Subscriber представляет собой подписчика издательского дома.
 *Подписчик может подписаться на события об изменениях инфо о книгах,
 *журналах, а также презентаций, которые проводит издательский дом.
 * Подписчик также может покупать печатные издания.
 **/
public class Subscriber implements EditionsChangeListener,
        PresentationsChangeListener,
        Serializable{

    private String name;    //имя пользователя

    //список событий, которые отследил пользователь
    private List<PublishingHouseEvent> events;

    //купленные книги
    private List<Edition> boughtEditions;

    public Subscriber() {
        this.name = "default subscriber";
        events = new ArrayList<>();
        boughtEditions = new ArrayList<>();
    }

    public Subscriber(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountEvent(){
        return events.size();
    }

    public Stream<PublishingHouseEvent> getStreamEvents(){
        return events.stream();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Edition[] getBoughtEditions() {
        Edition[] arr = new Edition[boughtEditions.size()];
        return boughtEditions.toArray(arr);
    }
    public Edition getBoughtEditions(int index) {
        return boughtEditions.get(index);
    }

    public void setBoughtEditions(Edition[] boughtEditions) {
        this.boughtEditions = Arrays.asList(boughtEditions);
    }
    public void setBoughtEditions(int index, Edition boughtEdition) {
        if (index >= boughtEditions.size()) {
            boughtEditions.add(boughtEdition);
        }
        else {
            boughtEditions.set(index, boughtEdition);
        }
    }

    @Override
    public <T> void dataWasChanged(T event) {
        events.add((PublishingHouseEvent) event);
        describeEvent((PublishingHouseEvent)event);
    }

    @SuppressWarnings("unchecked")
    private void describeEvent(PublishingHouseEvent event){
        System.out.println("Subscriber " + name + " have got event:");
        event.getOldValue().ifPresent((oldValue)->System.out.println("old value = " + oldValue));
        event.getNewValue().ifPresent((newValue)->System.out.println("new value = " + newValue));
    }


}
