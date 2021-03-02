package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.etu;
import com.tencent.mm.protocal.protobuf.etv;

public final class f extends n<etu, etv> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i2, long j2, int i3) {
        AppMethodBeat.i(115234);
        d.a aVar = new d.a();
        aVar.iLN = new etu();
        aVar.iLO = new etv();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.funcId = 178;
        aVar.iLP = 81;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        etu etu = (etu) this.rr.iLK.iLR;
        etu.LsZ = i2;
        etu.Lta = j2;
        etu.NpN = System.currentTimeMillis();
        etu.NqU = i3;
        AppMethodBeat.o(115234);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 178;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115235);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.f.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115233);
                if (i2 == 0 || i3 != 231) {
                    AppMethodBeat.o(115233);
                    return;
                }
                e.Loge(f.this.TAG, "Voip heartbeat Failed, type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                f.this.GWA.GVV.Hcw.GXc = 111;
                f.this.GWA.GVV.Hcw.GXd = i3;
                f.this.GWA.GVV.Hcw.GXu = 2;
                f.this.GWA.K(1, -9004, "");
                AppMethodBeat.o(115233);
            }
        };
        AppMethodBeat.o(115235);
        return r0;
    }
}
