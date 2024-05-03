package org.yarikhanov_khasan.multithreading;

import java.util.concurrent.Phaser;

public class Foo {
    private final Phaser p;

    public Foo(Phaser p) {
        this.p = p;
        p.register();
    }


    public void first() {
            System.out.print("first");
            p.arrive();
    }

    public void second() {
        while (true) {
            if (p.getPhase() == 1) {
                System.out.print("second");
                p.arrive();
                break;
            }
        }
    }

    public void third() {
        while (true) {
            if (p.getPhase() == 2) {
                System.out.print("third");
                p.arrive();
                break;
            }
        }
    }
}
