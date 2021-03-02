package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T> implements b<T> {
    private Bitmap.Config aEF;
    private Class<? extends T> aWC;

    public a(Class<? extends T> cls) {
        this(cls, (byte) 0);
    }

    private a(Class<? extends T> cls, byte b2) {
        this.aWC = cls;
        this.aEF = null;
    }

    @Override // com.davemorrissey.labs.subscaleview.a.b
    public final T rG() {
        AppMethodBeat.i(157341);
        if (this.aEF == null) {
            T t = (T) this.aWC.newInstance();
            AppMethodBeat.o(157341);
            return t;
        }
        T t2 = (T) this.aWC.getConstructor(Bitmap.Config.class).newInstance(this.aEF);
        AppMethodBeat.o(157341);
        return t2;
    }
}
