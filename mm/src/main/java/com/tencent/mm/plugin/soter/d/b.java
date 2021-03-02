package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.soter.core.a;

public final class b extends IListener<jt> {
    public b() {
        AppMethodBeat.i(161754);
        this.__eventId = jt.class.getName().hashCode();
        AppMethodBeat.o(161754);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(jt jtVar) {
        int i2 = 1;
        AppMethodBeat.i(130838);
        jt jtVar2 = jtVar;
        int i3 = jtVar2.dOE.dOG;
        Log.i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", Integer.valueOf(i3));
        if (i3 != 1 || !m.flS()) {
            Log.w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            jtVar2.dOF.dOH = -1;
        } else {
            boolean ld = a.ld(MMApplicationContext.getContext());
            Log.i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", Boolean.valueOf(ld));
            jt.b bVar = jtVar2.dOF;
            if (!ld) {
                i2 = 0;
            }
            bVar.dOH = i2;
        }
        AppMethodBeat.o(130838);
        return false;
    }
}
