package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class i extends w {
    private com.tencent.mm.ak.i callback;
    private d rr;

    public i(String str, String str2) {
        AppMethodBeat.i(72312);
        d.a aVar = new d.a();
        aVar.iLN = new dmw();
        aVar.iLO = new dmx();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        aVar.funcId = 600;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dmw dmw = (dmw) this.rr.iLK.iLR;
        dmw.MQl = str;
        dmw.MQk = Util.getInt(str2, 0);
        dmw.Lcc = k.fQy();
        AppMethodBeat.o(72312);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72313);
        Log.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72313);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 600;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(72314);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72314);
        return dispatch;
    }
}
