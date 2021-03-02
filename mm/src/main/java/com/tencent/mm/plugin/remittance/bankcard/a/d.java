package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends b {
    public xs CiL;
    private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    private i callback;
    private com.tencent.mm.ak.d rr;

    public d(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67358);
        d.a aVar = new d.a();
        aVar.iLN = new xr();
        aVar.iLO = new xs();
        aVar.funcId = 1349;
        aVar.uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        xr xrVar = (xr) this.rr.iLK.iLR;
        xrVar.LiP = str;
        xrVar.LiQ = str2;
        xrVar.ynT = str3;
        xrVar.dDj = str4;
        AppMethodBeat.o(67358);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1349;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67359);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67359);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67360);
        Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiL = (xs) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiL.dDN), this.CiL.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67360);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        xs xsVar = (xs) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.RtZ = xsVar.dDN;
        this.Rua = xsVar.qwn;
    }
}
