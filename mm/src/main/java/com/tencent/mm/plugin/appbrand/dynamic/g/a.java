package com.tencent.mm.plugin.appbrand.dynamic.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.protocal.protobuf.ffa;

public final class a extends c<chg> {
    private int dMe;
    private int loG;
    public j lpa;
    public final d rr;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* bridge */ /* synthetic */ void a(int i2, int i3, String str, chg chg, q qVar) {
        AppMethodBeat.i(121419);
        a(i2, i3, str, chg);
        AppMethodBeat.o(121419);
    }

    public a(String str, boolean z, ffa ffa) {
        AppMethodBeat.i(121417);
        chf chf = new chf();
        chf.jfi = str;
        chf.MmF = ffa;
        chf.Mbn = z ? 1 : 2;
        d.a aVar = new d.a();
        aVar.funcId = 1181;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxawidget";
        aVar.iLN = chf;
        aVar.iLO = new chg();
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        this.loG = ffa.NAo;
        this.dMe = b.dV(this.loG, ffa.MjZ);
        AppMethodBeat.o(121417);
    }

    private String getAppId() {
        return ((chf) this.rr.iLK.iLR).jfi;
    }

    public final void a(int i2, int i3, String str, chg chg) {
        AppMethodBeat.i(121418);
        u.i("MicroMsg.CgiLaunchWxaWidget", "onCgiBack, errType %d, errCode %d, errMsg %s, req appId %s", Integer.valueOf(i2), Integer.valueOf(i3), str, getAppId());
        if (i2 == 0 && i3 == 0 && chg != null) {
            String appId = getAppId();
            this.lpa = ((com.tencent.mm.plugin.appbrand.widget.a.b) g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE().a(appId, this.dMe, this.loG, chg);
            if (chg.MmH != null) {
                String aX = ((e) g.af(e.class)).bub().aX(appId, this.dMe);
                fcs fcs = new fcs();
                fcs.NyF = aX;
                fcs.KSa = chg.MmH.KSa;
                if (this.dMe == 10102) {
                    fcs.NyE = chg.MmH.NxN;
                    ((e) g.af(e.class)).bub().a(appId, fcs, this.dMe);
                    AppMethodBeat.o(121418);
                    return;
                } else if (this.dMe == 10002) {
                    fcs.NyE = chg.MmH.NxM;
                    ((e) g.af(e.class)).bub().a(appId, fcs, this.dMe);
                }
            }
            AppMethodBeat.o(121418);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.j.bBN().Yp(getAppId());
        this.lpa = ((com.tencent.mm.plugin.appbrand.widget.a.b) g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE().U(getAppId(), this.dMe, this.loG);
        AppMethodBeat.o(121418);
    }
}
