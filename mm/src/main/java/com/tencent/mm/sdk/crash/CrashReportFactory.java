package com.tencent.mm.sdk.crash;

import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public class CrashReportFactory {
    private static boolean backupMerge = false;
    public static String currentActivity = "unknow";
    public static boolean foreground = false;
    public static long heavyUserFlag = 0;
    private static boolean isDualByTools = false;
    private static boolean isHookedByXposed = false;
    private static boolean isX86Env = false;
    private static boolean onlinePatchBlocked = false;
    private static ICrashReporter reporter = null;

    public static void setupCrashReporter(ICrashReporter iCrashReporter) {
        reporter = iCrashReporter;
    }

    public static void addCrashReportExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter iCrashReportExtraMessageGetter) {
        ICrashReporter iCrashReporter = reporter;
        if (iCrashReporter != null) {
            iCrashReporter.addExtraMessageGetter(iCrashReportExtraMessageGetter);
        }
    }

    public static void addCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        ICrashReporter iCrashReporter = reporter;
        if (iCrashReporter != null) {
            iCrashReporter.addCrashReportListener(iCrashReportListener);
        }
    }

    public static void removeCrashReportListener(ICrashReporter.ICrashReportListener iCrashReportListener) {
        ICrashReporter iCrashReporter = reporter;
        if (iCrashReporter != null) {
            iCrashReporter.removeCrashReportListener(iCrashReportListener);
        }
    }

    public static void setupSubReporter(ISubReporter iSubReporter) {
        if (reporter != null) {
            reporter.setupSubReporter(iSubReporter);
        }
    }

    public static void reportRawMessage(String str, String str2) {
        if (reporter != null) {
            reporter.reportRawMessage(str, str2);
        }
    }

    public static void reportCrashMessage(String str, String str2) {
        if (reporter != null) {
            reporter.reportCrashMessage(str, str2);
        }
    }

    public static void reportJniCrash(int i2, String str, String str2) {
        if (reporter != null) {
            reporter.reportJniCrash(i2, str, str2);
        }
    }

    public static void setForeground(boolean z) {
        foreground = z;
    }

    public static void setCurrentActivity(String str) {
        currentActivity = str;
    }

    public static void setHeavyUserFlag(long j2) {
        heavyUserFlag = j2;
    }

    public static void setReportID(String str) {
        if (reporter != null) {
            reporter.setReportID(str);
        }
    }

    public static void setCallbackForReset(CallbackForReset callbackForReset) {
        if (reporter != null) {
            reporter.setCallbackForReset(callbackForReset);
        }
    }

    @Deprecated
    public static boolean isMonkeyEnv() {
        return WeChatEnvironment.isMonkeyEnv();
    }

    @Deprecated
    public static void setHasDebuger(boolean z) {
        WeChatEnvironment.setHasDebugger(z);
    }

    @Deprecated
    public static boolean hasDebuger() {
        return WeChatEnvironment.hasDebugger();
    }

    @Deprecated
    public static void setDebugerApiLevel(String str) {
        WeChatEnvironment.setDebuggerApiLevel(str);
    }

    @Deprecated
    public static String getDebugerApiLevel() {
        return WeChatEnvironment.getDebuggerApiLevel();
    }

    public static boolean isBackupMerge() {
        return backupMerge;
    }

    public static void setBackupMerge(boolean z) {
        backupMerge = z;
    }

    public static void setOnlinePatchBlocked(boolean z) {
        onlinePatchBlocked = z;
    }

    public static boolean isOnlinePatchBlocked() {
        return onlinePatchBlocked;
    }

    public static synchronized void setX86Env(boolean z) {
        synchronized (CrashReportFactory.class) {
            isX86Env = z;
        }
    }

    public static synchronized boolean isX86Env() {
        boolean z;
        synchronized (CrashReportFactory.class) {
            z = isX86Env;
        }
        return z;
    }

    public static synchronized void setDualByTools(boolean z) {
        synchronized (CrashReportFactory.class) {
            isDualByTools = z;
        }
    }

    public static synchronized boolean isDualByTools() {
        boolean z;
        synchronized (CrashReportFactory.class) {
            z = isDualByTools;
        }
        return z;
    }

    public static synchronized void setHookedByXposed(boolean z) {
        synchronized (CrashReportFactory.class) {
            isHookedByXposed = z;
        }
    }

    public static synchronized boolean isHookedByXposed() {
        boolean z;
        synchronized (CrashReportFactory.class) {
            z = isHookedByXposed;
        }
        return z;
    }
}
