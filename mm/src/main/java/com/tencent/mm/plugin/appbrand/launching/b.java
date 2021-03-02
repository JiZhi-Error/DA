package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.sdk.event.IListener;

public final class b extends IListener<wq> {
    public b() {
        AppMethodBeat.i(160600);
        this.__eventId = wq.class.getName().hashCode();
        AppMethodBeat.o(160600);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0277  */
    @Override // com.tencent.mm.sdk.event.IListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean callback(com.tencent.mm.g.a.wq r13) {
        /*
        // Method dump skipped, instructions count: 1110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.b.callback(com.tencent.mm.sdk.event.IEvent):boolean");
    }
}
