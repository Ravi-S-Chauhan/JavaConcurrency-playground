import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class newFixedThreadPool {

    public static void main(String[] args){
        System.out.println("Creating a fixed thread pool with 3 threads");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable r1 = new RunnableExample();
        System.out.println("Submitting 5 task to the executor service");
        for(int i=0;i<5;i++){
            executor.submit(r1);
        }
        System.out.println("All the tasks are completed using fixedThreadPool");
        executor.shutdown();
        System.out.println("Shutdown executor service");
    }
}
