package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.ui.ao;

public final class x extends q implements m {
    private fav IDA;
    private v IDt;
    private fau IDz = ((fau) this.iUB.iLK.iLR);
    private i callback;
    private d iUB;

    public x(v vVar) {
        AppMethodBeat.i(187835);
        this.IDt = vVar;
        d.a aVar = new d.a();
        aVar.funcId = 4858;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmtagsearch";
        aVar.iLN = new fau();
        aVar.iLO = new fav();
        this.iUB = aVar.aXF();
        this.IDz.LPT = this.IDt.dDv;
        this.IDz.MRb = this.IDt.IDE;
        this.IDz.KZg = (long) this.IDt.businessType;
        this.IDz.MlQ = ai.clJ();
        this.IDz.KZk = this.IDt.offset;
        this.IDz.NwV = ai.aft(6);
        this.IDz.MUs = this.IDt.IDF;
        this.IDz.Scene = this.IDt.scene;
        this.IDz.KZj = this.IDt.rjq;
        this.IDz.MRf = this.IDt.dVS;
        this.IDz.NwW = this.IDt.IDG;
        this.IDz.NwY = this.IDt.IDI;
        this.IDz.NwX = this.IDt.IDH;
        this.IDz.NwZ = this.IDt.IDJ;
        this.IDz.Nva = this.IDt.IDO;
        this.IDz.IDN = this.IDt.IDN;
        this.IDz.Nxa = this.IDt.IDP;
        this.IDz.rBI = this.IDt.language;
        this.IDz.NwH = this.IDt.sessionId;
        this.IDz.MEt = ao.isDarkMode() ? 1 : 0;
        this.IDz.MlR = ai.fYd();
        AppMethodBeat.o(187835);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4858;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187836);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(187836);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(187837);
        b.i("MicroMsg.WebSearch.NetSceneTagSearch", "onGYNetEnd errType:%s errCode:%s errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IDA = (fav) this.iUB.iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(187837);
    }

    public final fav fXM() {
        return this.IDA;
    }

    public final v fXN() {
        return this.IDt;
    }
}
