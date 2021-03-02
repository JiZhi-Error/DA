package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u extends q implements m {
    private i callback;
    Object data;
    public String iQz;
    public d rr;

    public u(String str, String str2, LinkedList<String> linkedList, Object obj) {
        AppMethodBeat.i(124316);
        d.a aVar = new d.a();
        aVar.iLN = new cdd();
        aVar.iLO = new cde();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        aVar.funcId = 1389;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cdd cdd = (cdd) this.rr.iLK.iLR;
        cdd.Lpg = str;
        cdd.MiU = str2 == null ? "" : str2;
        cdd.MiV = linkedList;
        this.data = obj;
        AppMethodBeat.o(124316);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124317);
        Log.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124317);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1389;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124318);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124318);
        return dispatch;
    }

    public final cde baF() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (cde) this.rr.iLL.iLR;
    }
}
