package com.tencent.mars.ilink.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;

public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "mars.xlog.log";
    private static LogImp debugLog;
    private static int level = 6;
    private static LogImp logImp;
    public static Context toastSupportContext = null;

    public interface LogImp {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

        void logE(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

        void logF(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

        void logI(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

        void logV(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);

        void logW(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4);
    }

    static {
        AnonymousClass1 r0 = new LogImp() {
            /* class com.tencent.mars.ilink.xlog.Log.AnonymousClass1 */
            private Handler handler = new Handler(Looper.getMainLooper());

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logV(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logI(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logD(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logW(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logE(String str, String str2, String str3, int i2, int i3, long j2, long j3, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void logF(String str, String str2, String str3, int i2, int i3, long j2, long j3, final String str4) {
                if (Log.level <= 5 && Log.toastSupportContext != null) {
                    this.handler.post(new Runnable() {
                        /* class com.tencent.mars.ilink.xlog.Log.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            Toast.makeText(Log.toastSupportContext, str4, 1).show();
                        }
                    });
                }
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final int getLogLevel() {
                return Log.level;
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void appenderClose() {
            }

            @Override // com.tencent.mars.ilink.xlog.Log.LogImp
            public final void appenderFlush(boolean z) {
            }
        };
        debugLog = r0;
        logImp = r0;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
        }
        SYS_INFO = sb.toString();
    }

    public static void setLogImp(LogImp logImp2) {
        logImp = logImp2;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderClose() {
        if (logImp != null) {
            logImp.appenderClose();
        }
    }

    public static void appenderFlush(boolean z) {
        if (logImp != null) {
            logImp.appenderFlush(z);
        }
    }

    public static int getLogLevel() {
        if (logImp != null) {
            return logImp.getLogLevel();
        }
        return 6;
    }

    public static void setLevel(int i2, boolean z) {
        level = i2;
        if (z) {
            Xlog.setLogLevel(i2);
        }
    }

    public static void f(String str, String str2) {
        f(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (logImp != null) {
            logImp.logF(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logW(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logD(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logV(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (logImp != null) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(str, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + android.util.Log.getStackTraceString(th));
        }
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
