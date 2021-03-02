package com.tencent.h.c;

public abstract class g<T> {
    private volatile T mInstance;

    /* access modifiers changed from: protected */
    public abstract T oR();

    public final T get() {
        T t = this.mInstance;
        if (t == null) {
            synchronized (this) {
                t = this.mInstance;
                if (t == null) {
                    t = oR();
                    this.mInstance = t;
                }
            }
        }
        return t;
    }
}
