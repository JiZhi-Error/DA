package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.buv;

public final class q extends com.tencent.mm.ak.q implements m {
    private buu IDv;
    private buv IDw;
    private int IDx = -1;
    private Bitmap IDy = null;
    private i callback;
    private d iUB;

    public q(buu buu, int i2) {
        AppMethodBeat.i(187826);
        this.IDv = buu;
        this.IDx = i2;
        d.a aVar = new d.a();
        aVar.funcId = 4614;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchshare";
        aVar.iLN = buu;
        aVar.iLO = new buv();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(187826);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4614;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187827);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(187827);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(187828);
        b.i("MicroMsg.WebSearch.NetSceneGetSearchShare", "onGYNetEnd errType:%s errCode:%s errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IDw = (buv) this.iUB.iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(187828);
    }

    public final buv fXK() {
        return this.IDw;
    }

    public final buu fXL() {
        return this.IDv;
    }

    public final int fXz() {
        return this.IDx;
    }

    public final void aG(Bitmap bitmap) {
        this.IDy = bitmap;
    }

    public final Bitmap getCropBitmap() {
        return this.IDy;
    }
}
