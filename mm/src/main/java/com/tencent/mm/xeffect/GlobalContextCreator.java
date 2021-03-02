package com.tencent.mm.xeffect;

import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlobalContextCreator {
    private static native boolean nCheckCreateGlobalContext(String str);

    private static native void nDestroyGlobalContext();

    private static native boolean nIsContextReady();

    public static boolean bpC(String str) {
        AppMethodBeat.i(236739);
        if (EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            XEffectLog.e("GlobalContextCreator", "checkCreateGlobalContext, current thread does not have gl context!", new Object[0]);
            AppMethodBeat.o(236739);
            return false;
        }
        boolean nCheckCreateGlobalContext = nCheckCreateGlobalContext(str);
        AppMethodBeat.o(236739);
        return nCheckCreateGlobalContext;
    }

    public static void hir() {
        AppMethodBeat.i(236740);
        nDestroyGlobalContext();
        AppMethodBeat.o(236740);
    }
}
