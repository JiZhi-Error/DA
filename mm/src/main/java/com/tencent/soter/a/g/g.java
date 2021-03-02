package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g {
    private static volatile g RRl = null;
    private Handler RQg = null;
    HandlerThread RRm;
    Handler RRn = null;

    private g() {
        AppMethodBeat.i(40);
        if (this.RRm == null) {
            this.RRm = new HandlerThread("SoterGenKeyHandlerThreadName");
            this.RRm.start();
            if (this.RRm.getLooper() != null) {
                this.RRn = new Handler(this.RRm.getLooper());
            } else {
                d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
                this.RRn = new Handler(Looper.getMainLooper());
            }
        }
        this.RQg = new Handler(Looper.getMainLooper());
        AppMethodBeat.o(40);
    }

    public static g hlR() {
        g gVar;
        AppMethodBeat.i(41);
        if (RRl == null) {
            synchronized (g.class) {
                try {
                    if (RRl == null) {
                        RRl = new g();
                    }
                    gVar = RRl;
                } finally {
                    AppMethodBeat.o(41);
                }
            }
            return gVar;
        }
        g gVar2 = RRl;
        AppMethodBeat.o(41);
        return gVar2;
    }

    public final void aj(Runnable runnable) {
        AppMethodBeat.i(42);
        this.RRn.post(runnable);
        AppMethodBeat.o(42);
    }

    public final void m(Runnable runnable, long j2) {
        AppMethodBeat.i(43);
        this.RRn.postDelayed(runnable, j2);
        AppMethodBeat.o(43);
    }

    public final void postToMainThread(Runnable runnable) {
        AppMethodBeat.i(44);
        this.RQg.post(runnable);
        AppMethodBeat.o(44);
    }
}
