package com.tencent.h.a;

public abstract class a implements Runnable {
    public abstract void boF();

    public void run() {
        try {
            boF();
        } catch (Throwable th) {
        }
    }
}
