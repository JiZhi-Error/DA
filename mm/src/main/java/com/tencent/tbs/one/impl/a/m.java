package com.tencent.tbs.one.impl.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2374a = (!m.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2375b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f2376c;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f2377d;

    static {
        AppMethodBeat.i(173937);
        AppMethodBeat.o(173937);
    }

    private m() {
    }

    public static Handler a() {
        Handler handler;
        AppMethodBeat.i(173931);
        synchronized (f2375b) {
            try {
                if (f2377d == null) {
                    HandlerThread handlerThread = new HandlerThread("TBSOneThread");
                    f2376c = handlerThread;
                    handlerThread.start();
                    f2377d = new Handler(f2376c.getLooper());
                }
                handler = f2377d;
            } finally {
                AppMethodBeat.o(173931);
            }
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        AppMethodBeat.i(173932);
        if (b()) {
            runnable.run();
            AppMethodBeat.o(173932);
            return;
        }
        a().post(runnable);
        AppMethodBeat.o(173932);
    }

    public static void b(Runnable runnable) {
        AppMethodBeat.i(173933);
        a().post(runnable);
        AppMethodBeat.o(173933);
    }

    public static boolean b() {
        AppMethodBeat.i(173935);
        if (a().getLooper() == Looper.myLooper()) {
            AppMethodBeat.o(173935);
            return true;
        }
        AppMethodBeat.o(173935);
        return false;
    }

    public static void c(Runnable runnable) {
        AppMethodBeat.i(173934);
        a().postDelayed(runnable, 2000);
        AppMethodBeat.o(173934);
    }

    public static void d(Runnable runnable) {
        AppMethodBeat.i(173936);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
        AppMethodBeat.o(173936);
    }
}
