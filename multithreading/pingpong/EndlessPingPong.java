package multithreading.pingpong;

public class EndlessPingPong extends Thread{
    private static Object screenlocker = new Object();
    private Thread ping = new Thread(()->{
        synchronized (screenlocker){
            while (true){
                try{
                    screenlocker.wait();
                    System.out.println("Ping");
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("Sleep thread has benn interrupted");
                    e.printStackTrace(System.err);
                }
                screenlocker.notify();
            }
        }
    },"Ping");
    private Thread pong = new Thread(()->{
        synchronized (screenlocker){
            while (true){
                screenlocker.notify();
                try{
                    Thread.sleep(1000);
                    screenlocker.wait();
                    System.out.println("Pong");
                } catch (InterruptedException e){
                    System.out.println("Sleep thread has benn interrupted");
                    e.printStackTrace(System.err);
                }
            }
        }

    },"Pong");

    public void play(){
        ping.start();
        pong.start();

        try{
            ping.join();
            pong.join();
        } catch (InterruptedException e){
            e.printStackTrace(System.err);
        }

    }

    public static void main(String[] args) {
        new EndlessPingPong().play();
    }
}
