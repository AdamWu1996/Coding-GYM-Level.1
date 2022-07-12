public class Customer implements Runnable {
    private Waiter waiter;

    public Customer(Waiter waiter,Food food) {
        this.waiter = waiter;
    }

    @Override
    public void run() {
//        try{
//            while(true){
//                Food orderFood = this.waiter.getFood();
//            }
//        }
    }
}
