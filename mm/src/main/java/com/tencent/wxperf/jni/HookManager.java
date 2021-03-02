package com.tencent.wxperf.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.HashSet;
import java.util.Set;

public class HookManager {
    public static final HookManager Syn = new HookManager();
    public volatile boolean Syo;
    private Set<a> Syp = new HashSet();

    private native void xhookClearNative();

    private native void xhookEnableDebugNative(boolean z);

    private native void xhookEnableSigSegvProtectionNative(boolean z);

    private native int xhookRefreshNative(boolean z);

    static {
        AppMethodBeat.i(199052);
        AppMethodBeat.o(199052);
    }

    private HookManager() {
        AppMethodBeat.i(199047);
        AppMethodBeat.o(199047);
    }

    public final void hrZ() {
        AppMethodBeat.i(199048);
        if (this.Syo) {
            a aVar = new a("this process has already been hooked!");
            AppMethodBeat.o(199048);
            throw aVar;
        } else if (this.Syp.isEmpty()) {
            AppMethodBeat.o(199048);
        } else {
            try {
                System.loadLibrary("wxperf-jni");
                for (a aVar2 : this.Syp) {
                    aVar2.hrX();
                }
                for (a aVar3 : this.Syp) {
                    aVar3.hrY();
                }
                xhookEnableDebugNative(false);
                xhookEnableSigSegvProtectionNative(true);
                xhookRefreshNative(false);
                this.Syo = true;
                AppMethodBeat.o(199048);
            } catch (Throwable th) {
                Log.printStack(6, "Wxperf.HookManager", th);
                AppMethodBeat.o(199048);
            }
        }
    }

    public final HookManager a(a aVar) {
        AppMethodBeat.i(199049);
        if (aVar != null) {
            this.Syp.add(aVar);
        }
        AppMethodBeat.o(199049);
        return this;
    }

    public final HookManager hsa() {
        AppMethodBeat.i(199050);
        this.Syp.clear();
        AppMethodBeat.o(199050);
        return this;
    }

    @Keep
    public static String getStack() {
        AppMethodBeat.i(199051);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            AppMethodBeat.o(199051);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.getClassName().contains("java.lang.Thread")) {
                sb.append(stackTraceElement).append(';');
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(199051);
        return sb2;
    }

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }
}
