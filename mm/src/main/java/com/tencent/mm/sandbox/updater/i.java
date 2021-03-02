package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.sdk.event.IListener;

public final class i extends IListener<yv> {
    public i() {
        AppMethodBeat.i(161486);
        this.__eventId = yv.class.getName().hashCode();
        AppMethodBeat.o(161486);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(yv yvVar) {
        Updater e2;
        AppMethodBeat.i(32724);
        yv yvVar2 = yvVar;
        if ((yvVar2 instanceof yv) && (e2 = Updater.e(yvVar2.efb.context, null)) != null) {
            if (((a) g.ah(a.class)).openUpdater()) {
                ((a) g.ah(a.class)).manualCheckUpdate(2);
            } else {
                e2.bB(yvVar2.efb.type, true);
            }
        }
        AppMethodBeat.o(32724);
        return false;
    }
}
