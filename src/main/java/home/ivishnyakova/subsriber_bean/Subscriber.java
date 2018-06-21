package home.ivishnyakova.subsriber_bean;

import home.ivishnyakova.publishing_house.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

public class Subscriber implements EditionsChangeListener, PresentationsChangeListener,
        Serializable{

    private String name;

    private List<PublishingHouseEvent> events;

    private List<Edition> boughtEditions;
    private List<Presentation> attendedPresentations;

    public Subscriber() {
        this.name = "default subscriber";
        events = new ArrayList<>();

        boughtEditions = new ArrayList<>();

        attendedPresentations = new ArrayList<>();
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

    public void setAttendedPresentations(Presentation presentation){
        attendedPresentations.add(presentation);
    }

    /*public Stream<Edition> getBoughtEditionsStream() {
        return boughtEditions.stream();
    }*/

    public Stream<Presentation> getAttendedPresentationsStream() {
        return attendedPresentations.stream();
    }

    @Override
    public void dataWasChanged(PublishingHouseEvent event) {
        events.add(event);
        describeEvent(event);
    }

    @SuppressWarnings("unchecked")
    private void describeEvent(PublishingHouseEvent event){
        System.out.println("Subscriber " + name + " have got event:");
        event.getOldValue().ifPresent((oldValue)->System.out.println("old value = " + oldValue));
        event.getNewValue().ifPresent((newValue)->System.out.println("new value = " + newValue));
    }


}
