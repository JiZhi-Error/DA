package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Monitor {
    private static native void nativeInit(String str, int i2, String str2);

    private static native void nativeOnlineLog(int i2, String str, String str2, int i3);

    private static native void nativeOnlineLogWithLimit(int i2, int i3, String str, String str2, int i4, int i5);

    private static native void nativeUnInit();

    public static void a(String str, int i2, String str2) {
        AppMethodBeat.i(14411);
        nativeInit(str, i2, str2);
        AppMethodBeat.o(14411);
    }

    public static void a(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(14412);
        nativeOnlineLog(i2, str, str2, i3);
        AppMethodBeat.o(14412);
    }

    public static void a(int i2, int i3, String str, String str2, int i4, int i5) {
        AppMethodBeat.i(222035);
        nativeOnlineLogWithLimit(i2, i3, str, str2, i4, i5);
        AppMethodBeat.o(222035);
    }

    public static void a() {
        AppMethodBeat.i(14413);
        nativeUnInit();
        AppMethodBeat.o(14413);
    }
}
