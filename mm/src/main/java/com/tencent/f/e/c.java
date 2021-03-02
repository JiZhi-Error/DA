package com.tencent.f.e;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements g {
    public final void execute(Runnable runnable) {
        AppMethodBeat.i(183281);
        h.RTc.aY(runnable);
        AppMethodBeat.o(183281);
    }

    @Override // com.tencent.f.e.g
    public final String getTag() {
        AppMethodBeat.i(183282);
        String str = "IOScheduler@" + hashCode();
        AppMethodBeat.o(183282);
        return str;
    }

    @Override // com.tencent.f.e.g
    public final void onShutdown() {
    }
}
