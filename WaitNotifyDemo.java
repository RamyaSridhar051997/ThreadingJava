package thread;

class SharedResource {
    public synchronized void produce() throws InterruptedException {
        System.out.println("Producing...");
        wait(); // Wait until notified
        Thread.sleep(3000);
        System.out.println("Resumed after notification!");
    }

    public synchronized void consume() throws InterruptedException {
        Thread.sleep(5000); // Simulate some processing delay
        System.out.println("Consuming...");
        notify(); // Notify a waiting thread
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

