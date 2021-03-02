package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCTimeUtil {
    private static native long nativeGeneratePtsMS();

    private static native long nativeGetClockTickInHz();

    private static native long nativeGetTimeTick();

    private static native long nativeGetUtcTimeTick();

    private static native void nativeInitAppStartTime();

    public static long generatePtsMS() {
        AppMethodBeat.i(14722);
        long nativeGeneratePtsMS = nativeGeneratePtsMS();
        AppMethodBeat.o(14722);
        return nativeGeneratePtsMS;
    }

    public static long getTimeTick() {
        AppMethodBeat.i(14723);
        long nativeGetTimeTick = nativeGetTimeTick();
        AppMethodBeat.o(14723);
        return nativeGetTimeTick;
    }

    public static long getUtcTimeTick() {
        AppMethodBeat.i(14724);
        long nativeGetUtcTimeTick = nativeGetUtcTimeTick();
        AppMethodBeat.o(14724);
        return nativeGetUtcTimeTick;
    }

    public static void initAppStartTime() {
        AppMethodBeat.i(14725);
        nativeInitAppStartTime();
        AppMethodBeat.o(14725);
    }

    public static long getClockTickInHz() {
        AppMethodBeat.i(14726);
        long nativeGetClockTickInHz = nativeGetClockTickInHz();
        AppMethodBeat.o(14726);
        return nativeGetClockTickInHz;
    }

    static {
        AppMethodBeat.i(14727);
        f.f();
        AppMethodBeat.o(14727);
    }
}
