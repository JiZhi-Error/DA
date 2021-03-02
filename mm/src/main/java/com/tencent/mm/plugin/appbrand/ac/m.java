package com.tencent.mm.plugin.appbrand.ac;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

@Deprecated
public class m {
    private static final Object ogA = new Object();
    private static volatile a ogB = null;

    static {
        AppMethodBeat.i(140849);
        AppMethodBeat.o(140849);
    }

    public static void bZm() {
        AppMethodBeat.i(140846);
        if (ogB != null) {
            synchronized (m.class) {
                try {
                    if (ogB != null) {
                        ogB.removeCallbacksAndMessages(null);
                    }
                } finally {
                    AppMethodBeat.o(140846);
                }
            }
            return;
        }
        AppMethodBeat.o(140846);
    }

    public static a bZn() {
        AppMethodBeat.i(221352);
        if (ogB == null) {
            synchronized (m.class) {
                try {
                    if (ogB == null) {
                        ogB = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(221352);
                    throw th;
                }
            }
        }
        a aVar = ogB;
        AppMethodBeat.o(221352);
        return aVar;
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(140848);
        if (runnable == null) {
            AppMethodBeat.o(140848);
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(140848);
        } else {
            h.RTc.aV(runnable);
            AppMethodBeat.o(140848);
        }
    }

    @Deprecated
    public static final class a extends MMHandler {
        a(String str) {
            super(str);
        }

        public final boolean j(Runnable runnable, long j2) {
            AppMethodBeat.i(221350);
            boolean postDelayed = super.postDelayed(runnable, j2);
            AppMethodBeat.o(221350);
            return postDelayed;
        }

        @Override // com.tencent.f.d.a, com.tencent.mm.sdk.platformtools.MMHandler
        public final Looper getLooper() {
            AppMethodBeat.i(221351);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(221351);
            throw unsupportedOperationException;
        }
    }
}
