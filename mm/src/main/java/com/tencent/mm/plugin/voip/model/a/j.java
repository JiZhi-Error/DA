package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.eua;
import com.tencent.mm.protocal.protobuf.euo;
import com.tencent.mm.protocal.protobuf.eup;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class j extends n<euo, eup> {
    public j(long j2, long j3, int i2, String str, String str2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(115247);
        d.a aVar = new d.a();
        aVar.iLN = new euo();
        aVar.iLO = new eup();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        aVar.funcId = 901;
        aVar.iLP = 901;
        aVar.respCmdId = 1000000901;
        this.rr = aVar.aXF();
        euo euo = (euo) this.rr.iLK.iLR;
        euo.NsG = j2;
        euo.Lta = j3;
        euo.Llx = i2;
        euo.NsH = new dqi().bhy(str);
        euo.NsI = new dqi().bhy(str2);
        euo.KUt = 0.0d;
        euo.KUu = 0.0d;
        euo.LsZ = i3;
        euo.NsJ = i4;
        try {
            eua eua = (eua) new eua().parseFrom(bArr);
            for (int i5 = 0; i5 < eua.Nru.size(); i5++) {
                eby eby = new eby();
                eby.NbD = eua.Nru.get(i5).Nre;
                eby.NbE = eua.Nru.get(i5).Nrf;
                eby.NbF = eua.Nru.get(i5).Nrg;
                eby.NbG = new esq();
                eby.NbG.NgB = eua.Nru.get(i5).Nrh;
                eby.NbG.MKe = eua.Nru.get(i5).Nri;
                eby.NbG.NgC = eua.Nru.get(i5).Nrs;
                eby.NbH = eua.Nru.get(i5).Nrj;
                eby.NbI = eua.Nru.get(i5).Nrk;
                eby.NbJ = eua.Nru.get(i5).Nrl;
                eby.NbK = eua.Nru.get(i5).Nrn.size();
                for (int i6 = 0; i6 < eby.NbK; i6++) {
                    eby.NbL.add(eua.Nru.get(i5).Nrn.get(i6));
                }
                eby.NbM = eua.Nru.get(i5).Nro;
                for (int i7 = 0; i7 < eby.NbM; i7++) {
                    eby.NbN.add(eua.Nru.get(i5).Nrp.get(i7));
                }
                eby.NbO = eua.Nru.get(i5).Nrq;
                for (int i8 = 0; i8 < eby.NbO; i8++) {
                    eby.NbP.add(eua.Nru.get(i5).Nrr.get(i8));
                }
                eby.NbQ = eua.Nru.get(i5).Nrt;
                euo.LWv.add(eby);
                e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext NetSceneVoipSpeedResult testid:" + j2 + " roomkey=" + j3 + " ipstr=" + eby.NbG.NgC + " client ipstr=" + eby.NbQ);
            }
            AppMethodBeat.o(115247);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneVoipSpeedResult", e2, "", new Object[0]);
            AppMethodBeat.o(115247);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 901;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115248);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.j.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115246);
                e.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i2 + " errCode=" + i3 + " errMsg=" + str);
                j.this.GWA.fGo();
                AppMethodBeat.o(115246);
            }
        };
        AppMethodBeat.o(115248);
        return r0;
    }
}
