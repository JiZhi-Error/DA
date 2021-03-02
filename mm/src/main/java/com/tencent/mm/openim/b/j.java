package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private i callback;
    public String dVa;
    private final d rr;

    public j(String str) {
        AppMethodBeat.i(151206);
        d.a aVar = new d.a();
        aVar.iLN = new bru();
        aVar.iLO = new brv();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenurl";
        aVar.funcId = 913;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", str);
        ((bru) this.rr.iLK.iLR).userName = str;
        AppMethodBeat.o(151206);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151207);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151207);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 913;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151208);
        Log.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.dVa = ((brv) this.rr.iLL.iLR).dVa;
            Log.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", this.dVa);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(151208);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151208);
    }
}
