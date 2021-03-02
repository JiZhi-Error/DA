package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    final com.tencent.mm.ak.d iUB;

    public d(String str) {
        AppMethodBeat.i(30175);
        d.a aVar = new d.a();
        akv akv = new akv();
        akw akw = new akw();
        aVar.iLN = akv;
        aVar.iLO = akw;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        aVar.funcId = 971;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        akv.LtA = str;
        Log.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", str);
        AppMethodBeat.o(30175);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 971;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30176);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30176);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30177);
        Log.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30177);
    }
}
