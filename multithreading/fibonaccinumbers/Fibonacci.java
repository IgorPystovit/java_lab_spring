package multithreading.fibonaccinumbers;

import java.util.*;
import java.util.concurrent.*;

public class Fibonacci {

    private class Task  {
        private int numCount;
        public Task(){}
        public Task(int numCount){
            this.numCount = numCount;
        }

        private Runnable fibonacciRunnable = () -> {
                int numCountCopy = numCount;
                int prev = 0;
                int current = 1;
                int next = 0;

                System.out.print(Thread.currentThread().getName()+" : ");

                while (numCountCopy > 0) {
                    System.out.print(prev + " ");
                    next = prev + current;
                    int temp = current;
                    current = next;
                    prev = temp;
                    numCountCopy--;
                }
                System.out.println();
        };

        private Callable<List<Integer>> fibonacciCallable = () -> {
                List<Integer> fibonacciNumbers = new LinkedList<>();
                int prev = 0;
                int current = 1;
                int next = 0;

                while (numCount > 0) {
                    fibonacciNumbers.add(prev);
                    next = prev + current;
                    int temp = current;
                    current = next;
                    prev = temp;
                    numCount--;
                }
                return fibonacciNumbers;
        };

        private Callable<Integer> sumFibonacciNumbers =  () -> {
                int sum = 0;
                for (Integer integer : fibonacciCallable.call()){
                    sum += integer;
                }
                return sum;
        };
    }

    @SuppressWarnings("unchecked")
    public static <T> void printFutures(Collection<Future<T>> futures){
        try{
            for (Future<?> future : futures){
                if (future.get() instanceof Collection){
                    for (T temp : (Collection<T>)future.get()){
                         System.out.print(temp+" ");
                    }
                System.out.println();
                }
                else{
                    System.out.println(future.get());
                }
            }
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace(System.err);
        }
    }

    public void cachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> futureFibonacciRun = executorService.submit(new Task(15).fibonacciCallable);
        Future<?> futureFibonacciCall = executorService.submit(new Task(5).fibonacciRunnable);

    }

    public void threadScheduledExecutor(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> futureFibonacciList = executorService.scheduleWithFixedDelay(new Task(7).fibonacciRunnable,5000,1000,TimeUnit.MILLISECONDS);
        ScheduledFuture<?> futureFibonacciList1 = executorService.scheduleWithFixedDelay(new Task(4).fibonacciRunnable,2500,2000,TimeUnit.MILLISECONDS);
    }

    public void singleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<List<Integer>>> callables = new ArrayList<>(Arrays.asList(new Task(9).fibonacciCallable,new Task(20).fibonacciCallable));
        try{
            printFutures(executorService.invokeAll(callables));
        } catch (InterruptedException e){
            e.printStackTrace(System.err);
        }
        executorService.shutdown();
    }

    public void threadFibonacci(){
        Thread thread = new Thread(new Task(20).fibonacciRunnable,"Fibonacci-20");
        Thread thread1 = new Thread(new Task(10).fibonacciRunnable,"Fibonacci-10");
        Thread thread2 = new Thread(new Task(5).fibonacciRunnable,"Fibonacci-5");
        thread.start();
        thread1.start();
        thread2.start();
        try{
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace(System.err);
        }
    }

    public int sumFibonacciNumbers(){
        int resultInt = 0;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> resultFuture = executorService.submit(new Task(5).sumFibonacciNumbers);
        Future<Integer> resultFuture2 = executorService.submit(new Task(20).sumFibonacciNumbers);
        try{
            System.out.println(resultFuture.get());
            System.out.println(resultFuture2.get());
            resultInt = resultFuture.get();
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executorService.shutdown();
        return resultInt;
    }
    public static void main(String[] args) {
        new Fibonacci().singleThreadExecutor();
    }
}
