import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Waiter {
    private Queue<Food> foods = new LinkedList<>();

    public synchronized void setFood(Food food) {
        if (foods.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public synchronized Food getFood() {
        return null;
    }
}
