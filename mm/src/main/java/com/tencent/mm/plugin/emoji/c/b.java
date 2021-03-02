package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.sdk.event.IListener;

public final class b extends IListener<bp> {
    public b() {
        AppMethodBeat.i(161066);
        this.__eventId = bp.class.getName().hashCode();
        AppMethodBeat.o(161066);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(bp bpVar) {
        AppMethodBeat.i(108388);
        boolean a2 = a(bpVar);
        AppMethodBeat.o(108388);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.g.a.bp r12) {
        /*
        // Method dump skipped, instructions count: 1544
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.c.b.a(com.tencent.mm.g.a.bp):boolean");
    }
}
