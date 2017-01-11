import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akuni on 02/01/2017.
 */
public abstract class Database {

    public static Map<String, String> storage = new HashMap<>();


    public static void add(String key, String value){
        storage.put(key, value);
    }

    public static String get(String key){
        return storage.get(key);
    }

    public static void print(){
        for(String k : storage.keySet()){
            System.out.println(k + " : " + storage.get(k));
        }
    }
}
