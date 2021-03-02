package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eeu;
import com.tencent.mm.protocal.protobuf.eev;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    public String AZw;
    private i callback;
    private d rr;

    public k(dyy dyy) {
        AppMethodBeat.i(66903);
        d.a aVar = new d.a();
        aVar.iLN = new eeu();
        aVar.iLO = new eev();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.funcId = JsApiGetLabInfo.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((eeu) this.rr.iLK.iLR).NeQ = dyy;
        AppMethodBeat.o(66903);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66904);
        eev eev = (eev) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + eev.NeR);
            this.AZw = eev.NeR;
        }
        Log.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66904);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiGetLabInfo.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66905);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66905);
        return dispatch;
    }
}
