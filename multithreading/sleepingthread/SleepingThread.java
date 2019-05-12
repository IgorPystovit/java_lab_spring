package multithreading.sleepingthread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SleepingThread {
    private static Random random = new Random();

    public Callable<Integer> sleepingThread = () -> {
            System.out.println(Thread.currentThread().getName());
            int sleepTime = random.nextInt(10000);
            try{
                Thread.sleep(sleepTime);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Sleep time="+sleepTime);
            return sleepTime;
    };

    public List<Callable<Integer>> createTasks(int numberOfTasks){
        List<Callable<Integer>> tasks = new LinkedList<>();
        for (int i = 0; i < numberOfTasks; i++){
            tasks.add(sleepingThread);
        }
        return tasks;
    }

    public void executeSleeping(int numberOfTasks){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        try{
            executorService.invokeAll(createTasks(numberOfTasks));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new SleepingThread().executeSleeping(4);
    }
}
