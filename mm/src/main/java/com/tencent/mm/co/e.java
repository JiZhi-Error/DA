package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public final class e extends d {
    @Override // com.tencent.mm.vending.h.d
    public final void arrange(Runnable runnable) {
        AppMethodBeat.i(158420);
        runnable.run();
        AppMethodBeat.o(158420);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrangeInterval(Runnable runnable, long j2) {
        AppMethodBeat.i(158421);
        runnable.run();
        AppMethodBeat.o(158421);
    }

    @Override // com.tencent.mm.vending.h.d
    public final String getType() {
        return "WxNoLooperScheduler";
    }

    @Override // com.tencent.mm.vending.h.d
    public final void cancel() {
    }
}
