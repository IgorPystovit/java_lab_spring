package com.igorpystovit.model;

public class AutoCloseableRes implements AutoCloseable{
    public AutoCloseableRes() throws InterruptedException{
        System.out.println("Resource has been opened");
        Thread.sleep(1000);
    }

    public static void test(){
        try(AutoCloseableRes autoCloseable = new AutoCloseableRes()){
            System.out.println("Autocloseable invokation");
        } catch (InterruptedException | CloseException e){
            System.out.println(e);
        }
    }
    public void close() throws CloseException{
        System.out.println("Resource has been closed");
        throw new CloseException();
    }
}
