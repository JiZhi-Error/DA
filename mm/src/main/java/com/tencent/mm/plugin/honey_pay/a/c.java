package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class c extends r {
    private final String TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    public aeg yjz;

    public c(String str, long j2, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(64616);
        d.a aVar = new d.a();
        aVar.iLN = new aef();
        aVar.iLO = new aeg();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        aef aef = (aef) this.rr.iLK.iLR;
        aef.LpC = str;
        aef.LpD = j2;
        aef.LjD = str2;
        aef.LjH = str3;
        aef.nHh = i2;
        aef.yPK = str4;
        Log.d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", str, str3, str4);
        Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", str2, Long.valueOf(j2));
        AppMethodBeat.o(64616);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2662;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64617);
        Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjz = (aeg) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjz.pTZ), this.yjz.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64617);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        aeg aeg = (aeg) ((d) sVar).iLL.iLR;
        this.RtZ = aeg.pTZ;
        this.Rua = aeg.pUa;
    }
}
