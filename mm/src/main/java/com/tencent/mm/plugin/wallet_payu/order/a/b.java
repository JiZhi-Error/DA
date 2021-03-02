package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class b extends w {
    private i callback;
    private d rr;

    public b(String str) {
        AppMethodBeat.i(72059);
        d.a aVar = new d.a();
        aVar.iLN = new daw();
        aVar.iLO = new dax();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        aVar.funcId = 1544;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        daw daw = (daw) this.rr.iLK.iLR;
        if (!Util.isNullOrNil(str)) {
            daw.AOT = str;
        }
        AppMethodBeat.o(72059);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72060);
        Log.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72060);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1544;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72061);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72061);
        return dispatch;
    }
}
