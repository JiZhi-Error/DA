package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.smtt.sdk.TbsListener;

public final class c extends n<etk, etl> {
    public c(int i2, long j2, String str, String str2, int i3, int i4) {
        AppMethodBeat.i(115222);
        d.a aVar = new d.a();
        aVar.iLN = new etk();
        aVar.iLO = new etl();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        aVar.funcId = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
        aVar.iLP = 64;
        aVar.respCmdId = 1000000064;
        this.rr = aVar.aXF();
        etk etk = (etk) this.rr.iLK.iLR;
        etk.LsZ = i2;
        etk.Lta = j2;
        etk.xNG = str;
        etk.MKg = i3;
        eus eus = new eus();
        dqi dqi = new dqi();
        dqi.bhy(str2);
        eus.NgE = dqi;
        etk.NqI = eus;
        etk.NpN = System.currentTimeMillis();
        etk.NqK = i4;
        AppMethodBeat.o(115222);
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final int fIG() {
        AppMethodBeat.i(115223);
        etk etk = (etk) fIK();
        if (etk.LsZ == 0 && etk.MKg == 0) {
            AppMethodBeat.o(115223);
            return -1;
        }
        AppMethodBeat.o(115223);
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115224);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115221);
                e.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                AppMethodBeat.o(115221);
            }
        };
        AppMethodBeat.o(115224);
        return r0;
    }
}
