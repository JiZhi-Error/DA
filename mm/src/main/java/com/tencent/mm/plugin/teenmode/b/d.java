package com.tencent.mm.plugin.teenmode.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends IListener<yu> {
    public d() {
        AppMethodBeat.i(187383);
        this.__eventId = yu.class.getName().hashCode();
        AppMethodBeat.o(187383);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(yu yuVar) {
        AppMethodBeat.i(187384);
        Log.v("MicroMsg.UpdateTeenModeDataListener", "UpdateTeenModeDataListener callback");
        ((b) g.af(b.class)).fvq();
        AppMethodBeat.o(187384);
        return true;
    }
}
