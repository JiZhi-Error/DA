package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class e extends r {
    public wx Cos;
    private final String TAG = "MicroMsg.NetSceneBeforeTransfer";

    public e(String str) {
        AppMethodBeat.i(67838);
        d.a aVar = new d.a();
        aVar.iLN = new ww();
        aVar.iLO = new wx();
        aVar.funcId = 2783;
        aVar.uri = "/cgi-bin/mmpay-bin/beforetransfer";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ww wwVar = (ww) this.rr.iLK.iLR;
        wwVar.jTz = str;
        if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
            wwVar.LhT = com.tencent.mm.pluginsdk.wallet.e.gsR();
        }
        Log.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", str);
        AppMethodBeat.o(67838);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67839);
        Log.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.Cos = (wx) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.Cos.dDN), this.Cos.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67839);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        wx wxVar = (wx) ((d) sVar).iLL.iLR;
        this.RtZ = wxVar.dDN;
        this.Rua = wxVar.qwn;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2783;
    }
}
