package com.tencent.mm.plugin.subapp.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import org.xwalk.core.Log;

public final class c extends IListener<gj> {
    public c() {
        AppMethodBeat.i(161445);
        this.__eventId = gj.class.getName().hashCode();
        AppMethodBeat.o(161445);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gj gjVar) {
        AppMethodBeat.i(29005);
        gj gjVar2 = gjVar;
        if (gjVar2 == null) {
            AppMethodBeat.o(29005);
            return false;
        } else if (Util.isNullOrNil(gjVar2.dKg.fileName)) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.o(29005);
            return false;
        } else {
            r Rr = o.bib().Rr(gjVar2.dKg.fileName);
            if (Rr == null) {
                Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.o(29005);
                return false;
            }
            b.d(Rr.clientId, gjVar2.dKg.dKh, gjVar2.dKg.dKi, gjVar2.dKg.dKj, gjVar2.dKg.result);
            AppMethodBeat.o(29005);
            return true;
        }
    }
}
