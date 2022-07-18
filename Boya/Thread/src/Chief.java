public class Chief implements Runnable {
    private Restaurant restaurant;
    private int no;

    public Chief(Restaurant restaurant, int no) {
        this.restaurant = restaurant;
        this.no = no;
    }

    @Override
    public void run() {
        try {
            while (restaurant.isOpening()) {
                Customer customer = restaurant.getOrder();
                System.out.println(this + " Doing " + customer + "'s " + customer.getOrderFood());
                Thread.sleep(customer.getOrderFood().costTime * 1000L);
                System.out.println(customer + "'s " + customer.getOrderFood() + " finished");
                restaurant.finishOrder(customer);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Chief" + no;
    }
}
