package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends IListener<xn> {
    public n() {
        AppMethodBeat.i(161434);
        this.__eventId = xn.class.getName().hashCode();
        AppMethodBeat.o(161434);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(xn xnVar) {
        AppMethodBeat.i(28178);
        xn xnVar2 = xnVar;
        switch (xnVar2.edL.opType) {
            case 0:
                c.a aNu = c.aNu(xnVar2.edL.edN);
                if (aNu != null) {
                    xnVar2.edM.dWc = c.a(xnVar2.edL.context, aNu);
                    xnVar2.edM.thumbPath = m.jP(aNu.field_thumburl, "@B");
                    xnVar2.edM.dFE = true;
                    break;
                } else {
                    Log.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", xnVar2.edL.edN);
                    xnVar2.edM.dFE = false;
                    break;
                }
        }
        AppMethodBeat.o(28178);
        return false;
    }
}
