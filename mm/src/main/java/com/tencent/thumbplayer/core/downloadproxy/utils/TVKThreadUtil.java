package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TVKThreadUtil {
    private static volatile ScheduledExecutorService mScheduler = null;

    public static ScheduledExecutorService getScheduledExecutorServiceInstance() {
        AppMethodBeat.i(210163);
        if (mScheduler == null) {
            synchronized (TVKThreadUtil.class) {
                try {
                    if (mScheduler == null) {
                        mScheduler = Executors.newScheduledThreadPool(4);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(210163);
                    throw th;
                }
            }
        }
        ScheduledExecutorService scheduledExecutorService = mScheduler;
        AppMethodBeat.o(210163);
        return scheduledExecutorService;
    }
}
