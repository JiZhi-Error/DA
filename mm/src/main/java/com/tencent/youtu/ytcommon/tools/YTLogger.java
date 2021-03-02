package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTLogger {
    private static IFaceLiveLogger iFaceLiveLogger;
    private static boolean sEnableLog = false;
    private static boolean sEnableNativeLog = false;

    public interface IFaceLiveLogger {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    public static void setLog(IFaceLiveLogger iFaceLiveLogger2) {
        iFaceLiveLogger = iFaceLiveLogger2;
    }

    public static void setIsEnabledLog(boolean z) {
        sEnableLog = z;
    }

    public static void setIsEnabledNativeLog(boolean z) {
        sEnableNativeLog = z;
    }

    public static boolean isEnableLog() {
        return sEnableLog;
    }

    public static boolean isEnableNativeLog() {
        return sEnableNativeLog;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(73387);
        if (!sEnableLog) {
            AppMethodBeat.o(73387);
            return;
        }
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.v(str, str2);
        }
        AppMethodBeat.o(73387);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(73388);
        if (!sEnableLog) {
            AppMethodBeat.o(73388);
            return;
        }
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.d(str, str2);
        }
        AppMethodBeat.o(73388);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(73389);
        if (!sEnableLog) {
            AppMethodBeat.o(73389);
            return;
        }
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.i(str, str2);
        }
        AppMethodBeat.o(73389);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(73390);
        if (!sEnableLog) {
            AppMethodBeat.o(73390);
            return;
        }
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.w(str, str2);
        }
        AppMethodBeat.o(73390);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(73391);
        if (iFaceLiveLogger != null) {
            iFaceLiveLogger.e(str, str2);
        }
        AppMethodBeat.o(73391);
    }
}
