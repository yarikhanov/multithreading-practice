package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Fooo {
    private final Semaphore semOne;
    private final Semaphore semTwo;

    public Fooo(Semaphore one, Semaphore two) {
        this.semOne = one;
        this.semTwo = two;
    }


    public void first() {
        System.out.print("first");

        semOne.release();
    }

    public void second() {
        try {
            semOne.acquire();
            System.out.print("second");
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }finally {
            semOne.release();
            semTwo.release();
        }

    }

    public void third() {
        try {
            semTwo.acquire();
            System.out.print("third");
        }catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }finally {
            semTwo.release();
        }
    }
}
