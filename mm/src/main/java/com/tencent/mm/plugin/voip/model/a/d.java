package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.etq;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends n<etq, etr> {
    public d(int i2, long j2, int i3, int i4, int i5, int i6, int i7, byte[] bArr, int i8) {
        AppMethodBeat.i(115226);
        d.a aVar = new d.a();
        aVar.iLN = new etq();
        aVar.iLO = new etr();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.funcId = cr.CTRL_INDEX;
        aVar.iLP = cr.CTRL_INDEX;
        aVar.respCmdId = 1000000249;
        this.rr = aVar.aXF();
        etq etq = (etq) this.rr.iLK.iLR;
        etq.LsZ = i2;
        etq.Lta = j2;
        etq.MKr = i3;
        etq.NqM = i4;
        etq.NqN = i5;
        etq.NqO = i6;
        etq.NqP = i7;
        etq.NqQ = 1;
        etq.KMS = new SKBuiltinBuffer_t().setBuffer(bArr, 0, i8);
        AppMethodBeat.o(115226);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return cr.CTRL_INDEX;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final void jC(int i2, int i3) {
        AppMethodBeat.i(115227);
        if (i2 == 0 && i3 == 0) {
            etr etr = (etr) fIJ();
            if (etr != null) {
                Log.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(etr.LsZ), Long.valueOf(etr.Lta), Integer.valueOf(etr.MKr));
            }
            AppMethodBeat.o(115227);
            return;
        }
        Log.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
        AppMethodBeat.o(115227);
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115228);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.d.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115225);
                e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i2 + " errCode:" + i3 + " status:" + d.this.GWA.mStatus);
                if (i3 != 0) {
                    e.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(i3)));
                    AppMethodBeat.o(115225);
                    return;
                }
                etr etr = (etr) d.this.fIJ();
                d.this.GWA.GVI = etr.MyU;
                if (d.this.GWA.GVI == 0) {
                    AppMethodBeat.o(115225);
                    return;
                }
                if (d.this.GWA.GVV.doubleLinkSwitch(etr.NqR) == 0) {
                    if (1 == etr.NqR) {
                        d.this.GWA.GVV.HbH++;
                    } else if (2 == etr.NqR) {
                        d.this.GWA.GVV.HbI++;
                    }
                }
                e.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + etr.LsZ + " member " + etr.MKr + " key " + etr.Lta + "report flag " + etr.MyU + "switch to link type " + etr.NqR + "doubleLinkSwitchReportStatus " + d.this.GWA.GVI + "mDoubleLinkSwitchSucToDirectCnt" + d.this.GWA.GVV.HbH + "mDoubleLinkSwitchSucToRelayCnt" + d.this.GWA.GVV.HbI);
                AppMethodBeat.o(115225);
            }
        };
        AppMethodBeat.o(115228);
        return r0;
    }
}
