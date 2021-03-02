package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private final ScheduledExecutorService jKb = Executors.newSingleThreadScheduledExecutor();

    public a() {
        AppMethodBeat.i(204554);
        AppMethodBeat.o(204554);
    }

    @Override // com.tencent.mm.picker.base.c.b
    public final Future<?> h(Runnable runnable, long j2) {
        AppMethodBeat.i(204555);
        ScheduledFuture<?> scheduleWithFixedDelay = this.jKb.scheduleWithFixedDelay(runnable, 0, j2, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(204555);
        return scheduleWithFixedDelay;
    }
}
