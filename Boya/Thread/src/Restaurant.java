import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurant {
    private final Queue<Customer> finishOrders = new LinkedList<>();
    private final Queue<Customer> orders = new LinkedList<>();
    private final List<Thread> threads = new ArrayList<>();
    private final Thread customerMakerThread = new Thread(new CustomerMaker(this));
    private Thread timer = new Thread(new Timer(this));

    public synchronized void openShop() {
        timer.start();
        for (int i = 0; i < 5; i++) {
            Thread threadChief = new Thread(new Chief(this));
            threads.add(threadChief);
            threadChief.start();
        }
        customerMakerThread.start();
    }

    //客戶傳入訂單

    public synchronized void setOrder(Customer customer) {
        orders.offer(customer);
    }
    //廚師拿取訂單

    public synchronized Customer getOrder() {
        while (orders.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return orders.remove();
    }
    //廚師完成餐點

    public synchronized void finishOrder(Customer customer) {
        finishOrders.offer(customer);
        notifyAll();
    }
    //客戶拿取餐點

    public synchronized Food getFinishFood() {
        while (finishOrders.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();
        return finishOrders.remove().getOrderFood();
    }

    public synchronized void closeShop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public synchronized void addThread(Thread thread) {
        threads.add(thread);
    }
}
