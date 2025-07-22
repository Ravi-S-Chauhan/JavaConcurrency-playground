import java.util.Date;
import java.util.concurrent.*;

public class ScheduleThreadPoolExecutorExample {
    public static void main(String[] args){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable r1 = new RunnableExample();

        for(int i=0;i<4;i++){
            System.out.println("starting the delay for the task"+ new Date());
            executor.schedule(r1,3, TimeUnit.SECONDS);
            System.out.println("Now the task is scheduled" + new Date());
        }

        System.out.println("delay of 2 second and period of 2 second "+new Date());
        executor.scheduleAtFixedRate(()->System.out.println("new task\n"),1,2,TimeUnit.SECONDS);
        System.out.println("Now the task is scheduled" + new Date());


        executor.shutdown();

        System.out.println("Shutdown intimated");


        executor.shutdownNow();
    }
}
