package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c extends d {
    public c() {
        AppMethodBeat.i(74924);
        a.w("Vending.NoLooperScheduler", "This is not a handler thread! %s", Thread.currentThread());
        AppMethodBeat.o(74924);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrange(Runnable runnable) {
        AppMethodBeat.i(74925);
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.o(74925);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrangeInterval(Runnable runnable, long j2) {
        AppMethodBeat.i(74926);
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.o(74926);
    }

    @Override // com.tencent.mm.vending.h.d
    public final String getType() {
        AppMethodBeat.i(74927);
        String thread = Thread.currentThread().toString();
        AppMethodBeat.o(74927);
        return thread;
    }

    @Override // com.tencent.mm.vending.h.d
    public final void cancel() {
    }
}
