package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvy;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    public d rr;

    public c(String str, int i2) {
        AppMethodBeat.i(26907);
        d.a aVar = new d.a();
        aVar.iLN = new dvy();
        aVar.iLO = new dvz();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        aVar.funcId = 1363;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dvy dvy = (dvy) this.rr.iLK.iLR;
        dvy.KTt = str;
        dvy.MWH = i2;
        dvy.MWI = 4;
        AppMethodBeat.o(26907);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26908);
        Log.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(26908);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1363;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26909);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26909);
        return dispatch;
    }
}
