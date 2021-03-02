package com.tencent.e.e.a.a;

public abstract class c implements Runnable {
    public abstract void boF();

    public abstract void hkE();

    public void run() {
        try {
            boF();
        } catch (Throwable th) {
            hkE();
        }
    }
}
