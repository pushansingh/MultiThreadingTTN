import java.util.concurrent.*;

public class ThreadPoolTwo {
    public static void main(String[] args) {
        System.out.println("Executor Service using newFixedThreadPool");
        ExecutorService ex2 = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5 ; i++) {
            ex2.submit(() -> {
                System.out.println("Submitting task");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        ex2.shutdown();

        try {
            ex2.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("......Task terminated.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}