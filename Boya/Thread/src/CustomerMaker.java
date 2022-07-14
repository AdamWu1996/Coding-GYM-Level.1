import java.util.Random;

public class CustomerMaker implements Runnable {
    //客戶編號
    private static int customerNumber;
    private static final Random random = new Random();
    private Restaurant restaurant;

    public CustomerMaker(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                //等待 2 ~ 7 秒
                wait(random.nextInt(5) * 1000 + 2000);
                Thread customerThread = new Thread(new Customer(restaurant, getRandomFood(), getNumber()));
                restaurant.addThread(customerThread);
                customerThread.start();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //遞增客戶編號
    private synchronized static int getNumber() {
        return customerNumber++;
    }

    private synchronized Food getRandomFood() {
        var food = switch (random.nextInt(4)) {
            case 0 -> new Hamburger();
            case 1 -> new Pizza();
            case 2 -> new FrenchFries();
            case 3 -> new ChickenNugget();
            case 4 -> new DrumStick();
            default -> throw new IllegalStateException("Unexpected value");
        };
        return food;
    }
}
