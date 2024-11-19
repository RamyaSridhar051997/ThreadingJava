package thread;

public class LambdaThreadDemo {
    public static void main(String[] args) {
        // Creating and starting a thread using a lambda expression
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        });

        thread1.setName("Lambda-Thread");
        thread1.start();

        // Main thread loop
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Main Count: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}

