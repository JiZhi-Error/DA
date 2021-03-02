package com.tencent.smtt.sandbox;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils {
    private static final Object sLock = new Object();
    private static Handler sUiThreadHandler;

    static {
        AppMethodBeat.i(53819);
        AppMethodBeat.o(53819);
    }

    private static Handler getUiThreadHandler() {
        Handler handler;
        AppMethodBeat.i(53817);
        synchronized (sLock) {
            try {
                if (sUiThreadHandler == null) {
                    sUiThreadHandler = new Handler(Looper.getMainLooper());
                }
                handler = sUiThreadHandler;
            } finally {
                AppMethodBeat.o(53817);
            }
        }
        return handler;
    }

    public static void postOnUiThread(Runnable runnable) {
        AppMethodBeat.i(53818);
        getUiThreadHandler().post(runnable);
        AppMethodBeat.o(53818);
    }
}
