public class ProducerThread implements Runnable {
    private Channel channel;
    private static int id = 0;

    public ProducerThread(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(1000L);
                String message = "message-" + nextId();
                System.out.println("Producer:" + message);
                this.channel.put(message);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
