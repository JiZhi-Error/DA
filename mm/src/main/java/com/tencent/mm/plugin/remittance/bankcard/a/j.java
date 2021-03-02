package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends b {
    public String CiJ;
    public cqq CiR;
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private i callback;
    public String remark;
    private d rr;

    public j(String str, String str2) {
        AppMethodBeat.i(67376);
        d.a aVar = new d.a();
        aVar.iLN = new cqp();
        aVar.iLO = new cqq();
        aVar.funcId = 1590;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cqp cqp = (cqp) this.rr.iLK.iLR;
        cqp.Cjt = str;
        cqp.Cjw = str2;
        this.CiJ = str;
        this.remark = str2;
        AppMethodBeat.o(67376);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1590;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67377);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67377);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67378);
        Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiR = (cqq) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiR.dDN), this.CiR.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67378);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cqq cqq = (cqq) ((d) sVar).iLL.iLR;
        this.RtZ = cqq.dDN;
        this.Rua = cqq.qwn;
    }
}
