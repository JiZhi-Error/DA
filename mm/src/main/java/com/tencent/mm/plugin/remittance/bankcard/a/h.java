package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends b {
    public bja CiP;
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private i callback;
    private d rr;

    public h() {
        AppMethodBeat.i(67370);
        d.a aVar = new d.a();
        aVar.iLN = new biz();
        aVar.iLO = new bja();
        aVar.funcId = 1399;
        aVar.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(67370);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1399;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67371);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67371);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67372);
        Log.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiP = (bja) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiP.dDN), this.CiP.qwn);
        if (!this.qxx && this.CiP.dDN != 0) {
            this.qxy = true;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67372);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        bja bja = (bja) ((d) sVar).iLL.iLR;
        this.RtZ = bja.dDN;
        this.Rua = bja.qwn;
    }
}
