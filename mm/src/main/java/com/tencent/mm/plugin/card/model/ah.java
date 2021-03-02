package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dng;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends q implements m {
    private i callback;
    private final d rr;

    public ah(LinkedList<cxh> linkedList) {
        AppMethodBeat.i(112858);
        d.a aVar = new d.a();
        aVar.iLN = new dng();
        aVar.iLO = new dnh();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        aVar.funcId = 1275;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dng) this.rr.iLK.iLR).MQA = linkedList;
        if (linkedList != null) {
            Iterator<cxh> it = linkedList.iterator();
            while (it.hasNext()) {
                cxh next = it.next();
                Log.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", next.eaO, next.pTM, Integer.valueOf(next.MBP), Integer.valueOf(next.MBQ));
            }
        }
        AppMethodBeat.o(112858);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112859);
        Log.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112859);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1275;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112860);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112860);
        return dispatch;
    }
}
