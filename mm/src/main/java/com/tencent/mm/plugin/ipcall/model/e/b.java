package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    private d rr = null;
    private dfh yrp = null;
    public dfi yrq = null;

    public b(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(25454);
        d.a aVar = new d.a();
        aVar.iLN = new dfh();
        aVar.iLO = new dfi();
        aVar.funcId = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrp = (dfh) this.rr.iLK.iLR;
        this.yrp.MKj = str;
        this.yrp.MKl = str2;
        this.yrp.MKn = str3;
        this.yrp.MKm = str4;
        this.yrp.MKo = i2;
        Log.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", str, str2, str3, str4, Integer.valueOf(i2));
        AppMethodBeat.o(25454);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 807;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25455);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25455);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25456);
        Log.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrq = (dfi) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25456);
    }
}
