package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab extends q implements m {
    int JWw;
    aa JWx;
    private i callback;
    private d rr;

    public ab(int i2, aa aaVar) {
        AppMethodBeat.i(151804);
        this.JWw = i2;
        d.a aVar = new d.a();
        aVar.iLN = new et();
        aVar.iLO = new eu();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        aVar.funcId = 452;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        et etVar = (et) this.rr.iLK.iLR;
        byte[] gmB = aaVar.gmB();
        if (gmB != null) {
            etVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(gmB);
        }
        etVar.oUv = i2;
        this.JWx = aaVar;
        AppMethodBeat.o(151804);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151805);
        Log.d("MicroMsg.NetSceneAppCenter", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            this.JWx.cB(z.a(((eu) this.rr.iLL.iLR).KIk));
            this.JWx.onGYNetEnd(i2, i3, i4, str, this.rr, bArr);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(151805);
            return;
        }
        Log.e("MicroMsg.NetSceneAppCenter", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151805);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 452;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151806);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151806);
        return dispatch;
    }
}
