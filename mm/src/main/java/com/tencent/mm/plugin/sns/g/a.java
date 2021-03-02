package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;

public final class a implements c.b {
    public IListener DFm = new IListener<vr>() {
        /* class com.tencent.mm.plugin.sns.g.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160646);
            this.__eventId = vr.class.getName().hashCode();
            AppMethodBeat.o(160646);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vr vrVar) {
            AppMethodBeat.i(95171);
            vr vrVar2 = vrVar;
            if (vrVar2 instanceof vr) {
                if (vrVar2.ebQ.dDe == 1) {
                    Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", vrVar2.ebQ.ebR.Id);
                    n nVar = new n(vrVar2.ebQ.ebR);
                    nVar.DEs = 1;
                    nVar.dPI = vrVar2.ebQ.ebR.Id;
                    if (vrVar2.ebQ.ebR.oUv == 6) {
                        aj.faJ().a(vrVar2.ebQ.ebR, 5, nVar, bp.Oqv);
                    } else {
                        aj.faJ().a(vrVar2.ebQ.ebR, 1, nVar, bp.Oqv);
                    }
                } else if (vrVar2.ebQ.dDe == 3) {
                    String ki = ar.ki(aj.getAccSnsPath(), vrVar2.ebQ.mediaId);
                    String aOf = r.aOf(vrVar2.ebQ.mediaId);
                    vrVar2.ebQ.path = ki + aOf;
                } else if (vrVar2.ebQ.dDe == 4) {
                    n nVar2 = new n(vrVar2.ebQ.ebR);
                    nVar2.DEs = 3;
                    nVar2.dPI = vrVar2.ebQ.ebR.Id;
                    if (vrVar2.ebQ.ebR.oUv == 6) {
                        aj.faJ().a(vrVar2.ebQ.ebR, 4, (n) null, bp.Oqv);
                    } else {
                        aj.faJ().a(vrVar2.ebQ.ebR, 2, nVar2, bp.Oqv);
                    }
                }
            }
            AppMethodBeat.o(95171);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(95172);
        EventCenter.instance.addListener(this.DFm);
        aj.faJ().a(this);
        AppMethodBeat.o(95172);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
        AppMethodBeat.i(95173);
        Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", str);
        vr vrVar = new vr();
        vrVar.ebQ.dDe = 2;
        vrVar.ebQ.mediaId = str;
        String ki = ar.ki(aj.getAccSnsPath(), str);
        vrVar.ebQ.path = ki + r.aOf(str);
        EventCenter.instance.publish(vrVar);
        AppMethodBeat.o(95173);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
        AppMethodBeat.i(202663);
        Log.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onImageFinish mediaId=%s isOk=%s", str, Boolean.valueOf(z));
        vr vrVar = new vr();
        vrVar.ebQ.dDe = 5;
        vrVar.ebQ.mediaId = str;
        String ki = ar.ki(aj.getAccSnsPath(), str);
        vrVar.ebQ.path = ki + r.aOh(str);
        EventCenter.instance.publish(vrVar);
        AppMethodBeat.o(202663);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }
}
