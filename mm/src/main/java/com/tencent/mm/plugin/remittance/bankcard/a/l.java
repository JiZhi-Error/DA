package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends b {
    public dhs CiT;
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private i callback;
    private d rr;

    public l(String str) {
        AppMethodBeat.i(67382);
        d.a aVar = new d.a();
        aVar.iLN = new dhr();
        aVar.iLO = new dhs();
        aVar.funcId = 1579;
        aVar.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dhr) this.rr.iLK.iLR).KZa = str;
        Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", str);
        AppMethodBeat.o(67382);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1579;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67383);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67383);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67384);
        Log.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiT = (dhs) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67384);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhs dhs = (dhs) ((d) sVar).iLL.iLR;
        this.RtZ = dhs.dDN;
        this.Rua = dhs.qwn;
    }
}
