package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    private final d rr;
    public int zjs;
    private bhv zjt = ((bhv) this.rr.iLK.iLR);
    private bhw zju;

    public g(int i2) {
        AppMethodBeat.i(213540);
        d.a aVar = new d.a();
        aVar.iLN = new bhv();
        aVar.iLO = new bhw();
        aVar.funcId = 4362;
        aVar.uri = "/cgi-bin/micromsg-bin/getallfunction";
        this.rr = aVar.aXF();
        this.zjs = i2;
        Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", Integer.valueOf(this.zjs));
        this.zjt.KOr = this.zjs;
        AppMethodBeat.o(213540);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4362;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(213541);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(213541);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(213542);
        Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.zju = (bhw) ((d) sVar).iLL.iLR;
            if (this.zju != null) {
                b.a(this.zju);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(213542);
    }
}
