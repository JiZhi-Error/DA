package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class a extends r {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    public yn yjx;

    public a() {
        AppMethodBeat.i(64612);
        d.a aVar = new d.a();
        aVar.iLN = new ym();
        aVar.iLO = new yn();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(64612);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2618;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64613);
        Log.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjx = (yn) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjx.pTZ), this.yjx.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64613);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        yn ynVar = (yn) ((d) sVar).iLL.iLR;
        this.RtZ = ynVar.pTZ;
        this.Rua = ynVar.pUa;
    }
}
