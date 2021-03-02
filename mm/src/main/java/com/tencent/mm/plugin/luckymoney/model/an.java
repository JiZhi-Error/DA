package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class an extends r {
    public eln yXf;

    public an(String str, String str2, String str3) {
        AppMethodBeat.i(213316);
        d.a aVar = new d.a();
        aVar.iLN = new elm();
        aVar.iLO = new eln();
        aVar.funcId = 5160;
        aVar.uri = "/cgi-bin/mmpay-bin/unionhb/businesscallbackunionhb";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elm elm = (elm) this.rr.iLK.iLR;
        elm.yQE = str;
        elm.qvD = str2;
        elm.yXL = str3;
        elm.NkC = 0;
        Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "NetSceneLuckyMoneyBusinessCallbackUnion request sendId: %s, %s", str, str3);
        AppMethodBeat.o(213316);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(213317);
        this.yXf = (eln) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallbackUnion", "retcode: %s, retmsg: %s", Integer.valueOf(this.yXf.dDN), this.yXf.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(213317);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        eln eln = (eln) ((d) sVar).iLL.iLR;
        this.RtZ = eln.dDN;
        this.Rua = eln.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5160;
    }
}
