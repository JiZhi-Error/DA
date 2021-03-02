package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import kotlin.k.j;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\r\u001a\u00020\u000e*\u00020\u000f8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010¨\u0006\u0011"}, hxF = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"})
public final class l {
    public static final long TXb = v.cm("kotlinx.coroutines.scheduler.resolution.ns", 100000);
    public static final int TXc = v.h("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
    public static final long TXd = TimeUnit.SECONDS.toNanos(v.cm("kotlinx.coroutines.scheduler.keep.alive.sec", 60));
    public static m TXe = g.TWX;
    public static final int aBA = v.h("kotlinx.coroutines.scheduler.core.pool.size", j.mZ(w.hNR(), 2), 1, 0, 8);
    public static final int aBB = v.h("kotlinx.coroutines.scheduler.max.pool.size", j.bh(w.hNR() * 128, aBA, 2097150), 0, 2097150, 4);

    static {
        AppMethodBeat.i(117978);
        AppMethodBeat.o(117978);
    }
}
