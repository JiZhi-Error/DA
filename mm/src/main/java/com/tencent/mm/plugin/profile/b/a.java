package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    public brt BcU;
    private i callback;
    public String errMsg;
    public final d rr;

    public a(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(26901);
        Log.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", str, str2, str3, Util.secPrint(str4));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenurl";
        aVar.funcId = 913;
        aVar.iLN = new brs();
        aVar.iLO = new brt();
        this.rr = aVar.aXF();
        brs brs = (brs) this.rr.iLK.iLR;
        brs.scene = 1;
        aq aqVar = new aq();
        aqVar.username = str;
        aqVar.dHx = str2;
        aqVar.BcW = str3;
        aqVar.content = str4;
        brs.LYX = aqVar;
        AppMethodBeat.o(26901);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 913;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26902);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26902);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26903);
        Log.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(26903);
    }
}
