package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/kt/ThreadScheduler;", "Lcom/tencent/mm/vending/scheduler/Scheduler;", "()V", "arrange", "", "p0", "Ljava/lang/Runnable;", "arrangeInterval", "p1", "", "cancel", "getType", "", "libktcomm_release"})
public final class h extends d {
    public static final h hvt = new h();

    static {
        AppMethodBeat.i(168839);
        AppMethodBeat.o(168839);
    }

    private h() {
    }

    @Override // com.tencent.mm.vending.h.d
    public final String getType() {
        return "ThreadScheduler";
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrangeInterval(Runnable runnable, long j2) {
        AppMethodBeat.i(168836);
        if (runnable != null) {
            com.tencent.f.h.RTc.o(runnable, j2);
            AppMethodBeat.o(168836);
            return;
        }
        AppMethodBeat.o(168836);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void cancel() {
        AppMethodBeat.i(168837);
        Log.e("ThreadScheduler", "can not support");
        AppMethodBeat.o(168837);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrange(Runnable runnable) {
        AppMethodBeat.i(168838);
        if (runnable != null) {
            com.tencent.f.h.RTc.aX(runnable);
            AppMethodBeat.o(168838);
            return;
        }
        AppMethodBeat.o(168838);
    }
}
