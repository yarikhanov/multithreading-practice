package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Foo foo = new Foo(semaphore);
        new Thread(foo::first).start();
        new Thread(foo::second).start();
        new Thread(foo::third).start();
    }
}