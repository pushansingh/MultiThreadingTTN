import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args)
    {
        ExecutorService ex =Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        System.out.println("Executor Service using newSingleThreadExecutor");
        ex.submit(runnable);
        ex.shutdown();
        try{
            ex.awaitTermination(5,TimeUnit.SECONDS);
            System.out.println("......Task terminated.....");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}