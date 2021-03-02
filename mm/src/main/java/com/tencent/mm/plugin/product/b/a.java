package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.px;
import com.tencent.mm.plugin.product.ui.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a extends IListener<px> {
    public a() {
        AppMethodBeat.i(160829);
        this.__eventId = px.class.getName().hashCode();
        AppMethodBeat.o(160829);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(px pxVar) {
        String str = null;
        AppMethodBeat.i(66853);
        px pxVar2 = pxVar;
        switch (pxVar2.dVZ.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.eDb();
                c eDc = com.tencent.mm.plugin.product.a.a.eDc();
                if (eDc != null) {
                    m b2 = m.b(null, pxVar2.dVZ.dWb);
                    eDc.a(b2, (List<n>) null);
                    pxVar2.dWa.dWc = eDc.eDu();
                    px.b bVar = pxVar2.dWa;
                    if (!Util.isNullOrNil(b2.eDx())) {
                        str = c.aKj(b2.eDx());
                    }
                    bVar.thumbPath = str;
                    pxVar2.dWa.dFE = true;
                    break;
                } else {
                    Log.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", pxVar2.dVZ.dWb);
                    pxVar2.dWa.dFE = false;
                    break;
                }
        }
        AppMethodBeat.o(66853);
        return false;
    }
}
