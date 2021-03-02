package com.tencent.liteav.basic.log;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TXCLog {
    public static final int LOG_ASYNC = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 6;
    public static final int LOG_SYNC = 1;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARNING = 3;
    private static boolean mEnableCallback = false;
    private static boolean mEnableCompress = true;
    private static boolean mEnableConsole = true;
    private static boolean mHasInit = false;
    private static a mListener = null;
    private static String mLogCacheDir = "";
    public static String mLogDir = "";
    private static int mLogLevel = 0;
    private static final Object mLogLock = new Object();

    public interface a {
        void a(int i2, String str, String str2);
    }

    private static native void nativeEnableCallback(boolean z);

    private static native void nativeLog(int i2, String str, String str2, int i3, String str3, String str4);

    private static native void nativeLogClose();

    private static native void nativeLogInit();

    private static native void nativeLogOpen(int i2, String str, String str2, String str3, boolean z);

    private static native void nativeLogSetConsole(boolean z);

    private static native void nativeLogSetLevel(int i2);

    static {
        AppMethodBeat.i(14780);
        AppMethodBeat.o(14780);
    }

    public static boolean init() {
        File externalFilesDir;
        AppMethodBeat.i(14766);
        if (mHasInit) {
            AppMethodBeat.o(14766);
            return true;
        }
        synchronized (mLogLock) {
            try {
                if (mHasInit) {
                    return true;
                }
                boolean f2 = f.f();
                Context appContext = TXCCommonUtil.getAppContext();
                if (f2 && appContext != null) {
                    if (TextUtils.isEmpty(mLogDir) && (externalFilesDir = appContext.getExternalFilesDir(null)) != null) {
                        mLogDir = externalFilesDir.getAbsolutePath() + "/log/tencent/liteav";
                    }
                    mLogCacheDir = appContext.getFilesDir().getAbsolutePath() + "/log/tencent/liteav";
                    new StringBuilder("TXCLog init log file path : ").append(mLogDir).append(", cache : ").append(mLogCacheDir);
                    nativeLogInit();
                    nativeLogSetLevel(mLogLevel);
                    nativeLogSetConsole(mEnableConsole);
                    nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
                    nativeEnableCallback(mEnableCallback);
                    mHasInit = true;
                }
                boolean z = mHasInit;
                AppMethodBeat.o(14766);
                return z;
            } finally {
                AppMethodBeat.o(14766);
            }
        }
    }

    public static void log(int i2, String str, String str2) {
        AppMethodBeat.i(14767);
        if (init()) {
            nativeLog(i2, str, "", 0, "", str2);
        }
        log_callback(i2, str, str2);
        AppMethodBeat.o(14767);
    }

    public static void setLevel(int i2) {
        AppMethodBeat.i(14768);
        mLogLevel = i2;
        if (mHasInit) {
            nativeLogSetLevel(mLogLevel);
        }
        AppMethodBeat.o(14768);
    }

    public static void setLogDirPath(String str) {
        AppMethodBeat.i(14769);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14769);
            return;
        }
        if (!str.equalsIgnoreCase(mLogDir)) {
            mLogDir = str;
            if (mHasInit) {
                nativeLogClose();
                nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
            }
        }
        AppMethodBeat.o(14769);
    }

    public static void sliceLogFile() {
        AppMethodBeat.i(14770);
        if (mHasInit) {
            nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
        }
        AppMethodBeat.o(14770);
    }

    public static void setLogCompressEnabled(boolean z) {
        AppMethodBeat.i(14771);
        if (mEnableCompress != z) {
            mEnableCompress = z;
            if (mHasInit) {
                nativeLogClose();
                nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
            }
        }
        AppMethodBeat.o(14771);
    }

    public static void setConsoleEnabled(boolean z) {
        AppMethodBeat.i(14772);
        mEnableConsole = z;
        if (mHasInit) {
            nativeLogSetConsole(mEnableConsole);
        }
        AppMethodBeat.o(14772);
    }

    public static void setListener(a aVar) {
        AppMethodBeat.i(14773);
        mListener = aVar;
        mEnableCallback = aVar != null;
        if (mHasInit) {
            nativeEnableCallback(mEnableCallback);
        }
        AppMethodBeat.o(14773);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(222128);
        log(0, str, String.format(str2, objArr));
        AppMethodBeat.o(222128);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(222129);
        log(1, str, String.format(str2, objArr));
        AppMethodBeat.o(222129);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(222130);
        log(2, str, String.format(str2, objArr));
        AppMethodBeat.o(222130);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(222131);
        log(3, str, String.format(str2, objArr));
        AppMethodBeat.o(222131);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(222132);
        log(4, str, String.format(str2, objArr));
        AppMethodBeat.o(222132);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(14774);
        log(0, str, str2);
        AppMethodBeat.o(14774);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(14775);
        log(1, str, str2);
        AppMethodBeat.o(14775);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(14776);
        log(2, str, str2);
        AppMethodBeat.o(14776);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(14777);
        log(3, str, str2);
        AppMethodBeat.o(14777);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(14778);
        log(4, str, str2);
        AppMethodBeat.o(14778);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(222133);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        e(str, str2 + "\n" + stringWriter.toString());
        AppMethodBeat.o(222133);
    }

    private static void log_callback(int i2, String str, String str2) {
        AppMethodBeat.i(14779);
        if (mListener != null) {
            mListener.a(i2, str, str2);
        }
        AppMethodBeat.o(14779);
    }
}
