package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class f extends q implements m {
    private i callback;
    public d rr;
    private long uOV = System.currentTimeMillis();

    public f(JSONObject jSONObject) {
        AppMethodBeat.i(88483);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.iLN = new eik();
        aVar.iLO = new eil();
        this.rr = aVar.aXF();
        eik eik = (eik) this.rr.iLK.iLR;
        eik.Mba = jSONObject.optString("requestId", "");
        eik.MEq = jSONObject.optString("docId", "");
        eik.iAc = jSONObject.optString("content", "");
        eik.NhF = jSONObject.optString("replyId", "");
        eik.NhG = jSONObject.optString("subReplyId", "");
        eik.LOr = jSONObject.optString("docUrl", "");
        eik.Title = jSONObject.optString("title", "");
        eik.Mbb = jSONObject.optString("searchId", "");
        eik.Scene = jSONObject.optInt("scene", 0);
        eik.KJS = jSONObject.optInt("subScene", 0);
        eik.pLq = jSONObject.optString("vid", "");
        eik.MRt = jSONObject.optString("byPass", "");
        eik.xub = 0;
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", eik.Mba, eik.MEq, eik.iAc, eik.NhF, eik.NhG, eik.LOr, eik.Title, eik.Mbb, Integer.valueOf(eik.Scene), Integer.valueOf(eik.KJS));
        AppMethodBeat.o(88483);
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, int i3, String str9, String str10) {
        AppMethodBeat.i(88484);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.iLN = new eik();
        aVar.iLO = new eil();
        this.rr = aVar.aXF();
        eik eik = (eik) this.rr.iLK.iLR;
        eik.Mba = str;
        eik.MEq = str2;
        eik.iAc = str3;
        eik.NhF = str4;
        eik.NhG = str5;
        eik.LOr = str6;
        eik.Title = str7;
        eik.Mbb = str8;
        eik.Scene = i2;
        eik.KJS = i3;
        eik.pLq = str9;
        eik.MRt = str10;
        eik.xub = 1;
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", eik.Mba, eik.MEq, eik.iAc, eik.NhF, eik.NhG, eik.LOr, eik.Title, eik.Mbb, Integer.valueOf(eik.Scene), Integer.valueOf(eik.KJS));
        AppMethodBeat.o(88484);
    }

    public f(f fVar) {
        AppMethodBeat.i(88485);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/topstorypluginpostcomment";
        aVar.iLN = new eik();
        aVar.iLO = new eil();
        this.rr = aVar.aXF();
        eik eik = (eik) this.rr.iLK.iLR;
        eik fyd = fVar.fyd();
        eik.Mba = fyd.Mba;
        eik.MEq = fyd.MEq;
        eik.iAc = fyd.iAc;
        eik.NhF = fyd.NhF;
        eik.NhG = fyd.NhG;
        eik.LOr = fyd.LOr;
        eik.Title = fyd.Title;
        eik.Mbb = fyd.Mbb;
        eik.Scene = fyd.Scene;
        eik.KJS = fyd.KJS;
        eik.pLq = fyd.pLq;
        eik.MRt = fyd.MRt;
        eik.xub = fyd.xub;
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "TopStoryPluginPostCommentRequest %s, %s, %s, %s, %s, %s, %s, %s, %s, %s", eik.Mba, eik.MEq, eik.iAc, eik.NhF, eik.NhG, eik.LOr, eik.Title, eik.Mbb, Integer.valueOf(eik.Scene), Integer.valueOf(eik.KJS));
        AppMethodBeat.o(88485);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2906;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(88486);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(88486);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(88487);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostComment", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(88487);
    }

    public final eil fyc() {
        return (eil) this.rr.iLL.iLR;
    }

    public final eik fyd() {
        return (eik) this.rr.iLK.iLR;
    }
}
