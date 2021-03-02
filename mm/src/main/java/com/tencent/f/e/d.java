package com.tencent.f.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.f.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final d RTF = new d();
    private static final ConcurrentHashMap<Looper, WeakReference<Handler>> RTG = new ConcurrentHashMap<>();
    private final Looper looper;

    static {
        AppMethodBeat.i(183287);
        AppMethodBeat.o(183287);
    }

    private d() {
        AppMethodBeat.i(183283);
        HandlerThread createHandlerThread = c.createHandlerThread("TP#Internal");
        createHandlerThread.setPriority(8);
        createHandlerThread.start();
        this.looper = createHandlerThread.getLooper();
        AppMethodBeat.o(183283);
    }

    public static Handler a(String str, Handler.Callback callback) {
        AppMethodBeat.i(183285);
        a aVar = new a(str, RTF.looper, callback);
        RTG.put(RTF.looper, new WeakReference<>(aVar));
        AppMethodBeat.o(183285);
        return aVar;
    }

    public static void release() {
        AppMethodBeat.i(183286);
        for (WeakReference<Handler> weakReference : RTG.values()) {
            Handler handler = weakReference.get();
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
        AppMethodBeat.o(183286);
    }

    static class a extends Handler {
        private final String name;

        a(String str, Looper looper, Handler.Callback callback) {
            super(looper, callback);
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }
}
