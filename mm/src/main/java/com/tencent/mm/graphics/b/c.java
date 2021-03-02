package com.tencent.mm.graphics.b;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;

public enum c implements Choreographer.FrameCallback {
    INSTANCE;
    
    private Choreographer choreographer;
    private int gTn = 500;
    private long hkf = 0;
    private int hkg = 0;
    double hkh = 0.0d;
    public boolean hki = false;
    private final Object lock = new Object();

    private c(String str) {
        AppMethodBeat.i(136201);
        AppMethodBeat.o(136201);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(136200);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(136200);
        return cVar;
    }

    static {
        AppMethodBeat.i(136204);
        AppMethodBeat.o(136204);
    }

    public final Choreographer axF() {
        AppMethodBeat.i(178665);
        if (this.choreographer == null) {
            synchronized (this) {
                try {
                    if (this.choreographer == null) {
                        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.graphics.b.c.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(178664);
                                    c.this.choreographer = Choreographer.getInstance();
                                    synchronized (c.this.lock) {
                                        try {
                                            c.this.lock.notify();
                                        } finally {
                                            AppMethodBeat.o(178664);
                                        }
                                    }
                                }
                            });
                            try {
                                synchronized (this.lock) {
                                    try {
                                        this.lock.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(178665);
                                        throw th;
                                    }
                                }
                            } catch (InterruptedException e2) {
                            }
                        } else {
                            this.choreographer = Choreographer.getInstance();
                        }
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(178665);
                    throw th2;
                }
            }
        }
        Choreographer choreographer2 = this.choreographer;
        AppMethodBeat.o(178665);
        return choreographer2;
    }

    public final void stop() {
        AppMethodBeat.i(136202);
        this.hkf = 0;
        this.hkg = 0;
        this.hki = false;
        Log.i("MicroMsg.Metronome", "[stop] stack:%s", Util.getStack());
        axF().removeFrameCallback(this);
        AppMethodBeat.o(136202);
    }

    public final void doFrame(long j2) {
        AppMethodBeat.i(136203);
        long millis = TimeUnit.NANOSECONDS.toMillis(j2);
        if (this.hkf > 0) {
            long j3 = millis - this.hkf;
            this.hkg++;
            if (j3 > ((long) this.gTn)) {
                this.hkh = ((double) (this.hkg * 1000)) / ((double) j3);
                this.hkf = millis;
                this.hkg = 0;
            }
        } else {
            this.hkf = millis;
        }
        axF().postFrameCallback(this);
        AppMethodBeat.o(136203);
    }
}
