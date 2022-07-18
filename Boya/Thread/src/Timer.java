public class Timer implements Runnable {
    private Restaurant restaurant;

    public Timer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("Restaurant Opening");
                wait(60 * 1000L);
                System.out.println("Restaurant Closed");
                restaurant.closeShop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
