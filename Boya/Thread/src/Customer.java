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
            synchronized (this){
                restaurant.setOrder(this);
                wait();
                System.out.println("Customer" + id + " got " + restaurant.getFinishFood());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Food getOrderFood() {
        return orderFood;
    }

    @Override
    public String toString() {
        return "Customer" + id;
    }
}
