package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends q implements m {
    private i callback;
    private final d rr;

    public f(String str) {
        AppMethodBeat.i(21952);
        Log.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, Util.getStack());
        d.a aVar = new d.a();
        aVar.iLN = new blp();
        aVar.iLO = new blq();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.funcId = 595;
        this.rr = aVar.aXF();
        ((blp) this.rr.iLK.iLR).URL = str;
        AppMethodBeat.o(21952);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 595;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(21953);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(21953);
        return dispatch;
    }

    public final blq chs() {
        return (blq) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(21954);
        Log.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            blq blq = (blq) this.rr.iLL.iLR;
            com.tencent.mm.plugin.backup.b.d.aS(blq.KLU.getBuffer().zy);
            Log.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", blq.ID, blq.KML, blq.KMM, blq.KME, blq.KMF, Integer.valueOf(blq.Scene));
            Log.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", blq.LUt);
            blq.KLU.getBuffer();
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(21954);
    }
}
