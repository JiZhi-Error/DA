package com.tencent.recovery.log;

public class RecoveryLog {
    private static RecoveryLogImpl logImpl = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void setDebugMode();

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void setDebugMode() {
        logImpl.setDebugMode();
    }

    public static void v(String str, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.v(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.d(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.i(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.w(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (logImpl != null) {
            logImpl.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void setLogImpl(RecoveryLogImpl recoveryLogImpl) {
        if (logImpl instanceof RecoveryCacheLog) {
            ((RecoveryCacheLog) logImpl).printAll(recoveryLogImpl);
        }
        logImpl = recoveryLogImpl;
    }

    public static void appendLog() {
        if (logImpl instanceof RecoveryFileLog) {
            ((RecoveryFileLog) logImpl).appendToBuffer("", true);
        }
    }

    public static RecoveryLogImpl getLogImpl() {
        return logImpl;
    }
}
