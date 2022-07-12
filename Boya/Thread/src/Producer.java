public class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (var product = 1; product <= 10; product++) {
            try {
                clerk.setProduct(product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
