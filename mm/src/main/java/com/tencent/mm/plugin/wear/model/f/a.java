package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.r;

public final class a extends c {
    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "RequestLogTask";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30124);
        com.tencent.mm.plugin.wear.model.a.fVQ();
        r.a(20009, null, false);
        com.tencent.mm.plugin.wear.model.a.fVQ();
        r.a(20017, null, false);
        AppMethodBeat.o(30124);
    }
}
