public class Clerk {
    private final int EMPTY = 0;
    private int product = EMPTY;

    synchronized void setProduct(int product) throws InterruptedException {
        while (this.product != EMPTY) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.product = product;
        System.out.println("Clerk set product:" + this.product + " to " + product);
        notifyAll();
    }

    synchronized int getProduct() throws InterruptedException {
        while (this.product == EMPTY) {
            wait();
        }
        var p = this.product;
        this.product = EMPTY;
        System.out.println("get product:" + p);
        notifyAll();
        return p;
    }
}
