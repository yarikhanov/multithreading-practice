package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class SecondThread implements Runnable{
    private Semaphore s;

    public SecondThread(Semaphore s) {
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            s.acquire();
            Foo foo = new Foo();
            foo.second();
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }
}
