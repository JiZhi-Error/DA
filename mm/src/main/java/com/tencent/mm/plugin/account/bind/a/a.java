package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private final d rr;

    public a(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(109742);
        d.a aVar = new d.a();
        aVar.iLN = new md();
        aVar.iLO = new me();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        md mdVar = (md) this.rr.iLK.iLR;
        mdVar.KMz = 1;
        mdVar.KPF = i2;
        mdVar.KPG = str;
        mdVar.KPH = str2;
        mdVar.KPI = str3;
        mdVar.KPJ = str4;
        mdVar.KPK = str5;
        mdVar.KPL = str6;
        mdVar.KPM = str7;
        AppMethodBeat.o(109742);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(109743);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(109743);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiChooseMultiMedia.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(109744);
        Log.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        md mdVar = (md) this.rr.iLK.iLR;
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.kernel.g.aAh().azQ().set(286722, mdVar.KPH);
            com.tencent.mm.kernel.g.aAh().azQ().set(286721, mdVar.KPG);
            com.tencent.mm.kernel.g.aAh().azQ().set(286723, mdVar.KPI);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(109744);
    }
}
