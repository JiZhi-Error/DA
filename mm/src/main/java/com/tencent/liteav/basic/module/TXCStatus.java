package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCStatus {
    private static native double nativeStatusGetDoubleValue(String str, int i2, int i3);

    private static native long nativeStatusGetIntValue(String str, int i2, int i3);

    private static native String nativeStatusGetStrValue(String str, int i2, int i3);

    private static native boolean nativeStatusSetDoubleValue(String str, int i2, int i3, double d2);

    private static native boolean nativeStatusSetIntValue(String str, int i2, int i3, long j2);

    private static native boolean nativeStatusSetStrValue(String str, int i2, int i3, String str2);

    private static native void nativeStatusStartRecord(String str);

    private static native void nativeStatusStopRecord(String str);

    public static void a(String str) {
        AppMethodBeat.i(14436);
        nativeStatusStartRecord(str);
        AppMethodBeat.o(14436);
    }

    public static void b(String str) {
        AppMethodBeat.i(14437);
        nativeStatusStopRecord(str);
        AppMethodBeat.o(14437);
    }

    public static boolean a(String str, int i2, Object obj) {
        AppMethodBeat.i(14438);
        boolean a2 = a(str, i2, 0, obj);
        AppMethodBeat.o(14438);
        return a2;
    }

    public static boolean a(String str, int i2, int i3, Object obj) {
        AppMethodBeat.i(14439);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(14439);
            return false;
        } else if (obj == null) {
            AppMethodBeat.o(14439);
            return false;
        } else if (obj instanceof Double) {
            boolean nativeStatusSetDoubleValue = nativeStatusSetDoubleValue(str, i2, i3, ((Double) obj).doubleValue());
            AppMethodBeat.o(14439);
            return nativeStatusSetDoubleValue;
        } else if (obj instanceof String) {
            boolean nativeStatusSetStrValue = nativeStatusSetStrValue(str, i2, i3, (String) obj);
            AppMethodBeat.o(14439);
            return nativeStatusSetStrValue;
        } else if (obj instanceof Long) {
            boolean nativeStatusSetIntValue = nativeStatusSetIntValue(str, i2, i3, ((Long) obj).longValue());
            AppMethodBeat.o(14439);
            return nativeStatusSetIntValue;
        } else {
            boolean nativeStatusSetIntValue2 = nativeStatusSetIntValue(str, i2, i3, (long) ((Integer) obj).intValue());
            AppMethodBeat.o(14439);
            return nativeStatusSetIntValue2;
        }
    }

    public static long a(String str, int i2) {
        AppMethodBeat.i(14440);
        long a2 = a(str, i2, 0);
        AppMethodBeat.o(14440);
        return a2;
    }

    public static String b(String str, int i2) {
        AppMethodBeat.i(14441);
        String b2 = b(str, i2, 0);
        AppMethodBeat.o(14441);
        return b2;
    }

    public static int c(String str, int i2) {
        AppMethodBeat.i(14442);
        int c2 = c(str, i2, 0);
        AppMethodBeat.o(14442);
        return c2;
    }

    public static double d(String str, int i2) {
        AppMethodBeat.i(14443);
        double d2 = d(str, i2, 0);
        AppMethodBeat.o(14443);
        return d2;
    }

    public static long a(String str, int i2, int i3) {
        AppMethodBeat.i(14444);
        long nativeStatusGetIntValue = nativeStatusGetIntValue(str, i2, i3);
        AppMethodBeat.o(14444);
        return nativeStatusGetIntValue;
    }

    public static String b(String str, int i2, int i3) {
        AppMethodBeat.i(14445);
        String nativeStatusGetStrValue = nativeStatusGetStrValue(str, i2, i3);
        AppMethodBeat.o(14445);
        return nativeStatusGetStrValue;
    }

    public static int c(String str, int i2, int i3) {
        AppMethodBeat.i(14446);
        int nativeStatusGetIntValue = (int) nativeStatusGetIntValue(str, i2, i3);
        AppMethodBeat.o(14446);
        return nativeStatusGetIntValue;
    }

    public static double d(String str, int i2, int i3) {
        AppMethodBeat.i(14447);
        double nativeStatusGetDoubleValue = nativeStatusGetDoubleValue(str, i2, i3);
        AppMethodBeat.o(14447);
        return nativeStatusGetDoubleValue;
    }
}
