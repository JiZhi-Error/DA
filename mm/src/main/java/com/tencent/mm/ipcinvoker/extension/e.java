package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T> {
    private volatile T hnx;
    private Class<T> targetClass;

    public e(Class<T> cls) {
        AppMethodBeat.i(158799);
        Assert.assertNotNull(cls);
        this.targetClass = cls;
        AppMethodBeat.o(158799);
    }

    public final T get() {
        AppMethodBeat.i(158800);
        if (this.hnx == null) {
            synchronized (this) {
                try {
                    if (this.hnx == null) {
                        this.hnx = (T) b.ac(this.targetClass);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158800);
                    throw th;
                }
            }
        }
        T t = this.hnx;
        AppMethodBeat.o(158800);
        return t;
    }
}
