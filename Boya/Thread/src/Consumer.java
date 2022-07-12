public class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                clerk.getProduct();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
