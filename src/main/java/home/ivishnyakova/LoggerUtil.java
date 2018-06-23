package home.ivishnyakova;

public class LoggerUtil {

    /*Получить имя класса*/
    public static String getClassName(){
        try{
            throw new RuntimeException();
        }
        catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }
}
