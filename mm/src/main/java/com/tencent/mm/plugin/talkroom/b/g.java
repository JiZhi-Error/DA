package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.b.c;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.protocal.protobuf.egv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g extends q implements m {
    private i callback;
    private final d rr;

    public g(LinkedList<egt> linkedList, int i2) {
        AppMethodBeat.i(29567);
        d.a aVar = new d.a();
        aVar.iLN = new egu();
        aVar.iLO = new egv();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.funcId = c.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        egu egu = (egu) this.rr.iLK.iLR;
        egu.NgF = linkedList.size();
        egu.NgG = linkedList;
        egu.Scene = i2;
        AppMethodBeat.o(29567);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(29568);
        Log.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29568);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29569);
        Log.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29569);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29569);
    }
}
