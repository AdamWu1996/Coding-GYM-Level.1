public class ConsumerThread implements Runnable{
    private Channel channel;

    public ConsumerThread(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            String message = this.channel.take();
            System.out.println("Consumer:" + message);
        }
    }
}
