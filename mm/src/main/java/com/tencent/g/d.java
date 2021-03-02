package com.tencent.g;

import com.tencent.g.e;

public abstract class d<T extends e> {
    private T[] SoP = asA(20);
    private int mCS;
    private final Object mLock = new Object();

    /* access modifiers changed from: protected */
    public abstract T[] asA(int i2);

    /* access modifiers changed from: protected */
    public abstract T hpN();

    public final T hpO() {
        T hpP = hpP();
        if (hpP == null) {
            return hpN();
        }
        hpP.reset();
        return hpP;
    }

    public final void a(T t) {
        synchronized (this.mLock) {
            if (this.mCS < this.SoP.length) {
                this.SoP[this.mCS] = t;
                this.mCS++;
            }
        }
    }

    private T hpP() {
        T t = null;
        synchronized (this.mLock) {
            if (this.mCS > 0) {
                this.mCS--;
                t = this.SoP[this.mCS];
                this.SoP[this.mCS] = null;
            }
        }
        return t;
    }
}
