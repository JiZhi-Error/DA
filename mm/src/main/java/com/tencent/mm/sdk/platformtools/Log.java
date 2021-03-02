package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "MicroMsg.SDK.Log";
    private static LogImp debugLog;
    private static int level = 6;
    private static LogImp logImp;
    private static Map<String, LogInstance> sLogInstanceMap = new HashMap();

    public interface LogImp {
        void appenderClose();

        void appenderFlush(long j2, boolean z);

        void appenderOpen(int i2, int i3, String str, String str2, String str3, int i4);

        int getLogLevel(long j2);

        long getXlogInstance(String str);

        void logD(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void logE(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void logF(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void logI(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void logV(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void logW(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4);

        void moveLogsFromCacheDirToLogDir();

        long openLogInstance(int i2, int i3, String str, String str2, String str3, int i4);

        void releaseXlogInstance(String str);

        void setAppenderMode(long j2, int i2);

        void setConsoleLogOpen(long j2, boolean z);

        void setMaxAliveTime(long j2, long j3);

        void setMaxFileSize(long j2, long j3);
    }

    static {
        AnonymousClass1 r0 = new LogImp() {
            /* class com.tencent.mm.sdk.platformtools.Log.AnonymousClass1 */
            private Handler handler = new Handler(Looper.getMainLooper());

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logV(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logI(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logD(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logW(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logE(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                int unused = Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void logF(long j2, String str, String str2, String str3, int i2, int i3, long j3, long j4, String str4) {
                if (Log.level > 5) {
                }
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final int getLogLevel(long j2) {
                return Log.level;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void setAppenderMode(long j2, int i2) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final long openLogInstance(int i2, int i3, String str, String str2, String str3, int i4) {
                return 0;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final long getXlogInstance(String str) {
                return 0;
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void releaseXlogInstance(String str) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void appenderOpen(int i2, int i3, String str, String str2, String str3, int i4) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void appenderClose() {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void appenderFlush(long j2, boolean z) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void setConsoleLogOpen(long j2, boolean z) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void setMaxAliveTime(long j2, long j3) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void setMaxFileSize(long j2, long j3) {
            }

            @Override // com.tencent.mm.sdk.platformtools.Log.LogImp
            public final void moveLogsFromCacheDirToLogDir() {
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
            printErrStackTrace(TAG, th, "", new Object[0]);
        }
        SYS_INFO = sb.toString();
    }

    public static void setLogImp(LogImp logImp2) {
        logImp = logImp2;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderOpen(int i2, int i3, String str, String str2, String str3, int i4) {
        if (logImp != null) {
            logImp.appenderOpen(i2, i3, str, str2, str3, i4);
        }
    }

    public static void appenderClose() {
        if (logImp != null) {
            logImp.appenderClose();
            sLogInstanceMap.size();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, LogInstance> entry : sLogInstanceMap.entrySet()) {
                arrayList.add(entry.getKey());
            }
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                closeLogInstance((String) listIterator.next());
            }
        }
    }

    public static void appenderFlush() {
        if (logImp != null) {
            logImp.appenderFlush(0, false);
            for (Map.Entry<String, LogInstance> entry : sLogInstanceMap.entrySet()) {
                entry.getValue().appenderFlush();
            }
        }
    }

    public static void appenderFlushSync() {
        if (logImp != null) {
            logImp.appenderFlush(0, true);
        }
    }

    public static int getLogLevel() {
        if (logImp != null) {
            return logImp.getLogLevel(0);
        }
        return 6;
    }

    public static void setLevel(int i2, boolean z) {
        level = i2;
    }

    public static void setConsoleLogOpen(boolean z) {
        if (logImp != null) {
            logImp.setConsoleLogOpen(0, z);
        }
    }

    public static void moveLogsFromCacheDirToLogDir() {
        if (logImp != null) {
            logImp.moveLogsFromCacheDirToLogDir();
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
        if (logImp != null && logImp.getLogLevel(0) <= 5) {
            logImp.logF(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 3) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logW(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logD(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 0) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logV(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
        }
    }

    public static void printDebugStack(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 1) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Util.getStack());
        }
    }

    public static void printInfoStack(String str, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 2) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logI(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Util.getStack());
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (logImp != null && logImp.getLogLevel(0) <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            logImp.logE(0, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + android.util.Log.getStackTraceString(th));
        }
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }

    public static LogInstance openLogInstance(int i2, int i3, String str, String str2, String str3, int i4) {
        LogInstance logInstance;
        synchronized (sLogInstanceMap) {
            if (sLogInstanceMap.containsKey(str3)) {
                logInstance = sLogInstanceMap.get(str3);
            } else {
                logInstance = new LogInstance(i2, i3, str, str2, str3, i4);
                sLogInstanceMap.put(str3, logInstance);
            }
        }
        return logInstance;
    }

    public static void closeLogInstance(String str) {
        synchronized (sLogInstanceMap) {
            if (logImp != null && sLogInstanceMap.containsKey(str)) {
                logImp.releaseXlogInstance(str);
                sLogInstanceMap.remove(str).mLogInstancePtr = -1;
            }
        }
    }

    public static LogInstance getLogInstance(String str) {
        LogInstance logInstance;
        synchronized (sLogInstanceMap) {
            if (sLogInstanceMap.containsKey(str)) {
                logInstance = sLogInstanceMap.get(str);
            } else {
                logInstance = null;
            }
        }
        return logInstance;
    }

    public static class LogInstance {
        private long mLogInstancePtr;
        private String mPrefix;

        private LogInstance(int i2, int i3, String str, String str2, String str3, int i4) {
            this.mLogInstancePtr = -1;
            this.mPrefix = null;
            if (Log.logImp != null) {
                this.mLogInstancePtr = Log.logImp.openLogInstance(i2, i3, str, str2, str3, i4);
                this.mPrefix = str3;
            }
        }

        public void f(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 5 && this.mLogInstancePtr != -1) {
                Log.logImp.logF(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), objArr == null ? str2 : String.format(str2, objArr));
            }
        }

        public void e(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 4 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logE(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
            }
        }

        public void w(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 3 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logW(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
            }
        }

        public void i(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 2 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logI(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
            }
        }

        public void iNoFormat(String str, String str2) {
            String str3;
            if (Log.logImp != null && getLogLevel() <= 2 && this.mLogInstancePtr != -1) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                Log.logImp.logI(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str3);
            }
        }

        public void d(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 1 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logD(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
            }
        }

        public void v(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 0 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logV(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format);
            }
        }

        public void printDebugStack(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 1 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logI(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Util.getStack());
            }
        }

        public void printInfoStack(String str, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 2 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logI(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + Util.getStack());
            }
        }

        public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            if (Log.logImp != null && getLogLevel() <= 4 && this.mLogInstancePtr != -1) {
                String format = objArr == null ? str2 : String.format(str2, objArr);
                if (format == null) {
                    format = "";
                }
                Log.logImp.logE(this.mLogInstancePtr, str, "", "", Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), format + "  " + android.util.Log.getStackTraceString(th));
            }
        }

        public void appenderFlush() {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.appenderFlush(this.mLogInstancePtr, false);
            }
        }

        public void appenderFlushSync() {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.appenderFlush(this.mLogInstancePtr, true);
            }
        }

        public int getLogLevel() {
            if (Log.logImp == null || this.mLogInstancePtr == -1) {
                return 6;
            }
            return Log.logImp.getLogLevel(this.mLogInstancePtr);
        }

        public void setConsoleLogOpen(boolean z) {
            if (Log.logImp != null && this.mLogInstancePtr != -1) {
                Log.logImp.setConsoleLogOpen(this.mLogInstancePtr, z);
            }
        }
    }
}
