package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends IListener<rm> {
    public j() {
        AppMethodBeat.i(160797);
        this.__eventId = rm.class.getName().hashCode();
        AppMethodBeat.o(160797);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(rm rmVar) {
        AppMethodBeat.i(64343);
        rm rmVar2 = rmVar;
        if (!g.aAc()) {
            Log.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (rmVar2 instanceof rm) {
            Log.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            ((i) g.af(i.class)).cancel();
            AppMethodBeat.o(64343);
            return true;
        }
        AppMethodBeat.o(64343);
        return false;
    }
}
