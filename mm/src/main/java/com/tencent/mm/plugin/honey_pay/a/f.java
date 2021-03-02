package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class f extends r {
    private final String TAG = "MicroMsg.NetSceneHoneyPayerList";
    public cbu yjC;

    public f() {
        AppMethodBeat.i(64622);
        d.a aVar = new d.a();
        aVar.iLN = new cbt();
        aVar.iLO = new cbu();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(64622);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2725;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64623);
        Log.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjC = (cbu) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjC.pTZ), this.yjC.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64623);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cbu cbu = (cbu) ((d) sVar).iLL.iLR;
        this.RtZ = cbu.pTZ;
        this.Rua = cbu.pUa;
    }
}
