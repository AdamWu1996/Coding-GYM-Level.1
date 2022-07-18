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
    private static int income = 0;
    private boolean isOpening = false;

    public synchronized void openShop() {
        isOpening = true;
        timer.start();
        for (int i = 0; i < 5; i++) {
            Thread threadChief = new Thread(new Chief(this, i));
            threads.add(threadChief);
            threadChief.start();
        }
        customerMakerThread.start();
    }

    //客戶傳入訂單

    public synchronized void setOrder(Customer customer) {
        orders.offer(customer);
        notify();
    }
    //廚師拿取訂單

    public Customer getOrder() {
        while (orders.peek() == null) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return orders.remove();
    }
    //廚師完成餐點

    public synchronized void finishOrder(Customer customer) {
        finishOrders.offer(customer);
        synchronized (customer) {
            customer.notify();
        }
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
        Customer customer = finishOrders.remove();
        customer.notify();
        getIncome(customer.getOrderFood().price);
        return customer.getOrderFood();
    }

    public synchronized void closeShop() {
        isOpening = false;
        System.out.println("Restaurant closed total income : " + income);
    }

    public synchronized void addThread(Thread thread) {
        threads.add(thread);
    }

    public synchronized void getIncome(int income){
        this.income += income;
        System.out.println("Current Income:" + this.income);
    }

    public boolean isOpening() {
        return isOpening;
    }
}
