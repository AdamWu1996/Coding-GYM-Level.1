import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Student implements Comparator {
    private String name;
    private String number;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}



