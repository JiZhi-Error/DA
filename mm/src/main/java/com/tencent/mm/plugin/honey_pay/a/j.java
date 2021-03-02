package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class j extends r {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    public cqw yjH;

    public j(dbf dbf, String str) {
        AppMethodBeat.i(64630);
        d.a aVar = new d.a();
        aVar.iLN = new cqv();
        aVar.iLO = new cqw();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cqv cqv = (cqv) this.rr.iLK.iLR;
        cqv.MhM = dbf;
        cqv.LWD = str;
        Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", str, dbf.MGk, dbf.dDj);
        AppMethodBeat.o(64630);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2941;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64631);
        Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjH = (cqw) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjH.pTZ), this.yjH.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64631);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        cqw cqw = (cqw) ((d) sVar).iLL.iLR;
        this.RtZ = cqw.pTZ;
        this.Rua = cqw.pUa;
    }
}
