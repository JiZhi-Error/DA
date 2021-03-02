package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class o extends q implements m {
    private i callback;
    public d rr;

    public o(String str, LinkedList<cla> linkedList) {
        AppMethodBeat.i(5596);
        d.a aVar = new d.a();
        aVar.iLN = new cld();
        aVar.iLO = new cle();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        aVar.funcId = 1030;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cld cld = (cld) this.rr.iLK.iLR;
        cld.Mis = str;
        cld.MqA = linkedList;
        AppMethodBeat.o(5596);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5597);
        Log.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(5597);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1030;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5598);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5598);
        return dispatch;
    }
}
