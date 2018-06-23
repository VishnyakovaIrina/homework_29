package home.ivishnyakova;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Optional;

/*Класс BeanInfoUtil содержит методы для работы с бинами:
* - получение инфо о бине (getBeanInfoByClass);
* - сериализовать бин в XML (serializeBeanToXML);
* - десериализовать бин из XML (deserializeBeanFromXML);
* @author Вишнякова И.
* Дата 23/06/18
* */
public class BeanInfoUtil {
    //логгер
    //private static final Logger logger = LogManager.getLogger(LoggerUtil.getClassName());

    /* Метод getBeanInfoByClass формирует инфо о бине.
    * @param className - имя класса (бина);
    * @param writer - поток, в который выводится инфо о бине;
    *
    * @return поток, который содержит инфо о бине.
    * @throws IllegalArgumentException - className = null, или writer = null
    * @throws IntrospectionException - в случае, когда невозможно сформировать инфо о бине;
    * @throws ClassNotFoundException - имя класса указано с ошибкой.
    * */
    public static PrintWriter getBeanInfoByClass(String className, PrintWriter writer){

        String classNameOpt = Optional.ofNullable(className)
                .orElseThrow(() -> new IllegalArgumentException("The class name is null"));

        PrintWriter writerOpt = Optional.ofNullable(writer)
                .orElse(new PrintWriter(System.out));

        try {
            //получение инфо о бине
            Class<?> c = Class.forName(classNameOpt);
            BeanInfo beanInfo = Introspector.getBeanInfo(c);

            //вывод инфо о бине - свойство (имя, имя методов чтения и записи значения свойства)
            writerOpt.println("Info about bean \"" + className + "\"");
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();

            writerOpt.println("Properties:");
            writerOpt.println("--------------------------------------------------------");
            for(PropertyDescriptor descriptor : propertyDescriptors){
                writerOpt.println("Property name: " + descriptor.getDisplayName());
                writerOpt.println("Read method: "   + (descriptor.getReadMethod() != null ? descriptor.getReadMethod().getName() : "-"));
                writerOpt.println("Write method: "  + (descriptor.getWriteMethod() != null ? descriptor.getWriteMethod().getName() : "-"));
                writerOpt.println("--------------------------------------------------------");
            }
        } catch (IntrospectionException e) {
            //logger.error("The introspector could not get bean info",e);
            System.out.println("Error: The introspector could not get bean info");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //logger.error("The class was not found for the introspector",e);
            System.out.println("Error: The class was not found for the introspector");
            e.printStackTrace();
        }
        return writerOpt;
    }

    /* Метод serializeBeanToXML предназначен для сериализации бина bean в файл fileName.
     * @param bean - объект-бин;
     * @param fileName - имя файла для сохранения бина;
     * @throws IOException -  ошибка при записи бина в файл (например, файл не найден).
     * */
    public static <T> void serializeBeanToXML(T bean, String fileName){
        T beanOpt = Optional.ofNullable(bean)
                .orElseThrow(()-> new IllegalArgumentException("The bean is null"));
        String fileNameOpt = Optional.ofNullable(fileName)
                .orElse(LocalDateTime.now() + " bean.xml");

        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileNameOpt)))) {
            encoder.writeObject(beanOpt);
        }
        catch (IOException e){
            //logger.error("The bean was not serialized to XML",e);
            System.out.println("Error: The bean was not serialized to XML");
            e.printStackTrace();
        }
    }

    /* Метод deserializeBeanFromXML предназначен для десериализации бина bean из файла fileName.
     * @param fileName - имя файла для сохранения бина;
     * @return контейнер Optional с бином типа Т или пустой Optional (в случае ошибки).
     * @throws IOException -  ошибка при чтения бина из файла (например, файл не найден, формат нарушен).
     * */
    public static <T> Optional<T> deserializeBeanFromXML(String fileName){
        String fileNameOpt = Optional.ofNullable(fileName)
                .orElse(LocalDateTime.now() + " bean.xml");

        try (final XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileNameOpt))) {
            return Optional.ofNullable((T)decoder.readObject());
        }
        catch (IOException e){
            //logger.error("The bean was not deserialized from XML",e);
            System.out.println("Error: The bean was not deserialized from XML");
        }
        return Optional.empty();
    }
}
