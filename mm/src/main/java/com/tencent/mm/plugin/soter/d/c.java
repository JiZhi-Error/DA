package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends IListener<jv> {
    public c() {
        AppMethodBeat.i(161755);
        this.__eventId = jv.class.getName().hashCode();
        AppMethodBeat.o(161755);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(jv jvVar) {
        AppMethodBeat.i(130839);
        jv jvVar2 = jvVar;
        if (jvVar2 instanceof jv) {
            Log.i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            Log.i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", Boolean.valueOf(m.flS()));
            if (m.flS()) {
                jvVar2.dON.dOO = 1;
            } else {
                jvVar2.dON.dOO = 0;
            }
        }
        AppMethodBeat.o(130839);
        return true;
    }
}
