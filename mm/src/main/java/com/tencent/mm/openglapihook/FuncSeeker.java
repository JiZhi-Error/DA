package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FuncSeeker {
    private static native int getGlGetErrorIndex();

    private static native int getTargetFuncIndex(String str);

    static {
        AppMethodBeat.i(187608);
        System.loadLibrary("openglapihook");
        AppMethodBeat.o(187608);
    }

    public static int getFuncIndex(String str) {
        AppMethodBeat.i(187607);
        if (str.equals("glGetError")) {
            int glGetErrorIndex = getGlGetErrorIndex();
            AppMethodBeat.o(187607);
            return glGetErrorIndex;
        } else if (str.startsWith("glGen") || str.startsWith("glDelete")) {
            int targetFuncIndex = getTargetFuncIndex(str);
            AppMethodBeat.o(187607);
            return targetFuncIndex;
        } else {
            AppMethodBeat.o(187607);
            return -100;
        }
    }
}
