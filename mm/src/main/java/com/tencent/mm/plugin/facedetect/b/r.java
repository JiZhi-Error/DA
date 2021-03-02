package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends q implements m {
    private i callback;
    public String mFileName = "";
    private d rr;

    public r(String str, long j2, String str2, String str3, String str4) {
        AppMethodBeat.i(103623);
        d.a aVar = new d.a();
        aVar.iLN = new amc();
        aVar.iLO = new amd();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.mFileName = str;
        amc amc = (amc) this.rr.iLK.iLR;
        amc.dNI = str2;
        amc.LuJ = j2;
        amc.LuK = str4;
        amc.LuR = str3;
        AppMethodBeat.o(103623);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1197;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103624);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103624);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103625);
        Log.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103625);
    }
}
