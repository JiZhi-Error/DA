package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    public d rr;
    private long uOV = System.currentTimeMillis();

    public g(long j2, String str, String str2, String str3, com.tencent.mm.pluginsdk.model.app.g gVar, String str4) {
        AppMethodBeat.i(91014);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "Create NetSceneTopStoryPostVideo ts:%s, extInfo:%s, comment:%s, requestId:%s, appVersion:%s", Long.valueOf(j2), str, str2, str3, str4);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/colikepost";
        aVar.iLN = new abv();
        aVar.iLO = new abw();
        this.rr = aVar.aXF();
        abv abv = (abv) this.rr.iLK.iLR;
        abv.timestamp = j2;
        abv.Lmx = str;
        abv.KJM = str2;
        abv.dPI = str3;
        abv.Lmy = new abr();
        abv.Lmy.appName = gVar.field_appName;
        abv.Lmy.appId = gVar.field_appId;
        abv.Lmy.version = str4;
        AppMethodBeat.o(91014);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2534;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(91015);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91015);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91016);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryPostHaokan", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91016);
    }
}
