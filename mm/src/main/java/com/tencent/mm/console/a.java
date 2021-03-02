package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.sdk.event.IListener;

public final class a extends IListener<cj> {
    public a() {
        AppMethodBeat.i(161275);
        this.__eventId = cj.class.getName().hashCode();
        AppMethodBeat.o(161275);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(cj cjVar) {
        AppMethodBeat.i(20103);
        cj cjVar2 = cjVar;
        cjVar2.dFC.dFE = b.h(cjVar2.dFB.context, cjVar2.dFB.dFD, cjVar2.dFB.username);
        AppMethodBeat.o(20103);
        return false;
    }
}
