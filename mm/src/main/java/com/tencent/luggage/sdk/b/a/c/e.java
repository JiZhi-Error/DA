package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.a;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends a<b.a, f, d> {
    private static e cBk = null;

    public static e Oy() {
        AppMethodBeat.i(146850);
        if (cBk == null) {
            synchronized (e.class) {
                try {
                    if (cBk == null) {
                        cBk = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(146850);
                    throw th;
                }
            }
        }
        e eVar = cBk;
        AppMethodBeat.o(146850);
        return eVar;
    }
}
