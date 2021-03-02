package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private Object data = null;
    public d rr;

    public m(String str, String str2, int i2) {
        AppMethodBeat.i(124292);
        d.a aVar = new d.a();
        aVar.iLN = new ny();
        aVar.iLO = new nz();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        aVar.funcId = 1364;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ny nyVar = (ny) this.rr.iLK.iLR;
        nyVar.KTt = str;
        nyVar.dDv = str2;
        nyVar.offset = i2;
        AppMethodBeat.o(124292);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124293);
        Log.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124293);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1364;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124294);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124294);
        return dispatch;
    }
}
