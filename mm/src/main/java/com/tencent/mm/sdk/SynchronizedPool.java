package com.tencent.mm.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;

public class SynchronizedPool<T> extends SimpleObjectPool<T> {
    private final Object mLock = new Object();

    public SynchronizedPool(int i2) {
        super(i2);
        AppMethodBeat.i(157515);
        AppMethodBeat.o(157515);
    }

    @Override // com.tencent.mm.sdk.platformtools.SimpleObjectPool
    public T acquire() {
        T t;
        AppMethodBeat.i(157516);
        synchronized (this.mLock) {
            try {
                t = (T) super.acquire();
            } finally {
                AppMethodBeat.o(157516);
            }
        }
        return t;
    }

    @Override // com.tencent.mm.sdk.platformtools.SimpleObjectPool
    public boolean release(T t) {
        boolean release;
        AppMethodBeat.i(157517);
        synchronized (this.mLock) {
            try {
                release = super.release(t);
            } finally {
                AppMethodBeat.o(157517);
            }
        }
        return release;
    }
}
