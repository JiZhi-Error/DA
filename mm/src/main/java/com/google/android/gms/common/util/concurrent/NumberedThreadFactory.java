package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedThreadFactory implements ThreadFactory {
    private final int priority;
    private final ThreadFactory zzaau;
    private final String zzaav;
    private final AtomicInteger zzaaw;

    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    public NumberedThreadFactory(String str, int i2) {
        AppMethodBeat.i(5324);
        this.zzaaw = new AtomicInteger();
        this.zzaau = Executors.defaultThreadFactory();
        this.zzaav = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.priority = i2;
        AppMethodBeat.o(5324);
    }

    public Thread newThread(Runnable runnable) {
        AppMethodBeat.i(5325);
        Thread newThread = this.zzaau.newThread(new zza(runnable, this.priority));
        String str = this.zzaav;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.zzaaw.getAndIncrement()).append("]").toString());
        AppMethodBeat.o(5325);
        return newThread;
    }
}
