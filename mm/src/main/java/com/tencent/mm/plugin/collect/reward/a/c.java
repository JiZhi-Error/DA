package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class c extends r {
    public dqw qxC;

    public c(String str, int i2) {
        AppMethodBeat.i(63897);
        d.a aVar = new d.a();
        aVar.iLN = new dqv();
        aVar.iLO = new dqw();
        aVar.funcId = 2811;
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dqv dqv = (dqv) this.rr.iLK.iLR;
        dqv.MTB = str;
        dqv.scene = i2;
        Log.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i2));
        AppMethodBeat.o(63897);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63898);
        this.qxC = (dqw) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxC.dDN), this.qxC.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63898);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dqw dqw = (dqw) ((d) sVar).iLL.iLR;
        this.RtZ = dqw.dDN;
        this.Rua = dqw.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2811;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final boolean czQ() {
        return true;
    }
}
