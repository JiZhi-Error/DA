package com.tencent.luggage.natives;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuggageNativeViewJni {
    private static String TAG = "LuggageNativeViewJni";
    private long cyb = -1;

    private native long createNativeRender();

    private native void destroyNativeRender(long j2);

    private native long getPageViewPtr(long j2);

    private native void initJsBinding(long j2, long j3, long j4);

    private native void onPageViewCreate(long j2, String str);

    private native void setDisplayParams(long j2, float f2, float f3, float f4, float f5, int i2, float f6);

    static {
        AppMethodBeat.i(140472);
        System.loadLibrary("wechatlv");
        AppMethodBeat.o(140472);
    }
}
