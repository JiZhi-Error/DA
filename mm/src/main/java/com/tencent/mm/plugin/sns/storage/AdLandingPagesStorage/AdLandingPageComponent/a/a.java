package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private d rr;

    public a(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(203128);
        d.a aVar = new d.a();
        aVar.iLN = new bp();
        aVar.iLO = new bq();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/ad_anti_abuse";
        aVar.funcId = 4679;
        this.rr = aVar.aXF();
        bp bpVar = (bp) this.rr.iLK.iLR;
        bpVar.lAN = str;
        bpVar.uxInfo = str2;
        bpVar.enterScene = i2;
        bpVar.adExtInfo = str3;
        AppMethodBeat.o(203128);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(203129);
        int type = this.rr.getType();
        AppMethodBeat.o(203129);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(203130);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(203130);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(203131);
        Log.i("NetSceneAdAntiAbuse", "errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(203131);
    }
}
