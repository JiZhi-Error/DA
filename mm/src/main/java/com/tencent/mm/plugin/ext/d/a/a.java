package com.tencent.mm.plugin.ext.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    public i callback;
    public String mUrl = null;
    private d rr;
    public int sOj = -1;

    public a(String str, int i2, int i3) {
        AppMethodBeat.i(24508);
        this.mUrl = str;
        d.a aVar = new d.a();
        aVar.iLN = new ya();
        aVar.iLO = new yb();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        aVar.funcId = 782;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", str);
        ya yaVar = (ya) this.rr.iLK.iLR;
        yaVar.URL = this.mUrl;
        yaVar.Ljb = i2;
        yaVar.Ljc = i3;
        AppMethodBeat.o(24508);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 782;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(24509);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(24509);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(24510);
        Log.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        yb ybVar = (yb) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            this.sOj = ybVar.oUv;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(24510);
    }
}
