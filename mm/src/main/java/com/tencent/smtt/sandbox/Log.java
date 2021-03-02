package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private Log() {
    }

    private static String formatLog(String str, Object... objArr) {
        AppMethodBeat.i(53787);
        if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.o(53787);
        return str;
    }

    public static String normalizeTag(String str) {
        AppMethodBeat.i(53788);
        if (str.startsWith(sTagPrefix)) {
            AppMethodBeat.o(53788);
            return str;
        }
        int i2 = 0;
        if (str.startsWith(sDeprecatedTagPrefix)) {
            i2 = 3;
        }
        String str2 = sTagPrefix + str.substring(i2, str.length());
        AppMethodBeat.o(53788);
        return str2;
    }

    private static String formatLogWithStack(String str, Object... objArr) {
        AppMethodBeat.i(53789);
        String str2 = "[" + getCallOrigin() + "] " + formatLog(str, objArr);
        AppMethodBeat.o(53789);
        return str2;
    }

    public static boolean isLoggable(String str, int i2) {
        AppMethodBeat.i(53790);
        boolean isLoggable = android.util.Log.isLoggable(str, i2);
        AppMethodBeat.o(53790);
        return isLoggable;
    }

    private static void verbose(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53791);
        formatLogWithStack(str2, objArr);
        if (getThrowableToLog(objArr) != null) {
            normalizeTag(str);
            AppMethodBeat.o(53791);
            return;
        }
        normalizeTag(str);
        AppMethodBeat.o(53791);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(53792);
        verbose(str, str2, new Object[0]);
        AppMethodBeat.o(53792);
    }

    public static void v(String str, String str2, Object obj) {
        AppMethodBeat.i(53793);
        verbose(str, str2, obj);
        AppMethodBeat.o(53793);
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        AppMethodBeat.i(53794);
        verbose(str, str2, obj, obj2);
        AppMethodBeat.o(53794);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(53795);
        verbose(str, str2, obj, obj2, obj3);
        AppMethodBeat.o(53795);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(53796);
        verbose(str, str2, obj, obj2, obj3, obj4);
        AppMethodBeat.o(53796);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(53797);
        verbose(str, str2, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(53797);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        AppMethodBeat.i(53798);
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
        AppMethodBeat.o(53798);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        AppMethodBeat.i(53799);
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
        AppMethodBeat.o(53799);
    }

    private static void debug(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53800);
        formatLogWithStack(str2, objArr);
        if (getThrowableToLog(objArr) != null) {
            normalizeTag(str);
            AppMethodBeat.o(53800);
            return;
        }
        normalizeTag(str);
        AppMethodBeat.o(53800);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(53801);
        debug(str, str2, new Object[0]);
        AppMethodBeat.o(53801);
    }

    public static void d(String str, String str2, Object obj) {
        AppMethodBeat.i(53802);
        debug(str, str2, obj);
        AppMethodBeat.o(53802);
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        AppMethodBeat.i(53803);
        debug(str, str2, obj, obj2);
        AppMethodBeat.o(53803);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(53804);
        debug(str, str2, obj, obj2, obj3);
        AppMethodBeat.o(53804);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(53805);
        debug(str, str2, obj, obj2, obj3, obj4);
        AppMethodBeat.o(53805);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(53806);
        debug(str, str2, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(53806);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        AppMethodBeat.i(53807);
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
        AppMethodBeat.o(53807);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        AppMethodBeat.i(53808);
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
        AppMethodBeat.o(53808);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53809);
        formatLog(str2, objArr);
        if (getThrowableToLog(objArr) != null) {
            normalizeTag(str);
            AppMethodBeat.o(53809);
            return;
        }
        normalizeTag(str);
        AppMethodBeat.o(53809);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53810);
        formatLog(str2, objArr);
        if (getThrowableToLog(objArr) != null) {
            normalizeTag(str);
            AppMethodBeat.o(53810);
            return;
        }
        normalizeTag(str);
        AppMethodBeat.o(53810);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53811);
        formatLog(str2, objArr);
        if (getThrowableToLog(objArr) != null) {
            normalizeTag(str);
            AppMethodBeat.o(53811);
            return;
        }
        normalizeTag(str);
        AppMethodBeat.o(53811);
    }

    public static void wtf(String str, String str2, Object... objArr) {
        AppMethodBeat.i(53812);
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.wtf(normalizeTag(str), formatLog, throwableToLog);
            AppMethodBeat.o(53812);
            return;
        }
        android.util.Log.wtf(normalizeTag(str), formatLog);
        AppMethodBeat.o(53812);
    }

    public static String getStackTraceString(Throwable th) {
        AppMethodBeat.i(53813);
        String stackTraceString = android.util.Log.getStackTraceString(th);
        AppMethodBeat.o(53813);
        return stackTraceString;
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    private static String getCallOrigin() {
        AppMethodBeat.i(53814);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i2 = 0;
        while (true) {
            if (i2 >= stackTrace.length) {
                break;
            } else if (stackTrace[i2].getClassName().equals(name)) {
                i2 += 4;
                break;
            } else {
                i2++;
            }
        }
        String str = stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber();
        AppMethodBeat.o(53814);
        return str;
    }
}
