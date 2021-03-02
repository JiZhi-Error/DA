package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    public String dGL;
    public String dGP;
    private d iUB;

    public a(String str, String str2) {
        AppMethodBeat.i(30054);
        this.dGL = str;
        this.dGP = str2;
        d.a aVar = new d.a();
        aVar.funcId = 1091;
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.iLN = new cay();
        aVar.iLO = new caz();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        cay cay = (cay) this.iUB.iLK.iLR;
        cay.KOi = new b(str.getBytes());
        cay.KOk = new b(str2.getBytes());
        cay.Mgr = new b("5".getBytes());
        AppMethodBeat.o(30054);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1091;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30055);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30055);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30056);
        Log.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30056);
    }
}
