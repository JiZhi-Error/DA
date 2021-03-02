package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends b {
    public dif CiU;
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    private i callback;
    private d rr;

    public m() {
        AppMethodBeat.i(67385);
        d.a aVar = new d.a();
        aVar.iLN = new die();
        aVar.iLO = new dif();
        aVar.funcId = 1378;
        aVar.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(67385);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1378;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67386);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67386);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67387);
        Log.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiU = (dif) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiU.dDN), this.CiU.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67387);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dif dif = (dif) ((d) sVar).iLL.iLR;
        this.RtZ = dif.dDN;
        this.Rua = dif.qwn;
    }
}
