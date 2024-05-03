package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        Foo foo = new Foo(phaser);
        new Thread(foo::third).start();
        new Thread(foo::second).start();
        new Thread(foo::first).start();

        Semaphore one = new Semaphore(0);
        Semaphore two = new Semaphore(0);
        Fooo fooo = new Fooo(one , two);
        new Thread(fooo::third).start();
        new Thread(fooo::second).start();
        new Thread(fooo::first).start();
    }
}