package thread;


	// Class that extends Thread
	class MyThread extends Thread {
	    @Override
	    public void run() {
	        for (int i = 0; i < 5; i++) {
	            System.out.println(Thread.currentThread().getName() + " - Count(MyThread): " + i);
	            try {
	                Thread.sleep(500); // Sleep for 500 milliseconds
	            } catch (InterruptedException e) {
	                System.out.println("Thread interrupted in MyThread");
	            }
	        }
	    }
	}

	// Class that implements Runnable
	class MyRunnable implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 0; i < 5; i++) {
	            System.out.println(Thread.currentThread().getName() + " - Count(MyRunnable): " + i);
	            try {
	                Thread.sleep(500); // Sleep for 500 milliseconds
	            } catch (InterruptedException e) {
	                System.out.println("Thread interrupted in MyRunnable");
	            }
	        }
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        // Create and start a thread using the Thread class
	    	System.out.println("Starting main thread");
	        MyThread thread1 = new MyThread();
	        thread1.setName("Thread-1");
	        thread1.start();

	        // Create and start a thread using the Runnable interface
	        Thread thread2 = new Thread(new MyRunnable());
	        thread2.setName("Thread-2");
	        thread2.start();

	        // Main thread loop
	        for (int i = 0; i < 5; i++) {
	            System.out.println(Thread.currentThread().getName() + " - Main Count: " + i);
	            try {
	                Thread.sleep(500); // Sleep for 500 milliseconds
	            } catch (InterruptedException e) {
	                System.out.println("Main thread interrupted");
	            }
	        }
	    }
	}


