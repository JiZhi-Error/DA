package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends IListener<ke> {
    public e() {
        AppMethodBeat.i(160633);
        this.__eventId = ke.class.getName().hashCode();
        AppMethodBeat.o(160633);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ke keVar) {
        AppMethodBeat.i(94893);
        ke keVar2 = keVar;
        if (!(keVar2 instanceof ke)) {
            Log.f("MicroMsg.GetSnsTagListListener", "mismatched event");
            AppMethodBeat.o(94893);
            return false;
        }
        if (keVar2.dPe.dKy == 0) {
            g.aAi();
            g.aAg().hqi.a(new w(1), 0);
        } else {
            g.aAi();
            g.aAg().hqi.a(new w(keVar2.dPe.dKy), 0);
        }
        AppMethodBeat.o(94893);
        return true;
    }
}
