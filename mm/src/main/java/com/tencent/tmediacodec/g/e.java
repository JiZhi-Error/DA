package com.tencent.tmediacodec.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e {
    private static final ExecutorService Snd = Executors.newCachedThreadPool();
    private static Handler Sne = new Handler(mHandlerThread.getLooper());
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private static final HandlerThread mHandlerThread;

    static {
        AppMethodBeat.i(190205);
        HandlerThread handlerThread = new HandlerThread("com.tencent.tmediacodec-sub");
        mHandlerThread = handlerThread;
        handlerThread.start();
        AppMethodBeat.o(190205);
    }

    public static void runOnSubThread(Runnable runnable) {
        AppMethodBeat.i(190202);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Snd.execute(runnable);
            AppMethodBeat.o(190202);
            return;
        }
        runnable.run();
        AppMethodBeat.o(190202);
    }

    public static void execute(Runnable runnable) {
        AppMethodBeat.i(190203);
        Snd.execute(runnable);
        AppMethodBeat.o(190203);
    }

    public static void bb(Runnable runnable) {
        AppMethodBeat.i(190204);
        Sne.post(runnable);
        AppMethodBeat.o(190204);
    }
}
