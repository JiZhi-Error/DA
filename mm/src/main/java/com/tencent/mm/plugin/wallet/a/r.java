package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.td;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class r extends IListener<td> {
    public r() {
        AppMethodBeat.i(160863);
        this.__eventId = td.class.getName().hashCode();
        AppMethodBeat.o(160863);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(td tdVar) {
        AppMethodBeat.i(69188);
        b.bw(tdVar.dZA.dZC);
        EventCenter.instance.publish(new aj());
        AppMethodBeat.o(69188);
        return false;
    }
}
