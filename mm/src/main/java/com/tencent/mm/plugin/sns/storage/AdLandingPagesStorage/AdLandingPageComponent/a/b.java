package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ChannelUtil;

public final class b extends q implements m {
    private i callback;
    private d rr;

    public b(String str, String str2, boolean z) {
        AppMethodBeat.i(97129);
        d.a aVar = new d.a();
        aVar.iLN = new xb();
        aVar.iLO = new xc();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        aVar.funcId = 1210;
        this.rr = aVar.aXF();
        xb xbVar = (xb) this.rr.iLK.iLR;
        xbVar.Lih = str2;
        xbVar.KFI = str;
        xbVar.Lii = ChannelUtil.isGPVersion();
        xbVar.Lij = z ? 1 : 0;
        AppMethodBeat.o(97129);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97130);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(97130);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97131);
        int type = this.rr.getType();
        AppMethodBeat.o(97131);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(97132);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97132);
        return dispatch;
    }
}
