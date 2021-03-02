package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends a {
    public ejw ClR;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage";

    public c(String str) {
        AppMethodBeat.i(67628);
        d.a aVar = new d.a();
        aVar.iLN = new ejv();
        aVar.iLO = new ejw();
        aVar.funcId = 1275;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonedelhisrcvr";
        this.rr = aVar.aXF();
        ((ejv) this.rr.iLK.iLR).Njh = str;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitDeleteRecord rcvr_id:%s ", str);
        AppMethodBeat.o(67628);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67629);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ClR = (ejw) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.ClR.pTZ), this.ClR.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67629);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        ejw ejw = (ejw) ((d) sVar).iLL.iLR;
        this.RtZ = ejw.pTZ;
        this.Rua = ejw.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1275;
    }
}
