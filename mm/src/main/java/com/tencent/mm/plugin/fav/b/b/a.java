package com.tencent.mm.plugin.fav.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends IListener<cu> {
    public a() {
        AppMethodBeat.i(161112);
        this.__eventId = cu.class.getName().hashCode();
        AppMethodBeat.o(161112);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(cu cuVar) {
        AppMethodBeat.i(101578);
        cu cuVar2 = cuVar;
        Log.i("MicroMsg.Fav.DelFavoriteItemListener", "do delete favitem, localId %d", Long.valueOf(cuVar2.dFU.dFW));
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(cuVar2.dFU.dFW);
        cuVar2.dFV.dFE = b.a(DY, (Runnable) null);
        AppMethodBeat.o(101578);
        return false;
    }
}
