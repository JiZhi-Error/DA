package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.emm;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends q implements m {
    private i callback;
    private d rr;

    public l(String str) {
        AppMethodBeat.i(97158);
        d.a aVar = new d.a();
        aVar.iLN = new emm();
        aVar.iLO = new emn();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/update_shared_uxinfo";
        aVar.funcId = 2883;
        this.rr = aVar.aXF();
        ((emm) this.rr.iLK.iLR).NkK = str;
        AppMethodBeat.o(97158);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97159);
        Log.i("NetSceneUpdateUxInfo", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(97159);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97160);
        int type = this.rr.getType();
        AppMethodBeat.o(97160);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(97161);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97161);
        return dispatch;
    }
}
