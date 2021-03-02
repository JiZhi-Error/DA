package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    public String EiS = "";
    private com.tencent.mm.ak.i callback;
    private d rr;

    public i(String str) {
        AppMethodBeat.i(97150);
        this.EiS = str;
        d.a aVar = new d.a();
        aVar.iLN = new amx();
        aVar.iLO = new amy();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        aVar.funcId = 2874;
        this.rr = aVar.aXF();
        ((amx) this.rr.iLK.iLR).LxV = str;
        Log.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", str);
        AppMethodBeat.o(97150);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2874;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(97151);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97151);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97152);
        Log.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(97152);
    }
}
