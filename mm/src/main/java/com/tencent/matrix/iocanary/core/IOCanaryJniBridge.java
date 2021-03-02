package com.tencent.matrix.iocanary.core;

import com.tencent.c.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.iocanary.a.a;
import java.util.ArrayList;

public class IOCanaryJniBridge {
    private static final String TAG = "Matrix.IOCanaryJniBridge";
    private static boolean sIsLoadJniLib;
    private static boolean sIsTryInstall;
    private static OnJniIssuePublishListener sOnIssuePublishListener;

    private static native boolean doHook();

    private static native boolean doUnHook();

    private static native void enableDetector(int i2);

    private static native void setConfig(int i2, long j2);

    public static void install(a aVar, OnJniIssuePublishListener onJniIssuePublishListener) {
        c.v(TAG, "install sIsTryInstall:%b", Boolean.valueOf(sIsTryInstall));
        if (!sIsTryInstall) {
            if (!loadJni()) {
                c.e(TAG, "install loadJni failed", new Object[0]);
                return;
            }
            sOnIssuePublishListener = onJniIssuePublishListener;
            if (aVar != null) {
                try {
                    if (aVar.St()) {
                        enableDetector(0);
                        setConfig(0, ((long) aVar.cQF.get(a.EnumC0131a.clicfg_matrix_io_main_thread_enable_threshold.name(), 500)) * 1000);
                    }
                    if (aVar.Sv()) {
                        enableDetector(1);
                        setConfig(1, (long) aVar.cQF.get(a.EnumC0131a.clicfg_matrix_io_small_buffer_threshold.name(), 4096));
                    }
                    if (aVar.Su()) {
                        enableDetector(2);
                        setConfig(2, (long) aVar.cQF.get(a.EnumC0131a.clicfg_matrix_io_repeated_read_threshold.name(), 5));
                    }
                } catch (Error e2) {
                    c.printErrStackTrace(TAG, e2, "call jni method error", new Object[0]);
                    return;
                }
            }
            doHook();
            sIsTryInstall = true;
        }
    }

    public static void uninstall() {
        if (sIsTryInstall) {
            doUnHook();
            sIsTryInstall = false;
        }
    }

    private static boolean loadJni() {
        if (sIsLoadJniLib) {
            return true;
        }
        try {
            System.loadLibrary("io-canary");
            sIsLoadJniLib = true;
            return true;
        } catch (Exception e2) {
            c.e(TAG, "hook: e: %s", e2.getLocalizedMessage());
            sIsLoadJniLib = false;
            return false;
        }
    }

    public static void onIssuePublish(ArrayList<IOIssue> arrayList) {
        if (sOnIssuePublishListener != null) {
            sOnIssuePublishListener.onIssuePublish(arrayList);
        }
    }

    static final class JavaContext {
        private final String stack;
        private String threadName;

        private JavaContext() {
            this.stack = com.tencent.matrix.iocanary.c.a.getThrowableStack(new Throwable());
            if (Thread.currentThread() != null) {
                this.threadName = Thread.currentThread().getName();
            }
        }
    }

    private static JavaContext getJavaContext() {
        try {
            return new JavaContext();
        } catch (Throwable th) {
            c.printErrStackTrace(TAG, th, "get javacontext exception", new Object[0]);
            return null;
        }
    }

    static final class DetectorType {
        static final int MAIN_THREAD_IO = 0;
        static final int REPEAT_READ = 2;
        static final int SMALL_BUFFER = 1;

        private DetectorType() {
        }
    }

    static final class ConfigKey {
        static final int MAIN_THREAD_THRESHOLD = 0;
        static final int REPEAT_READ_THRESHOLD = 2;
        static final int SMALL_BUFFER_THRESHOLD = 1;

        private ConfigKey() {
        }
    }
}
