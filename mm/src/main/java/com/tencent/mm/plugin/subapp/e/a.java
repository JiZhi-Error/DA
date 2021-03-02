package com.tencent.mm.plugin.subapp.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends IListener<gi> {
    public a() {
        AppMethodBeat.i(161444);
        this.__eventId = gi.class.getName().hashCode();
        AppMethodBeat.o(161444);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gi giVar) {
        AppMethodBeat.i(29003);
        gi giVar2 = giVar;
        if (giVar2 == null) {
            AppMethodBeat.o(29003);
            return false;
        } else if (Util.isNullOrNil(giVar2.dKe.fileName)) {
            Log.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.o(29003);
            return false;
        } else {
            r Rr = o.bib().Rr(giVar2.dKe.fileName);
            if (Rr == null) {
                Log.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.o(29003);
                return false;
            }
            if (giVar2.dKe.dKf == 1 || giVar2.dKe.dKf == 2) {
                String str = Rr.clientId;
                int i2 = giVar2.dKe.scene;
                Log.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i2));
                h.INSTANCE.a(14220, Integer.valueOf(i2), 0, 0, 0, 0, 0, 0, str);
            } else if (giVar2.dKe.dKf == 3) {
                String str2 = Rr.clientId;
                int i3 = giVar2.dKe.scene;
                Log.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", str2, Integer.valueOf(i3));
                h.INSTANCE.a(14220, 0, Integer.valueOf(i3), 0, 0, 0, 0, 0, str2);
            }
            AppMethodBeat.o(29003);
            return true;
        }
    }
}
