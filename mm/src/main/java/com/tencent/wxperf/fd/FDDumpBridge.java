package com.tencent.wxperf.fd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public class FDDumpBridge {
    private static boolean initialized;

    public static native int getFDLimit();

    public static native String getFdPathNameNative(String str);

    static {
        AppMethodBeat.i(224177);
        try {
            System.loadLibrary("wxperf-fd");
            initialized = true;
            AppMethodBeat.o(224177);
        } catch (Throwable th) {
            Log.printStack(6, "FDDumpBridge", th);
            initialized = false;
            AppMethodBeat.o(224177);
        }
    }

    public static String brC(String str) {
        AppMethodBeat.i(224176);
        if (!initialized) {
            AppMethodBeat.o(224176);
            return str;
        }
        String fdPathNameNative = getFdPathNameNative(str);
        AppMethodBeat.o(224176);
        return fdPathNameNative;
    }
}
