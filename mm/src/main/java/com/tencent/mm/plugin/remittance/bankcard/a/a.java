package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends b {
    public gz CiI;
    public String CiJ;
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private i callback;
    private d rr;

    public a(String str, String str2, String str3) {
        AppMethodBeat.i(67352);
        d.a aVar = new d.a();
        aVar.iLN = new gy();
        aVar.iLO = new gz();
        aVar.funcId = 1348;
        aVar.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        gy gyVar = (gy) this.rr.iLK.iLR;
        gyVar.Cjt = str;
        gyVar.KKG = str2;
        gyVar.dDj = str3;
        this.CiJ = str;
        Log.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", str, str2, str3);
        AppMethodBeat.o(67352);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1348;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67353);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67353);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67354);
        Log.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiI = (gz) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiI.dDN), this.CiI.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67354);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        gz gzVar = (gz) ((d) sVar).iLL.iLR;
        this.RtZ = gzVar.dDN;
        this.Rua = gzVar.qwn;
    }
}
