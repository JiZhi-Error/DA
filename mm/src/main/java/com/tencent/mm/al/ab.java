package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab extends q implements m {
    public String brandUsername;
    private i callback;
    public d rr;

    public ab(String str, String str2) {
        AppMethodBeat.i(124135);
        d.a aVar = new d.a();
        aVar.iLN = new cfo();
        aVar.iLO = new cfp();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        aVar.funcId = 674;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cfo cfo = (cfo) this.rr.iLK.iLR;
        cfo.MlA = str;
        cfo.MlB = str2;
        this.brandUsername = str;
        AppMethodBeat.o(124135);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124136);
        Log.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124136);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 674;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124137);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124137);
        return dispatch;
    }

    public final cfp bac() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (cfp) this.rr.iLL.iLR;
    }
}
