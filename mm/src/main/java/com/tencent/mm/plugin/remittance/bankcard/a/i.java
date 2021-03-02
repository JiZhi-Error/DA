package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends b {
    public dhw CiQ;
    private com.tencent.mm.ak.i callback;
    public int limit;
    private d rr;

    public i(int i2, int i3) {
        AppMethodBeat.i(67373);
        d.a aVar = new d.a();
        aVar.iLN = new dhv();
        aVar.iLO = new dhw();
        aVar.funcId = 1511;
        aVar.uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dhv dhv = (dhv) this.rr.iLK.iLR;
        dhv.limit = i2;
        dhv.offset = i3;
        this.limit = i2;
        Log.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(67373);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1511;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(67374);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67374);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67375);
        Log.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiQ = (dhw) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiQ.dDN), this.CiQ.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67375);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhw dhw = (dhw) ((d) sVar).iLL.iLR;
        this.RtZ = dhw.dDN;
        this.Rua = dhw.qwn;
    }
}
