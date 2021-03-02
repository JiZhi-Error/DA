package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private i callback;
    Object data;
    public String iQz;
    public d rr;

    public n(String str, String str2, String str3, Object obj) {
        AppMethodBeat.i(124295);
        d.a aVar = new d.a();
        aVar.iLN = new adr();
        aVar.iLO = new ads();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        aVar.funcId = 1315;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        adr adr = (adr) this.rr.iLK.iLR;
        adr.Lpg = str;
        adr.Lpi = str2;
        adr.Lph = str3;
        this.data = obj;
        AppMethodBeat.o(124295);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124296);
        Log.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124296);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1315;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124297);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124297);
        return dispatch;
    }

    public final ads baC() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (ads) this.rr.iLL.iLR;
    }
}
