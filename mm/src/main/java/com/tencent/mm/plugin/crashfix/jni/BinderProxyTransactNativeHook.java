package com.tencent.mm.plugin.crashfix.jni;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

@Keep
public class BinderProxyTransactNativeHook {
    private static long BAD_BINDER_TIME_OUT = 1000;
    private static final int IDKEY_BAD_BINDER_MONITOR = 1435;
    private static final int ID_CLIENT_1S_KEY = 1;
    private static final int ID_KV_BAD_BINDER_MONITOR = 20494;
    private static final int ID_SERVER_1S_KEY = 2;
    private static final String TAG = "MicroMsg.BadBinder";
    private static HandlerThread mBadBinderCheckHandlerThread;
    private static Handler mH;

    @Keep
    public static native void calculateOffset();

    @Keep
    public static native void hook(Method method, Method method2);

    public static void init() {
        AppMethodBeat.i(225314);
        System.loadLibrary("systemcrashprotect");
        HandlerThread handlerThread = new HandlerThread("BadBinder");
        mBadBinderCheckHandlerThread = handlerThread;
        handlerThread.start();
        mH = new Handler(mBadBinderCheckHandlerThread.getLooper());
        AppMethodBeat.o(225314);
    }

    @Keep
    public static Object onTransactNativeBegin() {
        AppMethodBeat.i(225315);
        b bVar = new b();
        mH.postDelayed(bVar, BAD_BINDER_TIME_OUT);
        AppMethodBeat.o(225315);
        return bVar;
    }

    @Keep
    public static void onTransactNativeEnd(Object obj) {
        String str;
        AppMethodBeat.i(225316);
        b bVar = (b) obj;
        mH.removeCallbacks(bVar);
        long currentTimeMillis = System.currentTimeMillis() - bVar.startTime;
        if (currentTimeMillis > BAD_BINDER_TIME_OUT) {
            h.INSTANCE.n(1435, 1, 1);
            String str2 = "";
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                int i2 = 0;
                while (i2 < stackTrace.length) {
                    if (TextUtils.isEmpty(str2)) {
                        str = stackTrace[i2].toString();
                    } else {
                        str = str2 + "\n" + stackTrace[i2].toString();
                    }
                    i2++;
                    str2 = str;
                }
            }
            Log.e(TAG, bVar.hashCode() + "#send_cost#" + currentTimeMillis + "#" + str2);
        }
        AppMethodBeat.o(225316);
    }

    @Keep
    public static Object execTransactBegin(Class cls, int i2) {
        AppMethodBeat.i(225317);
        a aVar = new a(cls, i2);
        mH.postDelayed(aVar, BAD_BINDER_TIME_OUT);
        AppMethodBeat.o(225317);
        return aVar;
    }

    @Keep
    public static void execTransactEnd(Object obj) {
        AppMethodBeat.i(225318);
        a aVar = (a) obj;
        mH.removeCallbacks(aVar);
        long currentTimeMillis = System.currentTimeMillis() - aVar.startTime;
        if (currentTimeMillis > BAD_BINDER_TIME_OUT) {
            h.INSTANCE.n(1435, 2, 1);
            String str = aVar.aWC.getName() + "#" + aVar.aWC.getGenericSuperclass() + "#" + aVar.code;
            Log.e(TAG, aVar.hashCode() + "#exec_cost#" + currentTimeMillis + "#" + str);
            h.INSTANCE.a(ID_KV_BAD_BINDER_MONITOR, str, Long.valueOf(currentTimeMillis));
        }
        AppMethodBeat.o(225318);
    }

    static class b implements Runnable {
        long startTime;

        b() {
            AppMethodBeat.i(225312);
            this.startTime = 0;
            this.startTime = System.currentTimeMillis();
            AppMethodBeat.o(225312);
        }

        public final void run() {
            AppMethodBeat.i(225313);
            Log.e(BinderProxyTransactNativeHook.TAG, hashCode() + "#send_bad#");
            AppMethodBeat.o(225313);
        }
    }

    static class a implements Runnable {
        Class aWC;
        int code = 0;
        long startTime = 0;

        a(Class cls, int i2) {
            AppMethodBeat.i(225310);
            this.aWC = cls;
            this.code = i2;
            this.startTime = System.currentTimeMillis();
            AppMethodBeat.o(225310);
        }

        public final void run() {
            AppMethodBeat.i(225311);
            Log.e(BinderProxyTransactNativeHook.TAG, hashCode() + "#exec_bad#" + this.aWC.getName() + "#" + this.aWC.getGenericSuperclass() + "#" + this.code);
            AppMethodBeat.o(225311);
        }
    }
}
