package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class g extends r {
    private final String TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    public bqc yjD;

    public g(String str, long j2) {
        AppMethodBeat.i(64624);
        d.a aVar = new d.a();
        aVar.iLN = new bqb();
        aVar.iLO = new bqc();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bqb bqb = (bqb) this.rr.iLK.iLR;
        bqb.LWD = str;
        bqb.LpD = j2;
        Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", str, Long.valueOf(j2));
        AppMethodBeat.o(64624);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2815;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64625);
        Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjD = (bqc) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjD.pTZ), this.yjD.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64625);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        bqc bqc = (bqc) ((d) sVar).iLL.iLR;
        this.RtZ = bqc.pTZ;
        this.Rua = bqc.pUa;
    }
}
