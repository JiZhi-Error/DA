package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ab extends q implements m {
    faq IEg = new faq();
    far IEh;
    private i callback;
    private d iUB;

    public ab(int i2) {
        AppMethodBeat.i(117635);
        d.a aVar = new d.a();
        aVar.funcId = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.iLN = new faq();
        aVar.iLO = new far();
        this.iUB = aVar.aXF();
        this.IEg = (faq) this.iUB.iLK.iLR;
        this.IEg.MaY = ai.aft(0);
        this.IEg.rBI = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        this.IEg.pLm = ai.ait();
        this.IEg.MlQ = ai.clJ();
        this.IEg.MlR = ai.fYd();
        this.IEg.Scene = i2;
        this.IEg.KZg = 0;
        AppMethodBeat.o(117635);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1948;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117636);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(117636);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117637);
        Log.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.IEh = (far) this.iUB.iLL.iLR;
            if (this.IEh != null) {
                Log.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", this.IEh.MaZ);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(117637);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117637);
    }
}
