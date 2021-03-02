package com.tencent.kinda;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConstructProxy {
    private static native void proxyDefaultConstructor(String str, String str2);

    public static void proxyDefaultConstructor(Class cls, String str) {
        AppMethodBeat.i(135629);
        if (!(cls == null || str == null)) {
            proxyDefaultConstructor(cls.getName(), str);
        }
        AppMethodBeat.o(135629);
    }
}
