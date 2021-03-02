package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    private com.tencent.mm.ak.d rr;

    public d(String str) {
        AppMethodBeat.i(97133);
        d.a aVar = new d.a();
        aVar.iLN = new dib();
        aVar.iLO = new dic();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/query_ad_redpkt_state";
        aVar.funcId = 2944;
        this.rr = aVar.aXF();
        ((dib) this.rr.iLK.iLR).MMJ = str;
        AppMethodBeat.o(97133);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97134);
        Log.i("NetSceneAdGetHbCoverState", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(97134);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97135);
        int type = this.rr.getType();
        AppMethodBeat.o(97135);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(97136);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97136);
        return dispatch;
    }
}
