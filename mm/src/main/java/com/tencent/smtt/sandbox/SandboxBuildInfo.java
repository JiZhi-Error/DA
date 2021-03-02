package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SandboxBuildInfo {
    private static final String TAG = "SandboxBuildInfo";
    private static String[] mSandboxBuildInfo = null;

    private SandboxBuildInfo() {
    }

    @CalledByNative
    public static String[] getAll() {
        AppMethodBeat.i(53816);
        if (mSandboxBuildInfo == null) {
            RuntimeException runtimeException = new RuntimeException("has not set SandboxBuildInfo");
            AppMethodBeat.o(53816);
            throw runtimeException;
        }
        String[] strArr = mSandboxBuildInfo;
        AppMethodBeat.o(53816);
        return strArr;
    }

    public static void setSandboxBuildInfo(String[] strArr) {
        mSandboxBuildInfo = strArr;
    }
}
