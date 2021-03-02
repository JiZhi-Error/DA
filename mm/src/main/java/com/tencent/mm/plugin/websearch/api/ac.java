package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac extends q implements m {
    public clw IEi;
    private int IEj;
    public int businessType;
    private i callback;
    public String dPI;
    public int dVL;
    private d iUB;
    public int scene;
    public String sessionId;

    public ac(int i2, int i3, int i4, int i5, String str, long j2, String str2, String str3, String str4) {
        AppMethodBeat.i(187841);
        this.scene = i2;
        this.IEj = i4;
        this.dVL = i5;
        this.businessType = i3;
        this.dPI = str2;
        this.sessionId = str3;
        Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
        d.a aVar = new d.a();
        aVar.funcId = 1048;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.iLN = new clv();
        aVar.iLO = new clw();
        this.iUB = aVar.aXF();
        clv clv = (clv) this.iUB.iLK.iLR;
        clv.Scene = i2;
        clv.MaY = i4;
        clv.MlQ = ai.clJ();
        clv.xMB = i3;
        clv.rBI = str;
        clv.Mri = j2;
        clv.SessionId = str3;
        clv.Mrj = str4;
        clv.MlR = ai.fYd();
        ah.c(i2, str3, "", "", str2, i3);
        AppMethodBeat.o(187841);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1048;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117639);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(117639);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117640);
        Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.IEi = (clw) this.iUB.iLL.iLR;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(117640);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117640);
    }
}
