package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new FirstThread(semaphore);
        new SecondThread(semaphore);
        new ThirdThread(semaphore);
    }
}