package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.px;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends IListener<px> {
    public s() {
        AppMethodBeat.i(161001);
        this.__eventId = px.class.getName().hashCode();
        AppMethodBeat.o(161001);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(px pxVar) {
        AppMethodBeat.i(51636);
        px pxVar2 = pxVar;
        switch (pxVar2.dVZ.opType) {
            case 0:
                n.a fn = r.fn(pxVar2.dVZ.dWb, 0);
                if (fn != null) {
                    pxVar2.dWa.dWc = r.a(pxVar2.dVZ.context, fn);
                    pxVar2.dWa.thumbPath = j.eOR().jP(fn.field_thumburl, "@S");
                    pxVar2.dWa.dFE = true;
                    break;
                } else {
                    Log.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", pxVar2.dVZ.dWb);
                    pxVar2.dWa.dFE = false;
                    break;
                }
        }
        AppMethodBeat.o(51636);
        return false;
    }
}
