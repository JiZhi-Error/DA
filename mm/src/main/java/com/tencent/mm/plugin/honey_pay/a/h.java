package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class h extends r {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    public cqs yjE;
    public long yjF;

    public h(long j2, String str, String str2) {
        AppMethodBeat.i(64626);
        d.a aVar = new d.a();
        aVar.iLN = new cqr();
        aVar.iLO = new cqs();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cqr cqr = (cqr) this.rr.iLK.iLR;
        cqr.LpD = j2;
        cqr.LpC = str;
        cqr.LWD = str2;
        this.yjF = j2;
        Log.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", str2, str);
        Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", Long.valueOf(j2));
        AppMethodBeat.o(64626);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2685;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64627);
        Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjE = (cqs) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjE.pTZ), this.yjE.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64627);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cqs cqs = (cqs) ((d) sVar).iLL.iLR;
        this.RtZ = cqs.pTZ;
        this.Rua = cqs.pUa;
    }
}
