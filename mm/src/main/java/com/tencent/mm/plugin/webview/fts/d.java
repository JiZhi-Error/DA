package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a implements m {
    dym IOA;
    private i callback;
    public int dVL = -1;
    private com.tencent.mm.ak.d iUB;

    public d(String str, int i2, String str2, String str3, int i3, String str4, int i4, String str5, String str6) {
        AppMethodBeat.i(77923);
        d.a aVar = new d.a();
        aVar.iLN = new dyl();
        aVar.iLO = new dym();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsimilaremoticon";
        aVar.funcId = 2999;
        this.iUB = aVar.aXF();
        dyl dyl = (dyl) this.iUB.iLK.iLR;
        dyl.Md5 = str;
        dyl.KZk = i2;
        dyl.Mbb = str2;
        dyl.SessionId = str3;
        dyl.MYb = i3;
        dyl.Mba = str4;
        dyl.MaY = ai.aft(0);
        dyl.Scene = i4;
        dyl.MlQ = ai.clJ();
        dyl.AesKey = str6;
        dyl.MYc = str5;
        dyl.MlR = ai.fYd();
        Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "Md5 %s Offset %d SearchId %s SessionId %s Tab %s RequestId %s Scene %d", str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(i4));
        AppMethodBeat.o(77923);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(77924);
        Log.i("MicroMsg.WebSearch.NetSceneQuerySimilarEmotion", "netId %d errType %d errCode %d %s errMsg", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IOA = (dym) this.iUB.iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(77924);
    }

    public final dym gay() {
        return this.IOA;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final String fXC() {
        return null;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final int fXD() {
        return 0;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2999;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(77925);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(77925);
        return dispatch;
    }
}
