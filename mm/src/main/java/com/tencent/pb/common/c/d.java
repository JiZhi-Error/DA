package com.tencent.pb.common.c;

public abstract class d<T> {
    private T mInstance;

    /* access modifiers changed from: protected */
    public abstract T oR();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = oR();
            }
            t = this.mInstance;
        }
        return t;
    }
}
