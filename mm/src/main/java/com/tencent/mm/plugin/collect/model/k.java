package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class k extends r {
    public dqt qwj;

    public k(String str, int i2) {
        AppMethodBeat.i(63825);
        d.a aVar = new d.a();
        aVar.iLN = new dqs();
        aVar.iLO = new dqt();
        aVar.funcId = 1800;
        aVar.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dqs dqs = (dqs) this.rr.iLK.iLR;
        dqs.MTB = str;
        dqs.scene = i2;
        Log.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", str, Integer.valueOf(i2));
        AppMethodBeat.o(63825);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63826);
        this.qwj = (dqt) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.qwj.dDN), this.qwj.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63826);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dqt dqt = (dqt) ((d) sVar).iLL.iLR;
        this.RtZ = dqt.dDN;
        this.Rua = dqt.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1800;
    }
}
