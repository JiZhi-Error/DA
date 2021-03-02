package com.tencent.tmediacodec.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static String SmV = "TMediaCodec";
    private static boolean SmW = true;
    private static a SmX = new a() {
        /* class com.tencent.tmediacodec.g.b.AnonymousClass1 */
    };
    private static String TAG = "LogUtils";
    private static int mLogLevel = 2;

    static {
        AppMethodBeat.i(190190);
        AppMethodBeat.o(190190);
    }

    public static void bqP(String str) {
        AppMethodBeat.i(190183);
        if (asw(2)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190183);
    }

    public static void bqQ(String str) {
        AppMethodBeat.i(190184);
        if (asw(3)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190184);
    }

    public static void bqR(String str) {
        AppMethodBeat.i(190185);
        if (asw(4)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190185);
    }

    public static void bqS(String str) {
        AppMethodBeat.i(190186);
        if (asw(5)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190186);
    }

    public static void bqT(String str) {
        AppMethodBeat.i(190187);
        if (asw(5)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190187);
    }

    public static void bqU(String str) {
        AppMethodBeat.i(190188);
        if (asw(6)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190188);
    }

    public static void bqV(String str) {
        AppMethodBeat.i(190189);
        if (asw(6)) {
            new StringBuilder().append(SmV).append(".").append(str);
        }
        AppMethodBeat.o(190189);
    }

    private static boolean asw(int i2) {
        return SmW && i2 >= mLogLevel;
    }

    public static boolean isLogEnable() {
        return SmW;
    }
}
