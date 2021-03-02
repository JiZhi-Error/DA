package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class b extends r {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyUser";
    public String username;
    public yp yjy;

    public b(String str, int i2) {
        AppMethodBeat.i(64614);
        d.a aVar = new d.a();
        aVar.iLN = new yo();
        aVar.iLO = new yp();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        yo yoVar = (yo) this.rr.iLK.iLR;
        yoVar.LjD = str;
        yoVar.nHh = i2;
        this.username = str;
        AppMethodBeat.o(64614);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2926;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64615);
        Log.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjy = (yp) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjy.pTZ), this.yjy.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64615);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        yp ypVar = (yp) ((d) sVar).iLL.iLR;
        this.RtZ = ypVar.pTZ;
        this.Rua = ypVar.pUa;
    }
}
