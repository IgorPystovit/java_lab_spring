package multithreading.synchronizedwithscreen;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScreenSynchronization {
    private static Object screenlocker = new Object();
    private static Object screenlocker1 = new Object();
    private static Object screenlocker2 = new Object();

    private void firstMethod(){
        synchronized (screenlocker){
            System.out.println("FirstMethod");
            System.out.println(LocalDateTime.now());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    private void secondMethod(){
        synchronized (screenlocker1){
            System.out.println("SecondMethod");
            System.out.println(LocalDateTime.now());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    private void thirdMethod(){
        synchronized (screenlocker2){
            System.out.println("ThirdMethod");
            System.out.println(LocalDateTime.now());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    private Runnable firstTask = () -> firstMethod();
    private Runnable secondTask = () -> secondMethod();
    private Runnable thirdRask = () -> thirdMethod();

    public void show(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println("Start "+LocalDateTime.now());
        executorService.submit(firstTask);
        executorService.submit(secondTask);
        executorService.submit(thirdRask);
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ScreenSynchronization().show();
    }
}
