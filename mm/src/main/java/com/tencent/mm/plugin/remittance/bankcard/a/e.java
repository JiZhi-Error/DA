package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends b {
    public agq CiM;
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private i callback;
    public String qvC;
    private d rr;

    public e(String str) {
        AppMethodBeat.i(67361);
        d.a aVar = new d.a();
        aVar.iLN = new agp();
        aVar.iLO = new agq();
        aVar.funcId = 1737;
        aVar.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((agp) this.rr.iLK.iLR).KZa = str;
        this.qvC = str;
        AppMethodBeat.o(67361);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1737;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67362);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67362);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67363);
        Log.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiM = (agq) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiM.dDN), this.CiM.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67363);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        agq agq = (agq) ((d) sVar).iLL.iLR;
        this.RtZ = agq.dDN;
        this.Rua = agq.qwn;
    }
}
