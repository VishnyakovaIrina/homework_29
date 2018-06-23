package home.ivishnyakova;

import home.ivishnyakova.publishing_house.*;
import home.ivishnyakova.subsriber_bean.Subscriber;

import java.io.PrintWriter;
import java.util.Optional;

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

        //десериализовать бин
        Optional<PublishingHouseBean> publishingHouseOpt = BeanInfoUtil.deserializeBeanFromXML("src/main/resources/publishing_house.xml");
        //бин "Издательский дом"
        PublishingHouseBean publishingHouseBean = publishingHouseOpt.orElse(new PublishingHouseBean());
        //поддержка слушателей бина
        final PublishingHouseListenersSupport listenersSupport = publishingHouseBean.getListenersSupport();

        //слушатели
        Subscriber user1 = new Subscriber("user1");
        listenersSupport.addEditionsChangeListener(user1);
        listenersSupport.addAddressChangeListener(user1);

        Subscriber user2 = new Subscriber("user2");
        listenersSupport.addEditionsChangeListener(user2);
        listenersSupport.addPresentationsChangeListener(user2);

        Subscriber user3 = new Subscriber("user3");
        listenersSupport.addPresentationsChangeListener(user3);

        Subscriber user4 = new Subscriber("user4");
        listenersSupport.addAddressChangeListener(user4);
        listenersSupport.addPresentationsChangeListener(user4);
        listenersSupport.addEditionsChangeListener(user4);

        //задание значений свойств бина
        publishingHouseBean.setName("Addison-Wesley");
        publishingHouseBean.setAddress("USA, Boston");

        publishingHouseBean.setEditions(new Edition[]
                {new Book("Peter Pen","adventure","for children"),
                 new Book("Treasure Island","adventure","for children"),
                 new Magazine("My baby")
                });
        try {
            //изменение свойств бина
            publishingHouseBean.setEditions(0, new Magazine("IT"));
            publishingHouseBean.setEditions(1, new Edition("Tom Sawyer"));
        }catch (Exception e){
            System.out.println("Error: the property \"editions\" was not changed");
            e.printStackTrace();
        }
        publishingHouseBean.setAddress("USA, Boston, Massachusetts");

        //книги, купленные подписчиком
        System.out.println("The book was bought by user:");
        try {
            user1.setBoughtEditions(0, publishingHouseBean.getEditions(0));
            user1.setBoughtEditions(1, publishingHouseBean.getEditions(2));
            for (Edition edition : user1.getBoughtEditions()) {
                System.out.println(edition);
            }
        }catch (Exception e){
            System.out.println("Error: the property \"boughtEditions\" was not changed");
            e.printStackTrace();
        }

        //инфо о бинах
        PrintWriter writer = new PrintWriter(System.out);

        writer.println("Bean info about class \"Subscriber\"");
        writer = BeanInfoUtil.getBeanInfoByClass("home.ivishnyakova.subsriber_bean.Subscriber", writer);

        writer.println("Bean info about class \"PublishingHouseBean\"");
        writer = BeanInfoUtil.getBeanInfoByClass("home.ivishnyakova.publishing_house.PublishingHouseBean", writer);
        writer.flush();

        //сериализовать бин
        BeanInfoUtil.serializeBeanToXML(publishingHouseBean, "src/main/resources/publishing_house.xml");
    }
}
