package com.tencent.mm.plugin.taskbar.ui.b;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public enum c implements Choreographer.FrameCallback {
    INSTANCE;
    
    private Choreographer choreographer;
    private int gTn = 500;
    public long hkf = 0;
    public int hkg = 0;
    double hkh = 0.0d;
    public boolean hki = false;
    private final Object lock = new Object();

    private c(String str) {
        AppMethodBeat.i(238319);
        AppMethodBeat.o(238319);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(238318);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(238318);
        return cVar;
    }

    static {
        AppMethodBeat.i(238322);
        AppMethodBeat.o(238322);
    }

    public final Choreographer axF() {
        AppMethodBeat.i(238320);
        if (this.choreographer == null) {
            synchronized (this) {
                try {
                    if (this.choreographer == null) {
                        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.plugin.taskbar.ui.b.c.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(238316);
                                    c.this.choreographer = Choreographer.getInstance();
                                    synchronized (c.this.lock) {
                                        try {
                                            c.this.lock.notify();
                                        } finally {
                                            AppMethodBeat.o(238316);
                                        }
                                    }
                                }
                            });
                            try {
                                synchronized (this.lock) {
                                    try {
                                        this.lock.wait();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(238320);
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
                    AppMethodBeat.o(238320);
                    throw th2;
                }
            }
        }
        Choreographer choreographer2 = this.choreographer;
        AppMethodBeat.o(238320);
        return choreographer2;
    }

    public final void doFrame(long j2) {
        AppMethodBeat.i(238321);
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
        AppMethodBeat.o(238321);
    }
}
