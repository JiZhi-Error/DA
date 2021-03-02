package com.tencent.qqmusic.mediaplayer;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class NLog {
    private static final int LEVEL_DEBUG = 1;
    private static final int LEVEL_ERROR = 4;
    private static final int LEVEL_INFO = 2;
    private static final int LEVEL_WARNING = 3;
    private static final String TAG = "NLog";
    private static volatile boolean mIsLoadSuccess = false;

    private static native void d(String str, String str2);

    private static native void e(String str, String str2);

    private static native String getLogPath();

    private static native void i(String str, String str2);

    private static native void setLogWriteCallback(int i2);

    private static native boolean start(String str, int i2);

    private static native void stop();

    private static native void w(String str, String str2);

    private static void WriteLogCallback(int i2, String str, String str2) {
        AppMethodBeat.i(114377);
        switch (i2) {
            case 1:
                Logger.d(str, str2);
                AppMethodBeat.o(114377);
                return;
            case 2:
                Logger.i(str, str2);
                AppMethodBeat.o(114377);
                return;
            case 3:
                Logger.w(str, str2);
                AppMethodBeat.o(114377);
                return;
            case 4:
                Logger.e(str, str2);
                AppMethodBeat.o(114377);
                return;
            default:
                Logger.i(str, str2);
                AppMethodBeat.o(114377);
                return;
        }
    }

    public static boolean Start(String str, int i2) {
        boolean z = false;
        AppMethodBeat.i(114378);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114378);
        } else {
            try {
                z = start(str, i2);
                AppMethodBeat.o(114378);
            } catch (UnsatisfiedLinkError e2) {
                Logger.e(TAG, e2);
                AppMethodBeat.o(114378);
            }
        }
        return z;
    }

    public static void Stop() {
        AppMethodBeat.i(114379);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114379);
            return;
        }
        try {
            stop();
            AppMethodBeat.o(114379);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114379);
        }
    }

    public static void setWriteCallback(boolean z) {
        AppMethodBeat.i(114380);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114380);
            return;
        }
        try {
            setLogWriteCallback(z ? 1 : 0);
            AppMethodBeat.o(114380);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114380);
        }
    }

    public static String GetLogPath() {
        AppMethodBeat.i(114381);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114381);
            return "";
        }
        try {
            String logPath = getLogPath();
            AppMethodBeat.o(114381);
            return logPath;
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114381);
            return "";
        }
    }

    public static void D(String str, String str2) {
        AppMethodBeat.i(114382);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114382);
            return;
        }
        try {
            d(str, str2);
            AppMethodBeat.o(114382);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114382);
        }
    }

    public static void I(String str, String str2) {
        AppMethodBeat.i(114383);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114383);
            return;
        }
        try {
            i(str, str2);
            AppMethodBeat.o(114383);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114383);
        }
    }

    public static void W(String str, String str2) {
        AppMethodBeat.i(114384);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114384);
            return;
        }
        try {
            w(str, str2);
            AppMethodBeat.o(114384);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114384);
        }
    }

    public static void E(String str, String str2) {
        AppMethodBeat.i(114385);
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            AppMethodBeat.o(114385);
            return;
        }
        try {
            e(str, str2);
            AppMethodBeat.o(114385);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114385);
        }
    }

    public static void D(String str, String str2, Throwable th) {
        AppMethodBeat.i(114386);
        d(str, str2 + "\n" + Log.getStackTraceString(th));
        AppMethodBeat.o(114386);
    }

    public static void I(String str, String str2, Throwable th) {
        AppMethodBeat.i(114387);
        i(str, str2 + "\n" + Log.getStackTraceString(th));
        AppMethodBeat.o(114387);
    }

    public static void W(String str, String str2, Throwable th) {
        AppMethodBeat.i(114388);
        w(str, str2 + "\n" + Log.getStackTraceString(th));
        AppMethodBeat.o(114388);
    }

    public static void E(String str, String str2, Throwable th) {
        AppMethodBeat.i(114389);
        e(str, str2 + "\n" + Log.getStackTraceString(th));
        AppMethodBeat.o(114389);
    }

    public static boolean init(String str, String str2, int i2) {
        AppMethodBeat.i(114390);
        if (AudioPlayerConfigure.getSoLibraryLoader().load(str)) {
            mIsLoadSuccess = true;
            Start(str2, i2);
            AppMethodBeat.o(114390);
            return true;
        }
        AppMethodBeat.o(114390);
        return false;
    }
}
