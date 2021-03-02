package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends b {
    private dnz CiV;
    private final String TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    private i callback;
    private d rr;

    public n(String str, String str2, int i2) {
        AppMethodBeat.i(67388);
        Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", str, str2, Integer.valueOf(i2));
        d.a aVar = new d.a();
        dny dny = new dny();
        dny.MQS = new b(String.valueOf(str).getBytes());
        dny.MBV = str2;
        dny.KYp = i2;
        aVar.iLN = dny;
        aVar.iLO = new dnz();
        aVar.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
        aVar.funcId = 2739;
        this.rr = aVar.aXF();
        AppMethodBeat.o(67388);
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67389);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67389);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67390);
        Log.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiV = (dnz) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67390);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dnz dnz = (dnz) ((d) sVar).iLL.iLR;
        this.RtZ = dnz.dDN;
        this.Rua = dnz.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2739;
    }
}
