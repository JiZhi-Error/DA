package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j extends q implements m {
    public eiw GjH;
    private i callback;
    public d rr;
    private long uOV = System.currentTimeMillis();

    public j(JSONObject jSONObject) {
        AppMethodBeat.i(88488);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        aVar.iLN = new eim();
        aVar.iLO = new ein();
        this.rr = aVar.aXF();
        eim eim = (eim) this.rr.iLK.iLR;
        eim.MEq = jSONObject.optString("docId", "");
        eim.NhH = jSONObject.optString("commentId", "");
        eim.him = jSONObject.optInt("opType", 0);
        eim.Mba = jSONObject.optString("requestId", "");
        eim.iAc = jSONObject.optString("content", "");
        eim.Scene = jSONObject.optInt("scene", 0);
        eim.Mbb = jSONObject.optString("searchId", "");
        eim.KJS = jSONObject.optInt("subScene", 0);
        eim.pLq = jSONObject.optString("vid", "");
        eim.MRt = jSONObject.optString("byPass", "");
        eim.xub = 0;
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", eim.MEq, eim.NhH, Integer.valueOf(eim.him), eim.Mba, eim.iAc, Integer.valueOf(eim.Scene), eim.Mbb, Integer.valueOf(eim.KJS), eim.pLq, eim.MRt);
        AppMethodBeat.o(88488);
    }

    public j(eiw eiw, String str, int i2, String str2, int i3, String str3, int i4, String str4, String str5) {
        AppMethodBeat.i(88489);
        this.GjH = eiw;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginsetcomment";
        aVar.iLN = new eim();
        aVar.iLO = new ein();
        this.rr = aVar.aXF();
        eim eim = (eim) this.rr.iLK.iLR;
        eim.MEq = str;
        eim.NhH = "";
        eim.him = i2;
        eim.Mba = str2;
        eim.iAc = "";
        eim.Scene = i3;
        eim.Mbb = str3;
        eim.KJS = i4;
        eim.pLq = str4;
        eim.MRt = str5;
        eim.xub = 1;
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "TopStoryPluginSetCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", eim.MEq, eim.NhH, Integer.valueOf(eim.him), eim.Mba, eim.iAc, Integer.valueOf(eim.Scene), eim.Mbb, Integer.valueOf(eim.KJS), eim.pLq, eim.MRt);
        AppMethodBeat.o(88489);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2802;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(88490);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(88490);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(88491);
        Log.i("MicroMsg.TopStory.NetSceneTopStorySetComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(88491);
    }

    public final ein fye() {
        return (ein) this.rr.iLL.iLR;
    }
}
