package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class am extends r {
    public cah yXe;

    public am(String str, String str2, String str3) {
        AppMethodBeat.i(65283);
        d.a aVar = new d.a();
        aVar.iLN = new cag();
        aVar.iLO = new cah();
        aVar.funcId = 2929;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cag cag = (cag) this.rr.iLK.iLR;
        cag.yQE = str;
        cag.qvD = str2;
        cag.yXL = str3;
        Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", str, str3);
        AppMethodBeat.o(65283);
    }

    public am() {
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(65284);
        this.yXe = (cah) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.yXe.dDN), this.yXe.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(65284);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cah cah = (cah) ((d) sVar).iLL.iLR;
        this.RtZ = cah.dDN;
        this.Rua = cah.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2929;
    }
}
