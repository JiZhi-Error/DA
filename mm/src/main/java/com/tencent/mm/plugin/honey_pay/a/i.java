package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class i extends r {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    public int cSx;
    private cqu yjG;

    public i(int i2) {
        AppMethodBeat.i(64628);
        d.a aVar = new d.a();
        aVar.iLN = new cqt();
        aVar.iLO = new cqu();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((cqt) this.rr.iLK.iLR).HFB = i2;
        this.cSx = i2;
        Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", Integer.valueOf(i2));
        AppMethodBeat.o(64628);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2742;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64629);
        Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjG = (cqu) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjG.pTZ), this.yjG.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64629);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cqu cqu = (cqu) ((d) sVar).iLL.iLR;
        this.RtZ = cqu.pTZ;
        this.Rua = cqu.pUa;
    }
}
