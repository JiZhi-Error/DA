package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class e extends q implements m {
    private eit GjJ;
    private i callback;
    public d rr;

    public e(eit eit, List<String> list) {
        AppMethodBeat.i(91011);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "Create NetSceneTopStoryGetVideoUrl Video");
        this.GjJ = eit;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/recommendgetvideourl";
        aVar.iLN = new dkx();
        aVar.iLO = new dky();
        this.rr = aVar.aXF();
        dkx dkx = (dkx) this.rr.iLK.iLR;
        for (String str : list) {
            ado ado = new ado();
            ado.pLq = str;
            dkx.MOR.add(ado);
        }
        AppMethodBeat.o(91011);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2579;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(91012);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91012);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91013);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryGetVideoUrl", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91013);
    }
}
