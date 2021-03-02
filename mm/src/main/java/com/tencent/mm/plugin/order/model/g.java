package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.ae;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class g extends w {
    private i callback;
    private d rr;

    public g(String str, String str2) {
        AppMethodBeat.i(66686);
        d.a aVar = new d.a();
        aVar.iLN = new czr();
        aVar.iLO = new czs();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.funcId = ae.CTRL_INDEX;
        aVar.iLP = 187;
        aVar.respCmdId = 1000000187;
        this.rr = aVar.aXF();
        czr czr = (czr) this.rr.iLK.iLR;
        czr.MEV = 1;
        if (!Util.isNullOrNil(str)) {
            czr.AOT = str;
        }
        if (!Util.isNullOrNil(str2)) {
            czr.APl = str2;
        }
        czr.Lcc = k.fQy();
        AppMethodBeat.o(66686);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(66687);
        Log.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66687);
    }

    public final int eBi() {
        return ((czr) this.rr.iLK.iLR).MEV;
    }

    public final String eBj() {
        return ((czr) this.rr.iLK.iLR).AOT;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ae.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(66688);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66688);
        return dispatch;
    }
}
