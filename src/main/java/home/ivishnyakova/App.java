package home.ivishnyakova;

import home.ivishnyakova.publishing_house.Edition;
import home.ivishnyakova.publishing_house.EditionsChangeListener;
import home.ivishnyakova.publishing_house.PresentationsChangeListener;
import home.ivishnyakova.publishing_house.PublishingHouseBean;
import home.ivishnyakova.subsriber_bean.Subscriber;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PublishingHouseBean publishingHouseBean = new PublishingHouseBean();

        EditionsChangeListener user1 = new Subscriber("user1");
        publishingHouseBean.addEditionsChangeListener(user1);

        EditionsChangeListener user2 = new Subscriber("user2");
        publishingHouseBean.addEditionsChangeListener(user2);
        publishingHouseBean.addPresentationsChangeListener(user2);

        PresentationsChangeListener user3 = new Subscriber("user3");
        publishingHouseBean.addPresentationsChangeListener(user3);

        Subscriber user4 = new Subscriber("user4");
        publishingHouseBean.addAddressChangeListener(user4);
        publishingHouseBean.addPresentationsChangeListener(user4);
        publishingHouseBean.addEditionsChangeListener(user4);

        Subscriber user5 = new Subscriber("user5");
        publishingHouseBean.addAddressChangeListener(user5);


        publishingHouseBean.setEditions(Arrays.asList(new Edition("Peter Pen")));
        publishingHouseBean.setEditions(1, new Edition("Mary Poppins"));
        publishingHouseBean.setEditions(0, new Edition("Tom Sawyer"));

        /*publishingHouseBean.setEditions(0, new Edition("Maria-Mirabella"));

        */

        publishingHouseBean.setAddress("new address");


    }
}
