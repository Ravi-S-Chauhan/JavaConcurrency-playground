import java.util.Date;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"currently executing " + new Date());
        try{
            wait(2000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName()+" done with execution " + new Date());
        }

    }
}
