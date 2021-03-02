package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends b {
    public rr CiK;
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private i callback;
    private d rr;

    public c(String str, String str2) {
        AppMethodBeat.i(67355);
        d.a aVar = new d.a();
        aVar.iLN = new rq();
        aVar.iLO = new rr();
        aVar.funcId = 1340;
        aVar.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        rq rqVar = (rq) this.rr.iLK.iLR;
        rqVar.KZa = str;
        rqVar.CpP = str2;
        AppMethodBeat.o(67355);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1340;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67356);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67356);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67357);
        Log.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiK = (rr) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiK.dDN), this.CiK.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67357);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        rr rrVar = (rr) ((d) sVar).iLL.iLR;
        this.RtZ = rrVar.dDN;
        this.Rua = rrVar.qwn;
    }
}
