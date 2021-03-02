package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class m extends r {
    private final String TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    public dhh yjK;

    public m(String str) {
        AppMethodBeat.i(64636);
        d.a aVar = new d.a();
        aVar.iLN = new dhg();
        aVar.iLO = new dhh();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dhg) this.rr.iLK.iLR).LWD = str;
        Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", str);
        AppMethodBeat.o(64636);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2613;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64637);
        Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjK = (dhh) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjK.pTZ), this.yjK.pUa);
        if (this.yjK.LWE != null) {
            c.s(this.yjK.LWE.dXf, this.yjK.LWE.LaR, this.yjK.LWE.dWw, null);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64637);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dhh dhh = (dhh) ((d) sVar).iLL.iLR;
        this.RtZ = dhh.pTZ;
        this.Rua = dhh.pUa;
    }
}
