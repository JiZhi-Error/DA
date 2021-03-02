package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;

public final class n extends w {
    private i callback;
    private d rr;

    public n(String str, String str2) {
        AppMethodBeat.i(72778);
        d.a aVar = new d.a();
        aVar.iLN = new tn();
        aVar.iLO = new to();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.funcId = 410;
        aVar.iLP = z.CTRL_INDEX;
        aVar.respCmdId = 1000000198;
        aVar.routeInfo = f.bpA(str2);
        this.rr = aVar.aXF();
        tn tnVar = (tn) this.rr.iLK.iLR;
        tnVar.Lcb = str;
        tnVar.KKR = str2;
        tnVar.Lcc = k.fQy();
        AppMethodBeat.o(72778);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72779);
        Log.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72779);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 410;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72780);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72780);
        return dispatch;
    }
}
