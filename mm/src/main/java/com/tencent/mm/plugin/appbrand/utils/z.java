package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/OneshotCancelableCountDownAbleRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/plugin/appbrand/utils/CountDownAble;", "runnable", "totalCount", "", "extraRunnable", "(Ljava/lang/Runnable;ILjava/lang/Runnable;)V", "_hasRun", "", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getExtraRunnable", "()Ljava/lang/Runnable;", "hasRun", "getHasRun", "()Z", "isCanceled", "reach0", "getReach0", "getTotalCount", "()I", "cancel", "", "countdown", "forceReach0", "run", "luggage-wxa-app_release"})
public final class z implements Runnable {
    private final Runnable dQN;
    private final int gAZ;
    private volatile boolean isCanceled;
    private volatile boolean ohr;
    public AtomicInteger ohs;
    public final Runnable oht;

    public z(Runnable runnable, byte b2) {
        this(runnable);
    }

    public z(Runnable runnable, int i2, Runnable runnable2) {
        p.h(runnable, "runnable");
        AppMethodBeat.i(219789);
        this.dQN = runnable;
        this.gAZ = i2;
        this.oht = runnable2;
        this.ohs = new AtomicInteger(this.gAZ);
        AppMethodBeat.o(219789);
    }

    private /* synthetic */ z(Runnable runnable) {
        this(runnable, 0, null);
    }

    public final boolean bZu() {
        AppMethodBeat.i(219786);
        if (this.ohs.get() <= 0) {
            AppMethodBeat.o(219786);
            return true;
        }
        AppMethodBeat.o(219786);
        return false;
    }

    public final void bZv() {
        AppMethodBeat.i(219787);
        Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "countdown, curCount: " + this.ohs.decrementAndGet());
        if (bZu()) {
            run();
        }
        AppMethodBeat.o(219787);
    }

    public final void run() {
        AppMethodBeat.i(219788);
        if (this.isCanceled) {
            Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, isCanceled");
            AppMethodBeat.o(219788);
        } else if (!bZu()) {
            Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, reach0 is false, just return");
            AppMethodBeat.o(219788);
        } else if (this.ohr) {
            Log.i("MicroMsg.AppBrand.OneshotCancelableCountDownAbleRunnable", "run, hasRun");
            AppMethodBeat.o(219788);
        } else {
            this.dQN.run();
            this.ohr = true;
            AppMethodBeat.o(219788);
        }
    }
}
