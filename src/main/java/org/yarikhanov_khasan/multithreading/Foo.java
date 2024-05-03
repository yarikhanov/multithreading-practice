package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore s;

    public Foo(Semaphore s) {
        this.s = s;
    }


    public void first() {
        try {
            s.acquire();
            System.out.print("first");
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }

    public void second() {
        try {
            s.acquire();
            System.out.print("second");
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }

    public void third() {
        try {
            s.acquire();
            System.out.print("third");
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }finally {
            s.release();
        }
    }
}
