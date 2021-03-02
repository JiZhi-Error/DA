package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class j extends q implements m {
    public String AYZ;
    public LinkedList<akg> AZk;
    public LinkedList<bd> AZl;
    private i callback;
    private d rr;

    public j(LinkedList<dqn> linkedList, int i2) {
        int i3 = 0;
        AppMethodBeat.i(66900);
        d.a aVar = new d.a();
        aVar.iLN = new ded();
        aVar.iLO = new dee();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        aVar.funcId = 554;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ded ded = (ded) this.rr.iLK.iLR;
        ded.LbZ = linkedList;
        ded.APg = linkedList != null ? linkedList.size() : i3;
        ded.MJj = i2;
        AppMethodBeat.o(66900);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66901);
        dee dee = (dee) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0 && dee.KOt == 0) {
            Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + dee.LXb);
            Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + dee.Lca);
            this.AZk = dee.MJk;
            this.AYZ = dee.Lca;
            this.AZl = dee.MJl;
        }
        if (i4 == 0 && dee.KOt != 0) {
            i4 = dee.KOt;
            str = dee.KOu;
        }
        Log.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66901);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 554;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66902);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66902);
        return dispatch;
    }
}
