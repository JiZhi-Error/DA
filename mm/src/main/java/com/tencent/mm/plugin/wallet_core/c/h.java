package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;

public final class h extends q implements m {
    public biw HPF;
    private i callback;
    private d rr;

    public h(String str) {
        AppMethodBeat.i(69902);
        d.a aVar = new d.a();
        aVar.iLN = new biv();
        aVar.iLO = new biw();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.funcId = getType();
        aVar.routeInfo = f.bpA(str);
        this.rr = aVar.aXF();
        Log.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", str);
        ((biv) this.rr.iLK.iLR).dNQ = str;
        AppMethodBeat.o(69902);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1667;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69903);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69903);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69904);
        Log.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.HPF = (biw) this.rr.iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69904);
    }
}
