package com.tencent.mm.audio.mix.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;

public final class e<T> {
    private T dxN;

    public e(T t) {
        this.dxN = t;
    }

    public final synchronized T aU(T t) {
        T t2;
        AppMethodBeat.i(136943);
        t2 = this.dxN;
        this.dxN = t;
        b.i("StateRunner", t2.toString() + " -> " + this.dxN.toString());
        AppMethodBeat.o(136943);
        return t2;
    }

    public final synchronized boolean f(T... tArr) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(136944);
            int i2 = 0;
            while (true) {
                if (i2 > 0) {
                    AppMethodBeat.o(136944);
                    break;
                }
                if (this.dxN.equals(tArr[0])) {
                    z = true;
                    AppMethodBeat.o(136944);
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public final synchronized T get() {
        return this.dxN;
    }
}
