package com.tencent.f.k;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static <T> T l(Class<?> cls, String str) {
        AppMethodBeat.i(183495);
        T t = (T) new a(cls, str).get();
        AppMethodBeat.o(183495);
        return t;
    }

    public static boolean d(Class<?> cls, String str, Object obj) {
        AppMethodBeat.i(183496);
        boolean eF = new a(cls, str).eF(obj);
        AppMethodBeat.o(183496);
        return eF;
    }
}
