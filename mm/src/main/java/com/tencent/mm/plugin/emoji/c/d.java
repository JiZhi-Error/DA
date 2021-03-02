package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends IListener<sw> {
    public d() {
        AppMethodBeat.i(161068);
        this.__eventId = sw.class.getName().hashCode();
        AppMethodBeat.o(161068);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(sw swVar) {
        AppMethodBeat.i(108391);
        sw swVar2 = swVar;
        if (swVar2 instanceof sw) {
            if (swVar2.dZp.msgId == 0) {
                com.tencent.mm.plugin.emoji.model.d cGd = k.cGd();
                long j2 = swVar2.dZp.dZs;
                cGd.rbe.put(Long.valueOf(j2), swVar2.dZp.dZq);
            } else {
                Log.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        AppMethodBeat.o(108391);
        return false;
    }
}
