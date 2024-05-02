package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class FirstThread implements Runnable{
    Semaphore s;

    public FirstThread(Semaphore s) {
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            s.acquire();
            Foo foo = new Foo();
            foo.first();
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }
}
