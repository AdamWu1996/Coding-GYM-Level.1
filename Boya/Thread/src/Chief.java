public class Chief extends Thread{
    public void run(){
        System.out.println(this);
        synchronized (this) {
            System.out.println("Thunder!!");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("END");
        }
    }
}
