package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/CountDownLock;", "", "countDownCallback", "Ljava/lang/Runnable;", "count", "", "(Ljava/lang/Runnable;I)V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "countDown", "", "plugin-appbrand-integration_release"})
public final class k {
    private final AtomicInteger counter;
    private final Runnable ogR;

    public k(Runnable runnable, int i2) {
        AppMethodBeat.i(51402);
        this.ogR = runnable;
        if (!(i2 > 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("count <= 0".toString());
            AppMethodBeat.o(51402);
            throw illegalArgumentException;
        }
        this.counter = new AtomicInteger(i2);
        AppMethodBeat.o(51402);
    }

    public final void countDown() {
        Runnable runnable;
        AppMethodBeat.i(51401);
        if (this.counter.decrementAndGet() != 0 || (runnable = this.ogR) == null) {
            AppMethodBeat.o(51401);
            return;
        }
        runnable.run();
        AppMethodBeat.o(51401);
    }
}
