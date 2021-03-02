package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends IListener<gp> {
    public e() {
        AppMethodBeat.i(161617);
        this.__eventId = gp.class.getName().hashCode();
        AppMethodBeat.o(161617);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gp gpVar) {
        AppMethodBeat.i(130991);
        gp gpVar2 = gpVar;
        if (!(gpVar2 instanceof gp)) {
            AppMethodBeat.o(130991);
        } else {
            gpVar2.dKA.dKD = true;
            if (!Util.isNullOrNil(l.Tc(gpVar2.dKz.dKB))) {
                gpVar2.dKA.dKD = false;
                AppMethodBeat.o(130991);
            } else if (!Util.isNullOrNil(l.Tc(gpVar2.dKz.dKC))) {
                gpVar2.dKA.dKD = false;
                AppMethodBeat.o(130991);
            } else {
                Log.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
                AppMethodBeat.o(130991);
            }
        }
        return false;
    }
}
