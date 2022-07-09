import java.util.ArrayList;
import java.util.Map;

public class Util {
    public static <T> ArrayList<T> asList(T... a) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : a) {
            arrayList.add(t);
        }
        return arrayList;
    }

//    public void ArrayList<E> asList2(E...a){
//        //return null;
//    }
}

