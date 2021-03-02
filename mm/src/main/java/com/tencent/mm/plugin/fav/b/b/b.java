package com.tencent.mm.plugin.fav.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends IListener<gz> {
    public b() {
        AppMethodBeat.i(161113);
        this.__eventId = gz.class.getName().hashCode();
        AppMethodBeat.o(161113);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gz gzVar) {
        int v;
        AppMethodBeat.i(101579);
        gz gzVar2 = gzVar;
        Log.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (((af) g.ah(af.class)).getSendService().big()) {
            Log.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
            AppMethodBeat.o(101579);
        } else {
            byte[] bArr = gzVar2.dLh.dLi;
            if (bArr == null) {
                v = 1;
            } else {
                v = o.v(bArr, 0);
            }
            g.azz().a(new ak(v), 0);
            AppMethodBeat.o(101579);
        }
        return false;
    }
}
