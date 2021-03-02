package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private d hJu;
    private alh yRE = ((alh) this.hJu.iLK.iLR);
    private ali yRF;

    public a(String str) {
        AppMethodBeat.i(65035);
        d.a aVar = new d.a();
        aVar.iLN = new alh();
        aVar.iLO = new ali();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.hJu = aVar.aXF();
        this.yRE.yQE = str;
        AppMethodBeat.o(65035);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65036);
        this.yRF = (ali) ((d) sVar).iLL.iLR;
        Log.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(this.yRF.dDN), this.yRF.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, this.yRF.dDN, this.yRF.qwn, this);
        }
        AppMethodBeat.o(65036);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1987;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65037);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65037);
        return dispatch;
    }
}
