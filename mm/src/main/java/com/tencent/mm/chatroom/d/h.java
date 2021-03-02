package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends q implements m {
    private i callback;
    private LinkedList<caa> dSP;
    private final d rr;

    public h(LinkedList<caa> linkedList) {
        AppMethodBeat.i(12458);
        this.dSP = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = new abx();
        aVar.iLO = new aby();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        aVar.funcId = 181;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        abx abx = (abx) this.rr.iLK.iLR;
        abx.LmA = linkedList;
        abx.Lmz = linkedList.size();
        AppMethodBeat.o(12458);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12459);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12459);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 181;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12460);
        updateDispatchId(i2);
        Log.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (sVar.getRespObj().getRetCode() != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(12460);
            return;
        }
        if (this.dSP != null) {
            Iterator<caa> it = this.dSP.iterator();
            while (it.hasNext()) {
                caa next = it.next();
                Log.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + next.Mfw);
                v.HZ(next.Mfw);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12460);
    }
}
