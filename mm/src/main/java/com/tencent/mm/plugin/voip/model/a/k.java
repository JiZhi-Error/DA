package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.protocal.protobuf.euq;
import com.tencent.mm.protocal.protobuf.eur;

public final class k extends n<euq, eur> {
    public k(eca eca) {
        AppMethodBeat.i(115250);
        d.a aVar = new d.a();
        aVar.iLN = new euq();
        aVar.iLO = new eur();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        aVar.funcId = 765;
        aVar.iLP = 765;
        aVar.respCmdId = 1000000765;
        this.rr = aVar.aXF();
        euq euq = (euq) this.rr.iLK.iLR;
        euq.LsZ = eca.LsZ;
        euq.NbR = eca.NbR;
        euq.Llx = eca.Llx;
        euq.NbS = eca.NbS;
        euq.NbT = eca.NbT;
        euq.NbU = eca.NbU;
        euq.NbV = eca.NbV;
        euq.NbW = eca.NbW;
        euq.NbX = eca.NbX;
        euq.NbY = eca.NbY;
        euq.NbZ = eca.NbZ;
        euq.Nca = eca.Nca;
        euq.Ncb = eca.Ncb;
        AppMethodBeat.o(115250);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 765;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115251);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.k.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115249);
                e.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                try {
                    eur eur = (eur) k.this.fIJ();
                    if (eur.NsK == 0 || eur.NsL == 0) {
                        e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + eur.NsL);
                        AppMethodBeat.o(115249);
                    } else if (k.this.GWA.GVA != 1) {
                        e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.GWA.GVA);
                        AppMethodBeat.o(115249);
                    } else {
                        k.this.GWA.GVA = 2;
                        k.this.GWA.GVC = eur.NsG;
                        k.this.GWA.GVV.a(eur);
                        AppMethodBeat.o(115249);
                    }
                } catch (Exception e2) {
                    k.this.GWA.GVA = 0;
                    AppMethodBeat.o(115249);
                }
            }
        };
        AppMethodBeat.o(115251);
        return r0;
    }
}
