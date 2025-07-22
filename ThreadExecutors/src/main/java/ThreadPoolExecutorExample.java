import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args){
        System.out.println("Creating a new thread pool with 2 core, 3 max Pool size, 5 seconds of keep alive");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Runnable r1 = new RunnableExample();

        for(int i = 0;i<3;i++){
            System.out.println(executor.getActiveCount()+" Active threads currently");
            executor.submit(r1);
            System.out.println(executor.getTaskCount()+ "Are the task currently");
        }

        executor.shutdown();
    }
}
