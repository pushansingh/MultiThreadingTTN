package multi_threading;
import java.util.concurrent.*;

public class ThreadPoolThree {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        ExecutorService ex3 = Executors.newCachedThreadPool();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) ex3;
        System.out.println("Executor Service using newCachedThreadPool");
        ex3.submit(runnable);
        ex3.submit(runnable);
        ex3.submit(runnable);
        System.out.println("Total number of threads scheduled: "+ pool.getTaskCount());
        ex3.shutdown();
        try {
            ex3.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("......Task terminated.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}