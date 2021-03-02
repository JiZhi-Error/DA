package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    public String country;
    public String fuJ;
    public String fuK;
    private d rr;

    public g(double d2, double d3) {
        AppMethodBeat.i(182046);
        d.a aVar = new d.a();
        aVar.iLN = new bmd();
        aVar.iLO = new bme();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        aVar.funcId = 665;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bmd bmd = (bmd) this.rr.iLK.iLR;
        bmd.KUu = d2;
        bmd.KUt = d3;
        Log.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d2 + ", longitude:" + d3);
        AppMethodBeat.o(182046);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(182047);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182047);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 665;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(182048);
        Log.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            bme bme = (bme) this.rr.iLL.iLR;
            this.fuK = bme.kea;
            this.country = bme.keh;
            this.fuJ = bme.kdZ;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(182048);
    }

    public final bme ecK() {
        return (bme) this.rr.iLL.iLR;
    }
}
