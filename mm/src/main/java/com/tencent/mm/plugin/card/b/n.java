package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.ca;

public final class n extends IListener<kj> implements i {
    private long dFm = 0;

    public n() {
        AppMethodBeat.i(161193);
        this.__eventId = kj.class.getName().hashCode();
        AppMethodBeat.o(161193);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(kj kjVar) {
        AppMethodBeat.i(112712);
        boolean a2 = a(kjVar);
        AppMethodBeat.o(112712);
        return a2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112710);
        if (qVar instanceof af) {
            String str2 = ((af) qVar).eaP;
            ca Hb = ((l) g.af(l.class)).eiy().Hb(this.dFm);
            if (i2 == 0 && i3 == 0) {
                Hb.setStatus(2);
            } else {
                Hb.setStatus(5);
            }
            k.b HD = k.b.HD(Hb.field_content);
            d ajZ = com.tencent.mm.plugin.card.d.g.ajZ(Hb.field_content);
            ajZ.eaP = str2;
            HD.ixT = com.tencent.mm.plugin.card.d.g.a(ajZ);
            HD.dPu = k.b.a(HD, null, null);
            Hb.setContent(k.b.a(HD, null, null));
            ((l) g.af(l.class)).eiy().a(this.dFm, Hb);
            g.aAg().hqi.b(1045, this);
        }
        AppMethodBeat.o(112710);
    }

    private boolean a(kj kjVar) {
        d dVar;
        AppMethodBeat.i(112711);
        if (kjVar instanceof kj) {
            String str = kjVar.dPt.dPu;
            this.dFm = kjVar.dPt.dFm;
            String str2 = kjVar.dPt.dPv;
            d ajZ = com.tencent.mm.plugin.card.d.g.ajZ(str);
            ca Hb = ((l) g.af(l.class)).eiy().Hb(this.dFm);
            Hb.setStatus(1);
            ((l) g.af(l.class)).eiy().a(this.dFm, Hb);
            if (ajZ == null) {
                dVar = com.tencent.mm.plugin.card.d.g.ajZ(Hb.field_content);
            } else {
                dVar = ajZ;
            }
            if (dVar != null) {
                g.aAg().hqi.a(1045, this);
                g.aAg().hqi.a(new af(dVar.eaO, str2, 17), 0);
            }
            AppMethodBeat.o(112711);
            return true;
        }
        AppMethodBeat.o(112711);
        return false;
    }
}
