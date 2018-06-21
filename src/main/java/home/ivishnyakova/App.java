package home.ivishnyakova;

import home.ivishnyakova.publishing_house.*;
import home.ivishnyakova.subsriber_bean.Subscriber;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        PublishingHouseBean publishingHouseBean = new PublishingHouseBean();
        PublishingHouseListenersSupport listenersSupport = publishingHouseBean.getListenersSupport();

        Subscriber user1 = new Subscriber("user1");
        listenersSupport.addEditionsChangeListener(user1);

        Subscriber user2 = new Subscriber("user2");
        listenersSupport.addEditionsChangeListener(user2);
        listenersSupport.addPresentationsChangeListener(user2);

        Subscriber user3 = new Subscriber("user3");
        listenersSupport.addPresentationsChangeListener(user3);

        Subscriber user4 = new Subscriber("user4");
        listenersSupport.addAddressChangeListener(user4);
        listenersSupport.addPresentationsChangeListener(user4);
        listenersSupport.addEditionsChangeListener(user4);

        Subscriber user5 = new Subscriber("user5");
        listenersSupport.addAddressChangeListener(user5);


        publishingHouseBean.setName("Addison-Wesley");
        publishingHouseBean.setAddress("USA, Boston");

        publishingHouseBean.setEditions(Arrays.asList(new Edition("Peter Pen"),new Edition("Treasure Island")));
        publishingHouseBean.setEditions(1, new Edition("Mary Poppins"));
        publishingHouseBean.setEditions(2, new Edition("Tom Sawyer"));

        publishingHouseBean.setAddress("USA, Boston, Massachusetts");

        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(user1);
        subscribers.add(user2);
        subscribers.add(user3);
        subscribers.add(user4);
        subscribers.add(user5);

        subscribers.forEach(
                (subscriber) -> {
                    System.out.println("Count of events of subscriber \"" +
                        subscriber.getName()
                        + "\" = " + subscriber.getCountEvent());
                }
        );

        try {
            Class<?> c = Class.forName("home.ivishnyakova.subsriber_bean.Subscriber");
            BeanInfo beanInfo = Introspector.getBeanInfo(c);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor descriptor : propertyDescriptors){
                System.out.println(descriptor);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        user1.setBoughtEditions(0, new Magazine("My family", new Date(0L),(byte)7, PublishFrequency.MONTH));
        for (Edition edition : user1.getBoughtEditions()) {
            System.out.println(edition);
        }
    }
}
