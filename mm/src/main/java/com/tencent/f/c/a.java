package com.tencent.f.c;

import android.os.HandlerThread;
import com.tencent.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {
    private static ConcurrentLinkedQueue<Long> RTD = new ConcurrentLinkedQueue<>();

    static {
        AppMethodBeat.i(183234);
        AppMethodBeat.o(183234);
    }

    static HandlerThread hy(String str, int i2) {
        AppMethodBeat.i(183232);
        AnonymousClass5 r0 = new HandlerThread("[GT]".concat(String.valueOf(str))) {
            /* class com.tencent.f.c.a.AnonymousClass5 */

            public final boolean quit() {
                AppMethodBeat.i(183222);
                d.RSR.a(this, getName(), getId());
                boolean quit = super.quit();
                AppMethodBeat.o(183222);
                return quit;
            }

            public final boolean quitSafely() {
                AppMethodBeat.i(183223);
                d.RSR.a(this, getName(), getId());
                boolean quitSafely = super.quitSafely();
                AppMethodBeat.o(183223);
                return quitSafely;
            }

            public final void interrupt() {
                AppMethodBeat.i(183224);
                super.interrupt();
                d.RSR.a(this, getName(), getId());
                AppMethodBeat.o(183224);
            }

            public final synchronized void start() {
                AppMethodBeat.i(183225);
                super.start();
                d.RSR.b(this, getName(), getId());
                AppMethodBeat.o(183225);
            }
        };
        r0.setPriority(android.support.v4.b.a.clamp(i2, 1, 10));
        AppMethodBeat.o(183232);
        return r0;
    }
}
