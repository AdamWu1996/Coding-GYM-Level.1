import java.util.LinkedList;
import java.util.Queue;

public class Channel {
    private final Queue<String> queue = new LinkedList<>();

    public synchronized void put(String message) {
        while (queue.size() >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(message);
        notifyAll();
    }

    public synchronized String take() {
        while (queue.peek() == null){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        return queue.remove();
    }
}
