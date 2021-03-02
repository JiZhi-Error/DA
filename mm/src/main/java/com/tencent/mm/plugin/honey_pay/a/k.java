package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class k extends r {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    public dhd yjI;

    public k(String str) {
        AppMethodBeat.i(64632);
        d.a aVar = new d.a();
        aVar.iLN = new dhc();
        aVar.iLO = new dhd();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dhc) this.rr.iLK.iLR).LWD = str;
        AppMethodBeat.o(64632);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2851;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64633);
        Log.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjI = (dhd) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjI.pTZ), this.yjI.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64633);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhd dhd = (dhd) ((d) sVar).iLL.iLR;
        this.RtZ = dhd.pTZ;
        this.Rua = dhd.pUa;
    }
}
