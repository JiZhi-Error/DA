package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p {
    private static volatile p hnp;
    private Handler hnq = new Handler(Looper.getMainLooper());
    private Handler mHandler = l.ayc();

    private static p ayf() {
        AppMethodBeat.i(158759);
        if (hnp == null) {
            synchronized (p.class) {
                try {
                    if (hnp == null) {
                        hnp = new p();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158759);
                    throw th;
                }
            }
        }
        p pVar = hnp;
        AppMethodBeat.o(158759);
        return pVar;
    }

    private p() {
        AppMethodBeat.i(158760);
        AppMethodBeat.o(158760);
    }

    public static HandlerThread ayg() {
        AppMethodBeat.i(158761);
        HandlerThread handlerThread = (HandlerThread) ayf().mHandler.getLooper().getThread();
        AppMethodBeat.o(158761);
        return handlerThread;
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(158762);
        boolean post = ayf().mHandler.post(runnable);
        AppMethodBeat.o(158762);
        return post;
    }

    public static boolean postDelayed(Runnable runnable, long j2) {
        AppMethodBeat.i(158763);
        boolean postDelayed = ayf().mHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(158763);
        return postDelayed;
    }

    public static boolean y(Runnable runnable) {
        AppMethodBeat.i(158764);
        boolean post = ayf().hnq.post(runnable);
        AppMethodBeat.o(158764);
        return post;
    }

    public static boolean z(Runnable runnable) {
        AppMethodBeat.i(158765);
        boolean postDelayed = ayf().hnq.postDelayed(runnable, 100);
        AppMethodBeat.o(158765);
        return postDelayed;
    }

    public static boolean A(Runnable runnable) {
        AppMethodBeat.i(158766);
        l.post(runnable);
        AppMethodBeat.o(158766);
        return true;
    }
}
