package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.plugin.sns.l.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends IListener<wo> {
    public n() {
        AppMethodBeat.i(160640);
        this.__eventId = wo.class.getName().hashCode();
        AppMethodBeat.o(160640);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(wo woVar) {
        AppMethodBeat.i(94912);
        wo woVar2 = woVar;
        if (!(woVar2 instanceof wo)) {
            Log.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
            AppMethodBeat.o(94912);
            return false;
        }
        woVar2.ecD.dFE = a.b(woVar2.ecC.ecG, woVar2.ecC.url, woVar2.ecC.ecF);
        AppMethodBeat.o(94912);
        return true;
    }
}
