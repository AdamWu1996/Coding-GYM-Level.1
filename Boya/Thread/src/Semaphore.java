public class Semaphore {
    private int value;

    public Semaphore(int value) {
        this.value = value;
    }

    synchronized void acquire(){
        while (value == 0){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value--;
    }

    synchronized void realse(){
        value++;
        if(value == 1){
            notifyAll();
        }
    }
}
