package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tavkit.component.TAVExporter;

public final class k extends b {
    public cxk CiS;
    private i callback;
    private d rr;

    public k() {
        AppMethodBeat.i(67379);
        d.a aVar = new d.a();
        aVar.iLN = new cxj();
        aVar.iLO = new cxk();
        aVar.funcId = TAVExporter.VIDEO_EXPORT_HEIGHT;
        aVar.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(67379);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TAVExporter.VIDEO_EXPORT_HEIGHT;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67380);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67380);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67381);
        Log.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiS = (cxk) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiS.dDN), this.CiS.qwn);
        if (!this.qxx && !this.qxy) {
            Log.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", Integer.valueOf(this.CiS.MBS), Integer.valueOf(this.CiS.MBT));
            if (this.CiS.MBS >= 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(this.CiS.MBS));
            }
            if (this.CiS.MBT > 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(this.CiS.MBT));
            }
            if (!Util.isNullOrNil(this.CiS.MBU)) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, this.CiS.MBU);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67381);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cxk cxk = (cxk) ((d) sVar).iLL.iLR;
        this.RtZ = cxk.dDN;
        this.Rua = cxk.qwn;
    }
}
