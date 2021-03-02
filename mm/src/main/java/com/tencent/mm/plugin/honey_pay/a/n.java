package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ele;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class n extends r {
    private final String TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    public elf yjL;

    public n(String str, String str2) {
        AppMethodBeat.i(64638);
        d.a aVar = new d.a();
        aVar.iLN = new ele();
        aVar.iLO = new elf();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/unbindhpcard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ele ele = (ele) this.rr.iLK.iLR;
        ele.LWD = str;
        ele.LpC = str2;
        AppMethodBeat.o(64638);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2659;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64639);
        Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjL = (elf) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjL.pTZ), this.yjL.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64639);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        elf elf = (elf) ((d) sVar).iLL.iLR;
        this.RtZ = elf.pTZ;
        this.Rua = elf.pUa;
    }
}
