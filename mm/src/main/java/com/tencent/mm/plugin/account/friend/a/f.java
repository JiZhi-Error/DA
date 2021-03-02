package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends IListener<gq> {
    public f() {
        AppMethodBeat.i(161618);
        this.__eventId = gq.class.getName().hashCode();
        AppMethodBeat.o(161618);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gq gqVar) {
        AppMethodBeat.i(130992);
        gq gqVar2 = gqVar;
        gqVar2.dKF.dKG = l.Tc(gqVar2.dKE.dKB);
        if (Util.isNullOrNil(gqVar2.dKF.dKG)) {
            gqVar2.dKF.dKG = l.Tc(gqVar2.dKE.dKC);
        }
        AppMethodBeat.o(130992);
        return false;
    }
}
