package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i heq;
    public final d rr;
    public Object tag;

    public q(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(78888);
        Log.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", str, str2, Integer.valueOf(i2), Integer.valueOf(i3));
        d.a aVar = new d.a();
        aVar.iLN = new bto();
        aVar.iLO = new btp();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        aVar.funcId = 673;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bto bto = (bto) this.rr.iLK.iLR;
        bto.URL = str;
        bto.Mae = str2;
        bto.Width = i2;
        bto.Height = i3;
        AppMethodBeat.o(78888);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78889);
        Log.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i3 + ", errCode = " + i4);
        this.heq.onSceneEnd(i3, i4, str, this);
        if (i3 == 0 && i4 == 0) {
            AppMethodBeat.o(78889);
            return;
        }
        Log.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i3 + ", errCode = " + i4);
        AppMethodBeat.o(78889);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 673;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78890);
        Log.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78890);
        return dispatch;
    }
}
