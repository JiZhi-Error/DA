package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2helper;

public final class u extends w {
    public String IqF;
    public String IqG;
    private i callback;
    public String rcD;
    public final d rr;

    public u(String str, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(72797);
        d.a aVar = new d.a();
        aVar.iLN = new del();
        aVar.iLO = new dem();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.funcId = v2helper.EMethodOutputVolumeGainEnable;
        aVar.iLP = 214;
        aVar.respCmdId = 1000000214;
        this.rr = aVar.aXF();
        del del = (del) this.rr.iLK.iLR;
        this.rcD = str;
        del.ProductID = str;
        this.IqG = str2;
        del.MJz = str2;
        this.IqF = str3;
        del.MJA = str3;
        del.APa = i3;
        del.MJB = i2;
        del.xNU = str4;
        Log.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i3);
        AppMethodBeat.o(72797);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72798);
        Log.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i3 + ",errCode:" + i4 + ",errMsg:" + str);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(72798);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72798);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodOutputVolumeGainEnable;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72799);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72799);
        return dispatch;
    }
}
