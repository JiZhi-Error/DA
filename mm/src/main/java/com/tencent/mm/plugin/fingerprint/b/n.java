package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class n extends IListener<xg> {
    public n() {
        AppMethodBeat.i(160798);
        this.__eventId = xg.class.getName().hashCode();
        AppMethodBeat.o(160798);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(xg xgVar) {
        AppMethodBeat.i(64386);
        xg xgVar2 = xgVar;
        if (!g.aAc()) {
            Log.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (xgVar2 instanceof xg) {
            Log.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean fN = ((i) g.af(i.class)).fN(MMApplicationContext.getContext());
            Log.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is ".concat(String.valueOf(fN)));
            xg.a aVar = new xg.a();
            aVar.edB = fN;
            xgVar2.edA = aVar;
            if (xgVar2.callback != null) {
                xgVar2.callback.run();
            }
            AppMethodBeat.o(64386);
            return true;
        }
        AppMethodBeat.o(64386);
        return false;
    }
}
