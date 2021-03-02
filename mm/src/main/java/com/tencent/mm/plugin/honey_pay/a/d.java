package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class d extends r {
    private final String TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    public bmc yjA;

    public d(String str, long j2) {
        AppMethodBeat.i(64618);
        d.a aVar = new d.a();
        aVar.iLN = new bmb();
        aVar.iLO = new bmc();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bmb bmb = (bmb) this.rr.iLK.iLR;
        bmb.LjH = str;
        bmb.LpD = j2;
        bmb.LUV = k.elk();
        Log.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", str, Long.valueOf(j2));
        AppMethodBeat.o(64618);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2630;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64619);
        Log.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjA = (bmc) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjA.pTZ), this.yjA.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64619);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        bmc bmc = (bmc) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.RtZ = bmc.pTZ;
        this.Rua = bmc.pUa;
    }
}
