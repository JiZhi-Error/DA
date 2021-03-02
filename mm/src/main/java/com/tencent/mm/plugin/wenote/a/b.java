package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends IListener<pa> {
    public b() {
        AppMethodBeat.i(161477);
        this.__eventId = pa.class.getName().hashCode();
        AppMethodBeat.o(161477);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(pa paVar) {
        AppMethodBeat.i(30260);
        pa paVar2 = paVar;
        if (!paVar2.dVb.dUo) {
            h.INSTANCE.a(14789, 2);
        } else {
            h.INSTANCE.a(14789, 3);
        }
        Log.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        j jVar = new j();
        jVar.JGY = a.a(paVar2.dVb);
        jVar.JGZ = 2;
        c.gjz().JGL = jVar;
        and and = new and();
        and.scene = paVar2.dVb.scene;
        jVar.a(paVar2.dVb.dVc, Long.valueOf(paVar2.dVb.msgId), paVar2.dVb.dUo, paVar2.dVb.context, 0, 0, and, paVar2.dVb.dUl);
        AppMethodBeat.o(30260);
        return false;
    }
}
