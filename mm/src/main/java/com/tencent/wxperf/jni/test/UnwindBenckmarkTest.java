package com.tencent.wxperf.jni.test;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnwindBenckmarkTest {
    public static native void benchmarkInitNative();

    public static native void benchmarkNative();

    public static native void debugNative();

    static {
        AppMethodBeat.i(199070);
        System.loadLibrary("wxperf-jni");
        AppMethodBeat.o(199070);
    }
}
