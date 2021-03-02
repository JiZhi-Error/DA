package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private d rr;
    private int type;
    private long uOV = System.currentTimeMillis();

    public c(int i2, long j2, int i3) {
        AppMethodBeat.i(91008);
        this.type = i2;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/getcolikeblocklist";
        aVar.iLN = new blm();
        aVar.iLO = new bln();
        this.rr = aVar.aXF();
        blm blm = (blm) this.rr.iLK.iLR;
        blm.oUv = i2;
        blm.LRV = j2;
        blm.KZk = i3;
        Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "request NetSceneTopStoryGetBlockList: %d %d %d", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
        AppMethodBeat.o(91008);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2748;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(91009);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91009);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91010);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryGetBlockList", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91010);
    }

    public final bln fya() {
        return (bln) this.rr.iLL.iLR;
    }
}
