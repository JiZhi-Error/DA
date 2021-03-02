package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCEventRecorderProxy {

    /* renamed from: a  reason: collision with root package name */
    private long f411a;

    private static native void nativeAddEventMsg(String str, int i2, long j2, long j3, String str2, int i3);

    private static native void nativeRelease(long j2);

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(14409);
        nativeRelease(this.f411a);
        this.f411a = 0;
        super.finalize();
        AppMethodBeat.o(14409);
    }

    public static void a(String str, int i2, long j2, long j3, String str2, int i3) {
        AppMethodBeat.i(170216);
        if (str == null || str2 == null) {
            AppMethodBeat.o(170216);
            return;
        }
        nativeAddEventMsg(str, i2, j2, j3, str2, i3);
        AppMethodBeat.o(170216);
    }
}
