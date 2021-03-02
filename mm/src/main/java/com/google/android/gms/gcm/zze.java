package com.google.android.gms.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zze implements ThreadFactory {
    private final AtomicInteger zzx = new AtomicInteger(1);

    zze(GcmTaskService gcmTaskService) {
        AppMethodBeat.i(3703);
        AppMethodBeat.o(3703);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(3704);
        Thread thread = new Thread(runnable, new StringBuilder(20).append("gcm-task#").append(this.zzx.getAndIncrement()).toString());
        thread.setPriority(4);
        AppMethodBeat.o(3704);
        return thread;
    }
}
