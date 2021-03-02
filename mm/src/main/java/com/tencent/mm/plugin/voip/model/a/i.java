package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.eun;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.smtt.sdk.TbsListener;

public final class i extends n<eum, eun> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i2, long j2, String str) {
        AppMethodBeat.i(115244);
        d.a aVar = new d.a();
        aVar.iLN = new eum();
        aVar.iLO = new eun();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
        aVar.iLP = 66;
        aVar.respCmdId = 1000000066;
        this.rr = aVar.aXF();
        eum eum = (eum) this.rr.iLK.iLR;
        eum.LsZ = i2;
        eum.Lta = j2;
        eus eus = new eus();
        dqi dqi = new dqi();
        dqi.bhy(str);
        eus.NgE = dqi;
        eum.NqI = eus;
        eum.NpN = System.currentTimeMillis();
        AppMethodBeat.o(115244);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final com.tencent.mm.ak.i fIF() {
        AppMethodBeat.i(115245);
        AnonymousClass1 r0 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.voip.model.a.i.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115243);
                e.Logd(i.this.TAG, "onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                AppMethodBeat.o(115243);
            }
        };
        AppMethodBeat.o(115245);
        return r0;
    }
}
