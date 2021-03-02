package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;

public final class n implements y<de> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* synthetic */ void a(de deVar) {
        AppMethodBeat.i(22374);
        String a2 = z.a(deVar.KHl);
        if (!Util.isNullOrNil(a2) && !((l) g.af(l.class)).aSN().bjN(a2)) {
            ay.a.iDq.aL(a2, "");
        }
        AppMethodBeat.o(22374);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* synthetic */ void b(de deVar) {
        AppMethodBeat.i(22373);
        de deVar2 = deVar;
        final String a2 = z.a(deVar2.KHl);
        if (ab.Eq(a2)) {
            bg.aVF();
            final ah Ke = c.aSX().Ke(a2);
            bg.aVF();
            as Kn = c.aSN().Kn(a2);
            if (Kn == null || ((int) Kn.gMZ) <= 0) {
                ay.a.iDq.a(a2, null, new ay.b.a() {
                    /* class com.tencent.mm.plugin.bbom.n.AnonymousClass1 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                        AppMethodBeat.i(22372);
                        if (Ke != null && Ke.gBu()) {
                            nf nfVar = new nf();
                            nfVar.dTf.chatroomName = a2;
                            nfVar.dTf.dTg = Ke.gBt();
                            EventCenter.instance.publish(nfVar);
                        }
                        AppMethodBeat.o(22372);
                    }
                });
            } else if (Ke.gBu()) {
                nf nfVar = new nf();
                nfVar.dTf.chatroomName = a2;
                nfVar.dTf.dTg = Ke.gBt();
                EventCenter.instance.publish(nfVar);
            }
        }
        br.E(a2, deVar2.Brn);
        AppMethodBeat.o(22373);
    }
}
