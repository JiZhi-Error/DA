package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class j extends IListener<qi> {
    public j() {
        AppMethodBeat.i(161285);
        this.__eventId = qi.class.getName().hashCode();
        AppMethodBeat.o(161285);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(qi qiVar) {
        AppMethodBeat.i(20792);
        qi qiVar2 = qiVar;
        Log.i("MicroMsg.RcptAddressEventListener", "revent " + qiVar2.dWH.dWJ);
        s.nw(qiVar2.dWH.dWJ, g.aAh().cachePath + "address");
        a.bqd().ksY = true;
        AppMethodBeat.o(20792);
        return false;
    }
}
