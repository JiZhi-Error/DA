package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h<T> {
    private c<T> RwV;
    private volatile T mInstance;
    private byte[] mLock = new byte[0];

    public h(c<T> cVar) {
        AppMethodBeat.i(133554);
        this.RwV = cVar;
        AppMethodBeat.o(133554);
    }

    public final T get() {
        AppMethodBeat.i(133555);
        if (this.mInstance == null) {
            synchronized (this.mLock) {
                try {
                    if (this.mInstance == null) {
                        this.mInstance = this.RwV.get();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(133555);
                    throw th;
                }
            }
        }
        T t = this.mInstance;
        AppMethodBeat.o(133555);
        return t;
    }
}
