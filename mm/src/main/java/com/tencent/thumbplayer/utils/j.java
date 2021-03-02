package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class j {
    private static volatile a Sfv = null;
    public static ExecutorService THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    private static volatile ScheduledExecutorService mScheduler = null;

    static {
        AppMethodBeat.i(189668);
        AppMethodBeat.o(189668);
    }

    public static ScheduledExecutorService getScheduledExecutorServiceInstance() {
        AppMethodBeat.i(189667);
        if (mScheduler == null) {
            synchronized (j.class) {
                try {
                    if (mScheduler == null) {
                        mScheduler = Executors.newScheduledThreadPool(4);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(189667);
                    throw th;
                }
            }
        }
        ScheduledExecutorService scheduledExecutorService = mScheduler;
        AppMethodBeat.o(189667);
        return scheduledExecutorService;
    }

    static class a extends Handler {
        public final void handleMessage(Message message) {
        }
    }
}
