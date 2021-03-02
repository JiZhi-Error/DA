package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends b {
    public biy CiO;
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    private i callback;
    public String md5;
    private d rr;

    public g(String str, String str2) {
        AppMethodBeat.i(67367);
        d.a aVar = new d.a();
        aVar.iLN = new bix();
        aVar.iLO = new biy();
        aVar.funcId = 1542;
        aVar.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bix) this.rr.iLK.iLR).LiQ = str;
        this.md5 = str2;
        AppMethodBeat.o(67367);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1542;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(67368);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67368);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67369);
        Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiO = (biy) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiO.dDN), this.CiO.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67369);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        biy biy = (biy) ((d) sVar).iLL.iLR;
        this.RtZ = biy.dDN;
        this.Rua = biy.qwn;
    }
}
