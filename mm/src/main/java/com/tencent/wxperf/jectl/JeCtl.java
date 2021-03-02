package com.tencent.wxperf.jectl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public class JeCtl {
    private static boolean initialized;

    private static native int compactNative();

    private static native String getVersionNative();

    private static native void initNative();

    private static native int preAllocRetainNative(int i2, int i3, int i4, int i5);

    static {
        AppMethodBeat.i(216710);
        initialized = false;
        try {
            System.loadLibrary("wxperf-jectl");
            initNative();
            initialized = true;
            AppMethodBeat.o(216710);
        } catch (Throwable th) {
            Log.printStack(6, "Wxperf.JeCtl", th);
            AppMethodBeat.o(216710);
        }
    }

    public static synchronized String version() {
        String versionNative;
        synchronized (JeCtl.class) {
            AppMethodBeat.i(216709);
            if (!initialized) {
                Log.e("Wxperf.JeCtl", "JeCtl init failed! check if so exists");
                versionNative = "VER_UNKNOWN";
                AppMethodBeat.o(216709);
            } else {
                versionNative = getVersionNative();
                AppMethodBeat.o(216709);
            }
        }
        return versionNative;
    }
}
