import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newCachedThreadPool {

    public static void main(String[] args){
        System.out.println("Creating a new cachedTHread pool");
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable r1 = new RunnableExample();
        System.out.println("Submitting 5 tasks to executor of newCachedTHreadPool");
        for(int i=0;i<5;i++){
            executor.submit(r1);
        }
        System.out.println("All tasks are submitted");
        executor.shutdown();
        System.out.println("Executor shutdown");
    }
}
