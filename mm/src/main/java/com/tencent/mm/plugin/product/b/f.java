package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.z;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f extends q implements m {
    private i callback;
    private d rr;

    public f(LinkedList<dqn> linkedList, String str) {
        int i2 = 0;
        AppMethodBeat.i(66888);
        d.a aVar = new d.a();
        aVar.iLN = new tl();
        aVar.iLO = new tm();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        aVar.funcId = z.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        tl tlVar = (tl) this.rr.iLK.iLR;
        tlVar.LbZ = linkedList;
        tlVar.APg = linkedList != null ? linkedList.size() : i2;
        tlVar.Lca = str;
        Log.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(str)));
        AppMethodBeat.o(66888);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66889);
        tm tmVar = (tm) ((d) sVar).iLL.iLR;
        if (i4 == 0 && tmVar.KOt != 0) {
            i4 = tmVar.KOt;
            str = tmVar.KOu;
        }
        Log.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66889);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return z.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66890);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66890);
        return dispatch;
    }
}
