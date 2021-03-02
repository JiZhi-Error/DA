package com.tencent.mm.cd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.d;

public final class a extends d {
    private MMHandler handler;
    private String serialTag = this.handler.getSerialTag();

    public a(String str) {
        AppMethodBeat.i(179439);
        this.handler = new MMHandler(str);
        AppMethodBeat.o(179439);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrange(Runnable runnable) {
        AppMethodBeat.i(179440);
        this.handler.post(runnable);
        AppMethodBeat.o(179440);
    }

    @Override // com.tencent.mm.vending.h.d
    public final void arrangeInterval(Runnable runnable, long j2) {
        AppMethodBeat.i(179441);
        this.handler.postDelayed(runnable, j2);
        AppMethodBeat.o(179441);
    }

    @Override // com.tencent.mm.vending.h.d
    public final String getType() {
        return this.serialTag;
    }

    @Override // com.tencent.mm.vending.h.d
    public final void cancel() {
        AppMethodBeat.i(179442);
        this.handler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(179442);
    }
}
