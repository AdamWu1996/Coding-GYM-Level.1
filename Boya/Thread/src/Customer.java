public class Customer implements Runnable {
    private Restaurant restaurant;
    private Food orderFood;
    private final int id;

    public Customer(Restaurant restaurant, Food food, int id) {
        this.restaurant = restaurant;
        this.orderFood = food;
        this.id = id;
        System.out.println(this + " order " + food);
    }

    @Override
    public void run() {
        try {
            restaurant.setOrder(this);
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Customer" + id + " got " + restaurant.getFinishFood());
    }

    public Food getOrderFood() {
        return orderFood;
    }

    @Override
    public String toString() {
        return "Customer" + id;
    }
}
