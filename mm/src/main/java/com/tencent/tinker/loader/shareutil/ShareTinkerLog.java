package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Constructor;

public class ShareTinkerLog {
    public static final int FN_LOG_PRINT_PENDING_LOGS = 4002;
    public static final int FN_LOG_PRINT_STACKTRACE = 4001;
    private static final String TAG = "Tinker.ShareTinkerLog";
    private static final TinkerLogImp debugLog = new TinkerLogImp() {
        /* class com.tencent.tinker.loader.shareutil.ShareTinkerLog.AnonymousClass1 */

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void v(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void i(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void d(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void w(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void e(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            String format = (objArr == null || objArr.length == 0) ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
        }
    };
    private static final TinkerLogImp[] tinkerLogImpRef = {debugLog};
    private static final Handler[] tinkerLogInlineFenceRef = {null};

    public interface TinkerLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        synchronized (tinkerLogInlineFenceRef) {
            try {
                Constructor<?> declaredConstructor = Class.forName("com.tencent.tinker.loader.shareutil.TinkerLogInlineFence").getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                tinkerLogInlineFenceRef[0] = (Handler) declaredConstructor.newInstance(new Object[0]);
            } catch (Throwable th) {
                tinkerLogInlineFenceRef[0] = null;
            }
        }
    }

    private static Handler getInlineFence() {
        Handler handler;
        synchronized (tinkerLogInlineFenceRef) {
            handler = tinkerLogInlineFenceRef[0];
        }
        return handler;
    }

    public static TinkerLogImp getDefaultImpl() {
        return debugLog;
    }

    public static void setTinkerLogImp(TinkerLogImp tinkerLogImp) {
        synchronized (tinkerLogImpRef) {
            tinkerLogImpRef[0] = tinkerLogImp;
            if (!(tinkerLogImp == null || tinkerLogImp == debugLog)) {
                printPendingLogs();
            }
        }
    }

    public static TinkerLogImp getImpl() {
        TinkerLogImp tinkerLogImp;
        synchronized (tinkerLogImpRef) {
            tinkerLogImp = tinkerLogImpRef[0];
        }
        return tinkerLogImp;
    }

    public static void v(String str, String str2, Object... objArr) {
        printLog(2, str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        printLog(3, str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        printLog(4, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        printLog(5, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        printLog(6, str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        printLog(str, th, str2, objArr);
    }

    public static void printPendingLogs() {
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, 4002);
            inlineFence.handleMessage(obtain);
            obtain.recycle();
        }
    }

    private static void printLog(int i2, String str, String str2, Object... objArr) {
        Object[] objArr2 = {Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), str, str2, objArr};
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, i2, objArr2);
            inlineFence.handleMessage(obtain);
            obtain.recycle();
            return;
        }
        debugLog.e(str, "!! NO_LOG_IMPL !! Original Log: ".concat(String.valueOf(str2)), objArr);
    }

    private static void printLog(String str, Throwable th, String str2, Object... objArr) {
        Object[] objArr2 = {4001, Long.valueOf(System.currentTimeMillis()), str, th, str2, objArr};
        Handler inlineFence = getInlineFence();
        if (inlineFence != null) {
            Message obtain = Message.obtain(inlineFence, 4001, objArr2);
            inlineFence.handleMessage(obtain);
            obtain.recycle();
            return;
        }
        debugLog.printErrStackTrace(str, th, "!! NO_LOG_IMPL !! Original Log: ".concat(String.valueOf(str2)), objArr);
    }
}
