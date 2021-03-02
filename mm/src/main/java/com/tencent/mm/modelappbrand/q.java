package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class q extends com.tencent.mm.ak.q implements m {
    private i heq;
    private final d iIu;

    public q(LinkedList<eft> linkedList) {
        AppMethodBeat.i(121053);
        d.a aVar = new d.a();
        aVar.iLN = new lf();
        aVar.iLO = new lg();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iIu = aVar.aXF();
        ((lf) this.iIu.iLK.iLR).KPa = linkedList;
        AppMethodBeat.o(121053);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(121054);
        Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(121054);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1176;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(121055);
        Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.iIu, this);
        AppMethodBeat.o(121055);
        return dispatch;
    }
}
