package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public final class m extends n<euw, eux> {
    public m(int i2, etn etn, byte[] bArr, long j2, int i3) {
        AppMethodBeat.i(115256);
        d.a aVar = new d.a();
        aVar.iLN = new euw();
        aVar.iLO = new eux();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
        aVar.iLP = 62;
        aVar.respCmdId = 1000000062;
        this.rr = aVar.aXF();
        euw euw = (euw) this.rr.iLK.iLR;
        euw.LsZ = i2;
        euw.NsX = etn;
        euw.Lta = j2;
        euw.MKC = z.aTY();
        euw.Leu = i3;
        euw.Lev = new SKBuiltinBuffer_t().setBuffer(bArr);
        euw.NpN = System.currentTimeMillis();
        Log.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + euw.NpN);
        AppMethodBeat.o(115256);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
    }

    public final int fIH() {
        return ((euw) this.rr.iLK.iLR).Leu;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115257);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.m.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115255);
                e.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                try {
                    if (((eux) m.this.fIJ()).LsZ != m.this.GWA.GVV.roomId) {
                        e.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                        AppMethodBeat.o(115255);
                        return;
                    }
                } catch (Exception e2) {
                }
                if (i2 != 0) {
                    e.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                    m.this.GWA.GVV.Hcw.GXc = 11;
                    m.this.GWA.GVV.Hcw.GXe = i3;
                    m.this.GWA.GVV.Hcw.GXd = i3;
                    m.this.GWA.GVV.Hcw.GXu = 3;
                    if (i2 == 1) {
                        m.this.GWA.GVV.Hcw.GXo = 8;
                    } else {
                        m.this.GWA.GVV.Hcw.GXo = 99;
                    }
                    m.this.GWA.K(1, -9004, "");
                    AppMethodBeat.o(115255);
                    return;
                }
                m.this.GWA.GVY.p(qVar);
                AppMethodBeat.o(115255);
            }
        };
        AppMethodBeat.o(115257);
        return r0;
    }
}
