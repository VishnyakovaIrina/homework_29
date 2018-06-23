package home.ivishnyakova.subsriber_bean;

import home.ivishnyakova.LoggerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/*Класс SubscriberBeanInfo формирует доступные свойства и методы класса Subscriber
* */
public class SubscriberBeanInfo extends SimpleBeanInfo {

    //логгер
    //private static final Logger logger = LogManager.getLogger(LoggerUtil.getClassName());

    public SubscriberBeanInfo(){
    }

    /*Сформировать массив доступных свойств*/
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

            return new PropertyDescriptor[]{prName, prBoughtEditions};
        } catch (IntrospectionException e) {
            //logger.error("The introspector could not get bean info",e);
            System.out.println("Error: The introspector could not get bean info");
            e.printStackTrace();
        }
        return null;
    }
}
