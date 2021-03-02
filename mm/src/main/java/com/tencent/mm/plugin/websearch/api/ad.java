package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad extends q implements m {
    private String IEd;
    private i callback;
    public d iUB;
    private int scene;

    public ad(doc doc) {
        AppMethodBeat.i(117641);
        d.a aVar = new d.a();
        aVar.funcId = 1134;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.iLN = doc;
        aVar.iLO = new dod();
        this.iUB = aVar.aXF();
        this.scene = doc.Scene;
        this.IEd = doc.MRe;
        AppMethodBeat.o(117641);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117642);
        Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            ar.afB(6);
            ar.a(this.scene, 5, i3, i4, this.IEd);
            AppMethodBeat.o(117642);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        ar.afB(7);
        AppMethodBeat.o(117642);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1134;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117643);
        Log.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", Integer.valueOf(this.scene));
        ar.afB(5);
        ar.O(this.scene, 4, this.IEd);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(117643);
        return dispatch;
    }
}
