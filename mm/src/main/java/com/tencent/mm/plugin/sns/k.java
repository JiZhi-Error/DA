package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.plugin.sns.model.ac;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends IListener<rq> {
    public k() {
        AppMethodBeat.i(160638);
        this.__eventId = rq.class.getName().hashCode();
        AppMethodBeat.o(160638);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(rq rqVar) {
        AppMethodBeat.i(94905);
        rq rqVar2 = rqVar;
        if (!(rqVar2 instanceof rq)) {
            Log.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
            AppMethodBeat.o(94905);
            return false;
        }
        if (rqVar2.dYj.state == 0) {
            Log.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
            ac.yHD = true;
            ac acVar = new ac();
            acVar.DJF = System.currentTimeMillis();
            if (!acVar.DJE) {
                new ac.a().y("");
            }
        } else {
            Log.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
            ac.yHD = false;
        }
        AppMethodBeat.o(94905);
        return true;
    }
}
