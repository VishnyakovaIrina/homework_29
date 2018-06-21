package home.ivishnyakova.subsriber_bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class SubscriberBeanInfo extends SimpleBeanInfo {

    public SubscriberBeanInfo(){

        System.out.println("init BeanInfo");
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor prName = new PropertyDescriptor(
                    "name",
                    Subscriber.class,
                    "getName",
                    "setName");

            PropertyDescriptor prBoughtEditions = new PropertyDescriptor(
                    "boughtEditions",
                     Subscriber.class,
                    "getBoughtEditions",
                    "setBoughtEditions");

            /*PropertyDescriptor prAttendedPresentations = new PropertyDescriptor(
                    "attendedPresentations",
                     Subscriber.class,
                    "getAttendedPresentationsStream",
                    "setAttendedPresentations");
*/
            return new PropertyDescriptor[]{prName, prBoughtEditions};
//            return new PropertyDescriptor[]{prName, prBoughtEditions, prAttendedPresentations};
            //return new PropertyDescriptor[]{prName};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }


}
