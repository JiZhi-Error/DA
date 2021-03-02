package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SandboxSysUtils {
    private static final String TAG = "SandboxSysUtils";
    private static Boolean sLowEndDevice = null;

    private SandboxSysUtils() {
    }

    @CalledByNative
    public static synchronized boolean isLowEndDevice() {
        boolean booleanValue;
        synchronized (SandboxSysUtils.class) {
            AppMethodBeat.i(53765);
            if (sLowEndDevice == null) {
                RuntimeException runtimeException = new RuntimeException("has not set SandboxBuildInfo");
                AppMethodBeat.o(53765);
                throw runtimeException;
            }
            booleanValue = sLowEndDevice.booleanValue();
            AppMethodBeat.o(53765);
        }
        return booleanValue;
    }

    public static synchronized void setIsLowEndDevice(boolean z) {
        synchronized (SandboxSysUtils.class) {
            AppMethodBeat.i(53766);
            sLowEndDevice = Boolean.valueOf(z);
            AppMethodBeat.o(53766);
        }
    }
}
