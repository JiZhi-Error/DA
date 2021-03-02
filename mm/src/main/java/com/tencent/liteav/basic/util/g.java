package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Handler f475a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f476b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f477c = true;

    /* renamed from: d  reason: collision with root package name */
    private Thread f478d;

    public g(String str) {
        AppMethodBeat.i(222111);
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.f476b = handlerThread.getLooper();
        this.f475a = new Handler(this.f476b);
        this.f478d = handlerThread;
        AppMethodBeat.o(222111);
    }

    public Handler a() {
        return this.f475a;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(222112);
        if (this.f477c) {
            this.f475a.getLooper().quit();
        }
        super.finalize();
        AppMethodBeat.o(222112);
    }

    public void a(final Runnable runnable) {
        AppMethodBeat.i(222113);
        final boolean[] zArr = new boolean[1];
        if (Thread.currentThread().equals(this.f478d)) {
            runnable.run();
            AppMethodBeat.o(222113);
            return;
        }
        synchronized (this.f475a) {
            try {
                zArr[0] = false;
                this.f475a.post(new Runnable() {
                    /* class com.tencent.liteav.basic.util.g.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222119);
                        runnable.run();
                        zArr[0] = true;
                        synchronized (g.this.f475a) {
                            try {
                                g.this.f475a.notifyAll();
                            } finally {
                                AppMethodBeat.o(222119);
                            }
                        }
                    }
                });
                while (!zArr[0]) {
                    try {
                        this.f475a.wait();
                    } catch (Exception e2) {
                    }
                }
            } finally {
                AppMethodBeat.o(222113);
            }
        }
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(222114);
        this.f475a.post(runnable);
        AppMethodBeat.o(222114);
    }

    public void a(Runnable runnable, long j2) {
        AppMethodBeat.i(222115);
        this.f475a.postDelayed(runnable, j2);
        AppMethodBeat.o(222115);
    }
}
