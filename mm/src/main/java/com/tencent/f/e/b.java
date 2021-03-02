package com.tencent.f.e;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements g {
    public final void execute(Runnable runnable) {
        AppMethodBeat.i(183279);
        h.RTc.aZ(runnable);
        AppMethodBeat.o(183279);
    }

    @Override // com.tencent.f.e.g
    public final String getTag() {
        AppMethodBeat.i(183280);
        String str = "ComputeScheduler@" + hashCode();
        AppMethodBeat.o(183280);
        return str;
    }

    @Override // com.tencent.f.e.g
    public final void onShutdown() {
    }
}
