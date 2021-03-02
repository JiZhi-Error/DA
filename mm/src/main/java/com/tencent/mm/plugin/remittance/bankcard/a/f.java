package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends b {
    public String CiJ;
    public agu CiN;
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private i callback;
    private d rr;

    public f(String str) {
        AppMethodBeat.i(67364);
        d.a aVar = new d.a();
        aVar.iLN = new agt();
        aVar.iLO = new agu();
        aVar.funcId = 1395;
        aVar.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((agt) this.rr.iLK.iLR).Cjt = str;
        this.CiJ = str;
        AppMethodBeat.o(67364);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1395;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67365);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67365);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67366);
        Log.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiN = (agu) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiN.dDN), this.CiN.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67366);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        agu agu = (agu) ((d) sVar).iLL.iLR;
        this.RtZ = agu.dDN;
        this.Rua = agu.qwn;
    }
}
