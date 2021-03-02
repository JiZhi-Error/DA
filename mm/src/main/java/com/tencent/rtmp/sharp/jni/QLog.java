package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final String ERR_KEY = "qq_error|";
    public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
    public static final String TAG_REPORTLEVEL_COLORUSER = "W";
    public static final String TAG_REPORTLEVEL_DEVELOPER = "D";
    public static final String TAG_REPORTLEVEL_USER = "E";
    public static final int USR = 1;
    public static String sBuildNumber = "";

    public static void init(Context context) {
    }

    public static boolean isColorLevel() {
        return true;
    }

    public static boolean isDevelopLevel() {
        return true;
    }

    public static void p(String str, String str2) {
    }

    public static String getStackTraceString(Throwable th) {
        AppMethodBeat.i(13894);
        String stackTraceString = Log.getStackTraceString(th);
        AppMethodBeat.o(13894);
        return stackTraceString;
    }

    public static void e(String str, int i2, String str2) {
        AppMethodBeat.i(13895);
        TXCLog.e(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13895);
    }

    public static void e(String str, int i2, String str2, Throwable th) {
        AppMethodBeat.i(13896);
        e(str, i2, str2);
        AppMethodBeat.o(13896);
    }

    public static void w(String str, int i2, String str2) {
        AppMethodBeat.i(13897);
        TXCLog.w(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13897);
    }

    public static void w(String str, int i2, String str2, Throwable th) {
        AppMethodBeat.i(13898);
        TXCLog.w(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13898);
    }

    public static void i(String str, int i2, String str2) {
        AppMethodBeat.i(13899);
        TXCLog.i(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13899);
    }

    public static void i(String str, int i2, String str2, Throwable th) {
        AppMethodBeat.i(13900);
        TXCLog.i(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13900);
    }

    public static void d(String str, int i2, String str2) {
        AppMethodBeat.i(13901);
        TXCLog.d(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13901);
    }

    public static void d(String str, int i2, String str2, Throwable th) {
        AppMethodBeat.i(13902);
        TXCLog.d(str, "[" + getReportLevel(i2) + "]" + str2);
        AppMethodBeat.o(13902);
    }

    public static String getReportLevel(int i2) {
        switch (i2) {
            case 1:
                return TAG_REPORTLEVEL_USER;
            case 2:
                return TAG_REPORTLEVEL_COLORUSER;
            case 3:
            default:
                return TAG_REPORTLEVEL_USER;
            case 4:
                return TAG_REPORTLEVEL_DEVELOPER;
        }
    }

    public static void dumpCacheToFile() {
    }
}
