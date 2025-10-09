import java.util.concurrent.*;

public class FutureAndCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("This is a placeholder for Future and CompletableFuture examples.");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(()->5);
        Integer f = future.get();
        System.out.println(f);
    }
}