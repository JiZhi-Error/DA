package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpayUtil;

public final class f extends IListener<kh> {
    public f() {
        AppMethodBeat.i(160795);
        this.__eventId = kh.class.getName().hashCode();
        AppMethodBeat.o(160795);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(kh khVar) {
        AppMethodBeat.i(64325);
        kh khVar2 = khVar;
        if (khVar2 != null) {
            khVar2.dPp.dPr = TenpayUtil.signWith3Des("passwd=" + khVar2.dPo.dPq);
            Log.v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", khVar2.dPp.dPr);
        }
        AppMethodBeat.o(64325);
        return false;
    }
}
