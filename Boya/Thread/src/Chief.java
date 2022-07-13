public class Chief implements Runnable {
    private Restaurant restaurant;

    public Chief(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Customer customer = restaurant.getOrder();
                System.out.println("Doing " + customer + "'s " + customer.getOrderFood());
                Thread.sleep(customer.getOrderFood().costTime * 1000L);
                System.out.println(customer + "'s " + customer.getOrderFood() + " finished");
                restaurant.finishOrder(customer);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
