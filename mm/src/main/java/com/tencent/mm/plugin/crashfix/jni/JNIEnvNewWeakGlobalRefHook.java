package com.tencent.mm.plugin.crashfix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class JNIEnvNewWeakGlobalRefHook {
    public static native void calculateOffset();

    public static native void hook(Method method, Method method2);

    public static void init() {
        AppMethodBeat.i(145626);
        System.loadLibrary("systemcrashprotect");
        AppMethodBeat.o(145626);
    }
}
