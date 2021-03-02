package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class c extends w {
    public daq ItB = null;
    private i callback;
    private d rr;

    public c(String str) {
        AppMethodBeat.i(72062);
        d.a aVar = new d.a();
        aVar.iLN = new dba();
        aVar.iLO = new dbb();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.funcId = 1520;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dba dba = (dba) this.rr.iLK.iLR;
        if (!Util.isNullOrNil(str)) {
            dba.AOT = str;
        }
        AppMethodBeat.o(72062);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1520;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72063);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72063);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72064);
        Log.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i3 + " errCode " + i4 + " errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (i3 == 0 && i4 == 0) {
            dbb dbb = (dbb) ((d) sVar).iLL.iLR;
            this.ItB = dbb.MGb;
            if (dbb.MGb != null) {
                Log.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + dbb.MGb.AOT);
                AppMethodBeat.o(72064);
                return;
            }
            Log.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
        }
        AppMethodBeat.o(72064);
    }
}
