package home.ivishnyakova;

import home.ivishnyakova.publishing_house.*;
import home.ivishnyakova.subsriber_bean.Subscriber;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Задание 29.
 * Создать бины.  Один бин публикует свои доступные методы по шаблону,
 * второй - с использованием интерфейса BeanInfo.
 *
 *@author Вишнякова И.
 * Дата 23/06/18
 */
public class App 
{
    public static void main( String[] args )  {
        PublishingHouseBean publishingHouseBean = new PublishingHouseBean();
        final PublishingHouseListenersSupport listenersSupport = publishingHouseBean.getListenersSupport();

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

        publishingHouseBean.setEditions(new Edition[]
                {new Edition("Peter Pen"),
                 new Edition("Treasure Island")
                });
        publishingHouseBean.setEditions(0, new Edition("Mary Poppins"));
        publishingHouseBean.setEditions(1, new Edition("Tom Sawyer"));

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


        user1.setBoughtEditions(0, new Magazine("My family"));
        for (Edition edition : user1.getBoughtEditions()) {
            System.out.println(edition);
        }

        PrintWriter writer = new PrintWriter(System.out);

        writer.println("Bean info about class \"Subscriber\"");
        writer = BeanInfoUtil.getBeanInfoByClass("home.ivishnyakova.subsriber_bean.Subscriber", writer);

        writer.println("Bean info about class \"PublishingHouseBean\"");
        writer = BeanInfoUtil.getBeanInfoByClass("home.ivishnyakova.publishing_house.PublishingHouseBean", writer);
        writer.flush();

        BeanInfoUtil.serializeBeanToXML(publishingHouseBean, "/resources/publishing_house.xml");


    }
}
