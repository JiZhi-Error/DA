package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends q implements m {
    private i callback;
    private d rr = null;
    private bxy yrx = null;
    public bxz yry = null;
    public boolean yrz = true;

    public f(String str, String str2) {
        AppMethodBeat.i(25466);
        if (Util.isNullOrNil(str2)) {
            this.yrz = true;
            str2 = "";
        } else {
            this.yrz = false;
        }
        d.a aVar = new d.a();
        aVar.iLN = new bxy();
        aVar.iLO = new bxz();
        aVar.funcId = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrx = (bxy) this.rr.iLK.iLR;
        this.yrx.Mdu = str;
        this.yrx.Mdv = str2;
        Log.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
        AppMethodBeat.o(25466);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 929;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25467);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25467);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25468);
        Log.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yry = (bxz) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25468);
    }
}
