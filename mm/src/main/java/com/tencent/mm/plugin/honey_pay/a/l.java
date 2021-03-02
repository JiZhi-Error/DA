package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class l extends r {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    public dhf yjJ;

    public l(String str) {
        AppMethodBeat.i(64634);
        d.a aVar = new d.a();
        aVar.iLN = new dhe();
        aVar.iLO = new dhf();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dhe) this.rr.iLK.iLR).LWD = str;
        Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", str);
        AppMethodBeat.o(64634);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2876;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64635);
        Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjJ = (dhf) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjJ.pTZ), this.yjJ.pUa);
        if (this.yjJ.LWE != null) {
            c.s(this.yjJ.LWE.dXf, this.yjJ.LWE.LaR, this.yjJ.LWE.dWw, null);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64635);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhf dhf = (dhf) ((d) sVar).iLL.iLR;
        this.RtZ = dhf.pTZ;
        this.Rua = dhf.pUa;
    }
}
