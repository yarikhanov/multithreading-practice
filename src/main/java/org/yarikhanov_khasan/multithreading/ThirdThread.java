package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class ThirdThread implements Runnable{
   private final Semaphore s;

    public ThirdThread(Semaphore s) {
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            s.acquire();
            Foo foo = new Foo();
            foo.third();
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }
}
